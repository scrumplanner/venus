package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update community set is_deleted = true where id = ?")
@Where(clause = "is_deleted is not true")
public class Community extends BaseEntity {
    private String name;

    @OneToMany()
    private List<Role> role;

    @OneToMany(mappedBy = "community")
    private List<CommunityUser> communityUser;
}
