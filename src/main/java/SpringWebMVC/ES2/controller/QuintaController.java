package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Quinta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class QuintaController {

    @RequestMapping("/quinta")
    public ModelAndView home(HttpServletResponse response) throws IOException {

        ModelAndView mview = null;

        List<Quinta> listaQuintas = SpringWebMVC.ES2.BLL.Quinta.readAllQuintas();

        if (!listaQuintas.isEmpty()) {
            mview = new ModelAndView("quinta");
            mview.addObject("listaQuintas", listaQuintas);
        }


        return mview;
    }

    @PostMapping("/addQuinta")
    public ModelAndView addQuinta(HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelAndView mview = null;

        String area = request.getParameter("area");
        String localizacao = request.getParameter("localizacao");

        return mview;
    }
}
