package tr.scrumplanner.venus.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.LoginRequest;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.LoginResponse;
import tr.scrumplanner.venus.model.response.UserResponse;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    User getUserByEmail(String email);

    void signup(SignupRequest signupRequest);

    LoginResponse login(LoginRequest loginRequest);


    List<UserResponse> getAll();

}
