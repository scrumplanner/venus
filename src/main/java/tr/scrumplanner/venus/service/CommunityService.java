package tr.scrumplanner.venus.service;

import tr.scrumplanner.venus.model.request.*;
import tr.scrumplanner.venus.model.response.CommunityResponse;

import java.util.List;

public interface CommunityService {
    CommunityResponse add(AddCommunityRequest addCommunityRequest);
    CommunityResponse update(Long id, UpdateCommunityRequest updateCommunityRequest);
    void deleteById(Long id);
    List<CommunityResponse> getAll();
    List<CommunityResponse> getByUserId(Long userId);
    CommunityResponse getById(Long id);

    CommunityResponse addCommunityRole(AddCommunityRoleRequest addCommunityRoleRequest);
    CommunityResponse updateCommunityRole(UpdateCommunityRoleRequest updateCommunityRoleRequest);
    void deleteCommunityRole(Long communityId, Long roleId);

    CommunityResponse addCommunityUser(AddCommunityUserRequest addCommunityUserRequest);
    CommunityResponse updateCommunityUser(UpdateCommunityUserRequest updateCommunityUserRequest);
    void deleteCommunityUser(Long communityId, Long userId);

}
