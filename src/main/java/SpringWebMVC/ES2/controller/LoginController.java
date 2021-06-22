/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author diogo
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    protected ModelAndView handleRequestInternal(HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Funcionario funcionario = null;
        String msg = "";
        ModelAndView mview;


        if (!username.equals("admin")) {
            msg = "erroAdmin";
            mview = new ModelAndView("redirect:/index");
            mview.addObject(msg);
        } else {
            funcionario = SpringWebMVC.ES2.BLL.Funcionario.funcionarioLogin(
                    username, password
            );
        }

        if (funcionario == null) {
            msg = "erroLogin";
            mview = new ModelAndView("redirect:/index");
            redirectAttributes.addFlashAttribute("msg", msg);
        } else {
            mview = new ModelAndView("redirect:/dashboard");
            redirectAttributes.addFlashAttribute("funcionario", funcionario);
        }


        return mview;
    }
}
