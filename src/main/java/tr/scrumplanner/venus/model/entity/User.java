package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SQLDelete(sql = "update users set is_deleted = true where id = ?")
@Where(clause = "is_deleted is not true")
public class User extends BaseEntity {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<CommunityUser> communityUsers;

    // todo: srht -> log ekle
}