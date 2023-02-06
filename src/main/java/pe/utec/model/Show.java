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
@Table(name = "shows", schema = "shows")
public class Show {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate dateShow;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Integer capacity;

    @Column
    private String created_by;

    @Column
    private LocalDateTime created_at;

    @Column(length = 100)
    private String last_updated_by;

    @Column
    private LocalDateTime last_updated_at;

    @ManyToOne
    @JoinColumn(name = "id_locations", nullable = false)
    private Location location;

}
