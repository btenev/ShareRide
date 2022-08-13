package softuni.bg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.service.UserService;

@Controller
@RequestMapping("/pages/admins")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAdminPage() {

        return "admin-page";
    }


}
