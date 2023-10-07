package tr.scrumplanner.venus.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.scrumplanner.venus.model.request.LoginRequest;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.UserResponse;
import tr.scrumplanner.venus.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest signupRequest) {
        userService.signup(signupRequest);
    }

    @GetMapping("/get-all")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

}
