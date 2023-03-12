package nc.unc.kevinTROCHON.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nc.unc.kevinTROCHON.entities.enums.TypeCompte;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "compte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long numeroCompte;

    @Column(name = "solde",nullable = false)
    private double solde;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;
}
