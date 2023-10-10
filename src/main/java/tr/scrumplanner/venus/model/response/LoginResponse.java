package tr.scrumplanner.venus.model.response;

import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String email;
    private String token;
}
