package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT sum(d.quantity) from Donation d")
    int sumQuantity();

    @Query("SELECT count(DISTINCT d.institution) from Donation d")
    int  countDistinctInstitutions();
}
