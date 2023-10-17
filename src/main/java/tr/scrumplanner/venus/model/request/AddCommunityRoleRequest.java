package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddCommunityRoleRequest {
    @NotNull
    private Long communityId;
    @NotNull
    private String roleName;
}
