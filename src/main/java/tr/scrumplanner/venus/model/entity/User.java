package tr.scrumplanner.venus.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Where(clause = "is_deleted is not true")
@SQLDelete(sql = "update users set is_deleted = true where id = ?")
public class User extends BaseEntity {

    private String email;
    private String password;
}