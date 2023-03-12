package nc.unc.kevinTROCHON.webservices.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nc.unc.kevinTROCHON.entities.enums.TypeCompte;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteDto {
    @ApiModelProperty(notes = "Solde du compte",example="25000",required = true)
    private double solde;
    @ApiModelProperty(notes = "Date de création du compte",example="2023-12-31",required = true)
    private Date dateCreation;
    @ApiModelProperty(notes = "Type de compte",example="EPARGNE",required = true)
    private TypeCompte typeCompte;
}
