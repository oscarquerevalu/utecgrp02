package pe.utec.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDetailDTO {

    @JsonBackReference
    private SaleDTO sale;

    @JsonIncludeProperties(value= {"idShow", "name"})
    private ShowDTO show;

    @JsonIncludeProperties(value= {"idEventZone", "name"})
    private EventZoneDTO eventZone;
    private short quantity;
    private double salePrice;
    private double discount;
}
