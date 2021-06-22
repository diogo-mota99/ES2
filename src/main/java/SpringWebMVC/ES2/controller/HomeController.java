/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author diogo
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public ModelAndView home() {
        ModelAndView mview;

        if (DashboardController.f == null) {
            mview = new ModelAndView("index");
        } else {
            mview = new ModelAndView("redirect:/dashboard");
        }

        return mview;
    }
}
