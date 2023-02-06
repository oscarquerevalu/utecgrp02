package pe.utec.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "event_zone", schema = "shows")
public class EventZone {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_shows", nullable = false)
    private Show show;

}
