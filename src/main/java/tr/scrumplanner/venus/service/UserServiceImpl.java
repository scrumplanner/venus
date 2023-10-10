package tr.scrumplanner.venus.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.scrumplanner.venus.mapper.UserMapper;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.LoginRequest;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.LoginResponse;
import tr.scrumplanner.venus.model.response.UserResponse;
import tr.scrumplanner.venus.repository.UserRepository;
import tr.scrumplanner.venus.util.JwtUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            @Lazy PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username).map(user ->
            new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>())
        )
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void signup(SignupRequest signupRequest) {
        User user = userMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword(), new ArrayList<>()));
        if (!authenticate.isAuthenticated()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = getUserByEmail(loginRequest.getEmail());
        String token = JwtUtil.generateToken(user.getEmail());
        return null;
    }

    @Override
    public List<UserResponse> getAll() {
        return userMapper.toResponse(userRepository.findAll());
    }
}