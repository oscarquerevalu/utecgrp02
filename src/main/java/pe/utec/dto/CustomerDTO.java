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
public class CustomerDTO {

    private Integer idCustomer;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private LocalDateTime birthdate;
    private RoleDTO role;
}
