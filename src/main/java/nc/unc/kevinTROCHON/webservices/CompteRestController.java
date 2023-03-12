package nc.unc.kevinTROCHON.webservices;

import io.swagger.annotations.ApiOperation;
import nc.unc.kevinTROCHON.entities.Compte;
import nc.unc.kevinTROCHON.repositories.CompteRepository;
import nc.unc.kevinTROCHON.services.CompteServiceImpl;
import nc.unc.kevinTROCHON.webservices.dtos.CompteDto;
import nc.unc.kevinTROCHON.webservices.mapper.CompteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
public class CompteRestController {

    @Autowired
    private CompteRepository repository;

    @Autowired
    private CompteMapper mapper;

    @Autowired
    private CompteServiceImpl service;

    @ApiOperation(value = "Liste de tous les comptes.")
    @GetMapping(value = "/comptes")
    public List<CompteDto> getAllCompte(){
        List<Compte> comptes = repository.findAll();
        return mapper.toDtos(comptes);
    }

    @ApiOperation(value = "Le compte d'un utilisateur.")
    @GetMapping(value = "/comptes/{id}")
    public CompteDto getCompte(@RequestParam("id")Long numeroCompte){
        Compte compte = repository.getReferenceById(numeroCompte);
        return mapper.toDto(compte);
    }

    @ApiOperation(value = "Création d'un compte.")
    @PostMapping(value = "/comptes")
    public void setCompte(CompteDto compteDto){
        repository.save(mapper.toEntity(compteDto));
    }

    @ApiOperation(value = "Mise à jour du compte de l'utilisateur")
    @PatchMapping(value = "/comptes/{id}")
    public void updateSolde(double newSolde,@RequestParam("id")Long numeroCompte){
        CompteDto monCompte = this.getCompte(numeroCompte);
        monCompte.setSolde(newSolde);
        repository.save(mapper.toEntity(monCompte));
    }

    @ApiOperation(value = "Virement d'un compte à un autre.")
    @PostMapping(value = "/comptes/virements/{id1}&&{id2}")
    public void virement(@RequestParam("id1")Long source, @RequestParam(value = "id2")Long destination,double montant){
        service.virement(source,destination,montant);
    }
}
