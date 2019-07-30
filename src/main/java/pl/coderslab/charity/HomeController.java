package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.InstitutionRepository;


@Controller
public class HomeController {
    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;

    @Autowired
    public HomeController(InstitutionRepository institutionRepository,
                          DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("numberOfInstitutions", donationRepository.countDistinctInstitutions());
        //only institutions that received at least one donation
        model.addAttribute("numberOfDonations", donationRepository.sumQuantity());
        return "index";
    }
}
