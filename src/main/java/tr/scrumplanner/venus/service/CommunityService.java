package tr.scrumplanner.venus.service;

import tr.scrumplanner.venus.model.request.*;
import tr.scrumplanner.venus.model.response.CommunityResponse;

import java.util.List;

public interface CommunityService {
    void add(AddCommunityRequest addCommunityRequest);
    void update(UpdateCommunityRequest updateCommunityRequest);
    void deleteById(Long id);
    List<CommunityResponse> getAll();
    List<CommunityResponse> getByUserId(Long userId);
    CommunityResponse getById(Long id);

    void addCommunityRole(AddCommunityRoleRequest addCommunityRoleRequest);
    void updateCommunityRole(UpdateCommunityRoleRequest updateCommunityRoleRequest);
    void deleteCommunityRole(Long communityId, Long roleId);

    void addCommunityUser(AddCommunityUserRequest addCommunityUserRequest);
    void updateCommunityUser(UpdateCommunityUserRequest updateCommunityUserRequest);
    void deleteCommunityUser(Long communityId, Long userId);

}
