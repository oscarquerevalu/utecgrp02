package pe.utec.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDTO {

    private Integer idLocation;
    private String ubigeo;
    private String name;
    private String description;
    private String created_by;
    private LocalDateTime created_at;
    private String last_updated_by;
    private LocalDateTime last_updated_at;
}
