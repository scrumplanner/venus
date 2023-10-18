package tr.scrumplanner.venus.mapper;

import org.mapstruct.*;
import tr.scrumplanner.venus.model.entity.Community;
import tr.scrumplanner.venus.model.request.AddCommunityRequest;
import tr.scrumplanner.venus.model.request.UpdateCommunityRequest;
import tr.scrumplanner.venus.model.response.CommunityResponse;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommunityMapper {
    Community toEntity(AddCommunityRequest addCommunityRequest);
    CommunityResponse toResponse(Community community);

    List<CommunityResponse> toResponse(List<Community> community);

    Community toConvert(UpdateCommunityRequest updateCommunityRequest, @MappingTarget Community community);
}
