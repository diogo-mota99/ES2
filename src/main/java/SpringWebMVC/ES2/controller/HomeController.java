/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author diogo
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "/index"})
    public ModelAndView home(HttpServletResponse response) throws IOException {
        return new ModelAndView("index");
    }
}
