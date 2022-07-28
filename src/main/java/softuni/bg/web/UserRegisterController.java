package softuni.bg.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.model.dto.UserRegisterDto;
import softuni.bg.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegisterDto initUserModel () {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDto userModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userModel", userModel);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                            bindingResult);

            // TODO: 20.7.2022 г. register user in database

            return "redirect:register";
        }

        return "redirect:users/login";
    }
}
