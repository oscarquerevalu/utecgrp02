package pe.utec.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "locations", schema = "shows")
public class Location {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String ubigeo;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;
    @Column
    private String created_by;

    @Column
    private LocalDateTime created_at;

    @Column(length = 100)
    private String last_updated_by;

    @Column
    private LocalDateTime last_updated_at;

}
