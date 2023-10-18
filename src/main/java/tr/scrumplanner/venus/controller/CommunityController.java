package tr.scrumplanner.venus.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.scrumplanner.venus.model.request.AddCommunityRequest;
import tr.scrumplanner.venus.model.request.UpdateCommunityRequest;
import tr.scrumplanner.venus.model.response.CommunityResponse;
import tr.scrumplanner.venus.service.CommunityService;

import java.util.List;

@RestController
@RequestMapping("api/v1/community")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class CommunityController {
    private final CommunityService communityService;

    @GetMapping
    public List<CommunityResponse> getAll() {
        return communityService.getAll();
    }
    @PostMapping
    public CommunityResponse add(@RequestBody @Valid AddCommunityRequest addCommunityRequest) {
        return communityService.add(addCommunityRequest);
    }
    @PutMapping("/{id}")
    public CommunityResponse update(@PathVariable Long id, @RequestBody @Valid UpdateCommunityRequest updateCommunityRequest) {
        return communityService.update(id, updateCommunityRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        communityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CommunityResponse getById(@PathVariable Long id) {
        return communityService.getById(id);
    }
}
