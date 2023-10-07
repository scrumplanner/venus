package tr.scrumplanner.venus.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.LoginRequest;
import tr.scrumplanner.venus.service.UserService;
import tr.scrumplanner.venus.util.JwtUtil;

import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final UserService userService;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException("attemptAuthentication error" + e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = userService.getUserByEmail(((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername());

        String token = JwtUtil.generateToken(user.getEmail());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", user.getId());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("token", token);
        String res = jsonObject.toString();

        response.addHeader(HttpHeaders.AUTHORIZATION, token);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(res);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
