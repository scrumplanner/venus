package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddCommunityRequest {
    @NotNull
    private String name;
}
