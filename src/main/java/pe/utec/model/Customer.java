package pe.utec.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "customers", schema = "customers")
public class Customer {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime birthdate;

    @Column(length = 100)
    private String created_by;

    @Column
    private String created_at;

    @Column(length = 100)
    private String last_updated_by;

    @Column
    private String last_updated_at;

    @ManyToOne //FK
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey(name = "FK_User_Role"))
    private Role role;

    @Column(length = 60, nullable = false)
    private String password;
}
