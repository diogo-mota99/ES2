/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringWebMVC.ES2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author diogo
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mview;

        if (DashboardController.f == null) {
            Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

            mview = new ModelAndView("index");

            if (inputFlashMap != null) {
                String msg = (String) inputFlashMap.get("msg");
                mview.addObject("msg", msg);
            }
        } else {
            mview = new ModelAndView("redirect:/dashboard");
        }

        return mview;
    }
}
