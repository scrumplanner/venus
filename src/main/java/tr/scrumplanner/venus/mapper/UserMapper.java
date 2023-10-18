package tr.scrumplanner.venus.mapper;

import org.mapstruct.*;
import tr.scrumplanner.venus.model.entity.User;
import tr.scrumplanner.venus.model.request.SignupRequest;
import tr.scrumplanner.venus.model.response.UserResponse;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);
    UserResponse toResponse(User user);
    List<UserResponse> toResponse(List<User> user);

}
