package tr.scrumplanner.venus.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.UserResponse;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    User getUserByEmail(String email);
    void signup(SignupRequest signupRequest);
    List<UserResponse> getAll();
}
