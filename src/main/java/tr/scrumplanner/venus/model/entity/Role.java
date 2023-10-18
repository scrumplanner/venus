package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@SQLDelete(sql = "update role set is_deleted = true where id = ?")
@Where(clause = "is_deleted is not true")
public class Role extends BaseEntity {
    private String name;
}