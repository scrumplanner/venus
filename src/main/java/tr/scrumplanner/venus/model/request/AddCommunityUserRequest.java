package tr.scrumplanner.venus.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddCommunityUserRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long communityId;
    @NotNull
    private Long communityRoleId;
}
