package tr.scrumplanner.venus.model.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String password;
}
