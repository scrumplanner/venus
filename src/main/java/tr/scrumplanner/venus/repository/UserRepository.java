package tr.scrumplanner.venus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.scrumplanner.venus.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
