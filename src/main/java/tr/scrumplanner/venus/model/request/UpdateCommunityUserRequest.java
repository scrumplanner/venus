package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCommunityUserRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long communityId;
    private Long communityRoleId;
}
