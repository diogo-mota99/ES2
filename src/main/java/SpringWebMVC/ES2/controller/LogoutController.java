package SpringWebMVC.ES2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mview;

        DashboardController.f = null;

        mview = new ModelAndView("redirect:/index");

        return mview;
    }
}
