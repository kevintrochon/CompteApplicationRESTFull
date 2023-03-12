package nc.unc.kevinTROCHON.services;

import nc.unc.kevinTROCHON.entities.Compte;
import nc.unc.kevinTROCHON.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService{

    @Autowired
    private CompteRepository repository;

    @Override
    public void virement(Long source, Long destination, double montant) {
        Compte compteSource = repository.getReferenceById(source);
        Compte compteDestination = repository.getReferenceById(destination);
        compteDestination.setSolde(compteDestination.getSolde() + montant);
        compteSource.setSolde(compteSource.getSolde() - montant);
        repository.save(compteSource);
        repository.save(compteDestination);
    }
}
