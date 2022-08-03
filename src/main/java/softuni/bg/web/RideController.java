package softuni.bg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.PublishRideDto;
import softuni.bg.service.RideService;

import javax.validation.Valid;

@Controller
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/publish")
    public String publishRide(Model model) {

        if (!model.containsAttribute("publishRideModel")) {
            model.addAttribute("publishRideModel", new PublishRideDto());
        }

        return "publish-ride";
    }

    @PostMapping("/publish")
    public String publishRideConfirm(@Valid PublishRideDto publishRideModel, BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("publishRideModel", publishRideModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.publishRideModel",
                            bindingResult);

            return "redirect:publish";
        }

//        this.rideService.saveRide(publishRideModel);

        return "redirect:/";
    }
}
