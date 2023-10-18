package tr.scrumplanner.venus.model.response;

import lombok.Data;
import tr.scrumplanner.venus.model.entity.CommunityUser;

import java.util.List;

@Data
public class CommunityResponse {
    private Long id;
    private String name;
    private List<CommunityUser> communityUsers;
}
