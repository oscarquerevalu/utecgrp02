package pe.utec.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDTO {

    private Integer idShow;
    private String name;
    private String description;
    private LocalDate dateShow;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private String created_by;
    private LocalDateTime created_at;
    private String last_updated_by;
    private LocalDateTime last_updated_at;
    @JsonIncludeProperties(value= {"idLocation", "name"})
    private LocationDTO location;
}
