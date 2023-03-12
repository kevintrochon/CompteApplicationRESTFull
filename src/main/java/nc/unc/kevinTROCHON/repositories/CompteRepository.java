package nc.unc.kevinTROCHON.repositories;

import nc.unc.kevinTROCHON.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
