package nc.unc.kevinTROCHON.webservices.mapper;

import nc.unc.kevinTROCHON.entities.Compte;
import nc.unc.kevinTROCHON.webservices.dtos.CompteDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompteMapper {

    public CompteDto toDto(Compte entity){
        return CompteDto.builder()
                .dateCreation(entity.getDateCreation())
                .solde(entity.getSolde())
                .typeCompte(entity.getTypeCompte())
                .build();
    }

    public Compte toEntity(CompteDto dto){
        return Compte.builder()
                .dateCreation(dto.getDateCreation())
                .solde(dto.getSolde())
                .typeCompte(dto.getTypeCompte())
                .build();
    }

    public List<CompteDto> toDtos(List<Compte> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
