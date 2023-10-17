package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update community_user set is_deleted = true where id = ?")
public class CommunityUser extends BaseEntity {
    @ManyToOne
    private Community community;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;
}
