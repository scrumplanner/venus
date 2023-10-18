package tr.scrumplanner.venus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.scrumplanner.venus.model.entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
