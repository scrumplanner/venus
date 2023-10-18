package tr.scrumplanner.venus.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.scrumplanner.venus.mapper.CommunityMapper;
import tr.scrumplanner.venus.model.entity.Community;
import tr.scrumplanner.venus.model.request.*;
import tr.scrumplanner.venus.model.response.CommunityResponse;
import tr.scrumplanner.venus.repository.CommunityRepository;
import tr.scrumplanner.venus.service.CommunityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityMapper communityMapper;

    @Override
    public CommunityResponse add(AddCommunityRequest addCommunityRequest) {
        Community community = communityMapper.toEntity(addCommunityRequest);
        Community save = communityRepository.save(community);
        return communityMapper.toResponse(save);
    }

    @Override
    public CommunityResponse update(Long id, UpdateCommunityRequest updateCommunityRequest) {
        Community oldCommunity = communityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));

        Community newCommunity = communityRepository.save(communityMapper.toConvert(updateCommunityRequest, oldCommunity));

        return communityMapper.toResponse(newCommunity);
    }

    @Override
    public void deleteById(Long id) {
        communityRepository.deleteById(id);
    }

    @Override
    public List<CommunityResponse> getAll() {
        return communityMapper.toResponse(communityRepository.findAll());
    }


    @Override
    public List<CommunityResponse> getByUserId(Long userId) {
        return null;
    }

    @Override
    public CommunityResponse getById(Long id) {
        return  communityMapper.toResponse(communityRepository.findById(id).orElseThrow());
    }

    @Override
    public CommunityResponse addCommunityRole(AddCommunityRoleRequest addCommunityRoleRequest) {
        return null;
    }

    @Override
    public CommunityResponse updateCommunityRole(UpdateCommunityRoleRequest updateCommunityRoleRequest) {
        return null;
    }

    @Override
    public void deleteCommunityRole(Long communityId, Long roleId) {

    }

    @Override
    public CommunityResponse addCommunityUser(AddCommunityUserRequest addCommunityUserRequest) {
        return null;
    }

    @Override
    public CommunityResponse updateCommunityUser(UpdateCommunityUserRequest updateCommunityUserRequest) {
        return null;
    }

    @Override
    public void deleteCommunityUser(Long communityId, Long userId) {

    }
}
