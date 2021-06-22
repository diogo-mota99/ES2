package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Funcionario;
import SpringWebMVC.ES2.DAL.Quinta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class QuintaController {

    @GetMapping("/quinta")
    public ModelAndView home() {

        ModelAndView mview = null;
        Funcionario funcionario = DashboardController.f;

        if (funcionario != null) {
            List<Quinta> listaQuintasByEmpresa = SpringWebMVC.ES2.BLL.Quinta.readQuintaByEmpresaByEstado(funcionario.getIdEmpresa().getIdEmpresa());

            if (!listaQuintasByEmpresa.isEmpty()) {
                mview = new ModelAndView("quinta");
                mview.addObject("listaQuintas", listaQuintasByEmpresa);
            }
        } else {
            mview = new ModelAndView("redirect:/index");
        }


        return mview;
    }

    @PostMapping("/addQuinta")
    public ModelAndView addQuinta(HttpServletRequest request) {
        ModelAndView mview;

        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        String area = request.getParameter("area");
        String localizacao = request.getParameter("localizacao");

        SpringWebMVC.ES2.BLL.Quinta.adicionarQuinta(area, localizacao, idEmpresa);

        mview = new ModelAndView("redirect:/quinta");

        return mview;
    }

    @PostMapping("/updateQuinta")
    public ModelAndView updateQuinta(HttpServletRequest request) {
        ModelAndView mview;

        String idQuinta = request.getParameter("selectQuinta");
        int idQuintaInt = Integer.parseInt(idQuinta);
        String area = request.getParameter("areaEdit");
        String localizacao = request.getParameter("localizacaoEdit");

        SpringWebMVC.ES2.BLL.Quinta.updateQuinta(idQuintaInt, localizacao, area);

        mview = new ModelAndView("redirect:/quinta");

        return mview;
    }

    @PostMapping("/removeQuinta")
    public ModelAndView deleteQuinta(HttpServletRequest request) {
        ModelAndView mview;

        String idQuinta = request.getParameter("selectQuintaRemove");
        int idQuintaInt = Integer.parseInt(idQuinta);
        SpringWebMVC.ES2.BLL.Quinta.removeQuinta(idQuintaInt);

        mview = new ModelAndView("redirect:/quinta");

        return mview;
    }
}
