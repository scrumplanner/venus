package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequest {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
