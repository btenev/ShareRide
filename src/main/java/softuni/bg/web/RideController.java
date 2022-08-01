package softuni.bg.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.PublishRideDto;

import javax.validation.Valid;

@Controller
@RequestMapping("/rides")
public class RideController {

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
                    .addAttribute("publishRideModel", publishRideModel);

            redirectAttributes
                    .addAttribute("org.springframework.validation.BindingResult.publishRideModel",
                            bindingResult);

            return "redirect:publish";
        }

        return "redirect:index";
    }
}
