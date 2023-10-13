package tr.scrumplanner.venus.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tr.scrumplanner.venus.mapper.UserMapper;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.UserResponse;
import tr.scrumplanner.venus.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            @Lazy PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
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
    public List<UserResponse> getAll() {
        return userMapper.toResponse(userRepository.findAll());
    }
}