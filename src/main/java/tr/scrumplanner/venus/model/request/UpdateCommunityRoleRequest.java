package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCommunityRoleRequest {
    @NotNull
    private Long roleId;
    @NotNull
    private Long communityId;
    private String roleName;
}
