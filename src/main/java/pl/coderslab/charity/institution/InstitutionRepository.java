package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.institution.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
