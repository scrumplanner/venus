package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update role set is_deleted = true where id = ?")
public class Role extends BaseEntity {
    private String name;
}