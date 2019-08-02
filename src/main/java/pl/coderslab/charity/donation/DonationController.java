package pl.coderslab.charity.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionRepository;

@Controller
public class DonationController {
    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;


    @Autowired
    public DonationController(DonationRepository donationRepository,
                             CategoryRepository categoryRepository,
                             InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/donation")
    public String donationForm (Model model){

        Donation donation = new Donation();
        donation.setQuantity(1);
        model.addAttribute("donation", donation);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "donation-form";
    }

    @PostMapping("/donation")
    public String donationFormPost(Donation donation){
        donationRepository.save(donation);
        return "redirect:/";
    }
}
