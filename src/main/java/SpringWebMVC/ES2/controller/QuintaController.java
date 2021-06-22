package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Funcionario;
import SpringWebMVC.ES2.DAL.Quinta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class QuintaController {

    @GetMapping("/quinta")
    public ModelAndView home(HttpServletRequest request) {

        ModelAndView mview = null;
        Funcionario funcionario = DashboardController.f;
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (funcionario != null) {
            List<Quinta> listaQuintasByEmpresa = SpringWebMVC.ES2.BLL.Quinta.readQuintaByEmpresaByEstado(funcionario.getIdEmpresa().getIdEmpresa());
            mview = new ModelAndView("quinta");

            if (inputFlashMap != null) {
                String msg = (String) inputFlashMap.get("msg");
                mview.addObject("msg", msg);
            }

            if (!listaQuintasByEmpresa.isEmpty()) {
                mview.addObject("listaQuintas", listaQuintasByEmpresa);
            }
        } else {
            mview = new ModelAndView("redirect:/index");
        }


        return mview;
    }

    @PostMapping("/addQuinta")
    public ModelAndView addQuinta(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        String area = request.getParameter("area");
        String localizacao = request.getParameter("localizacao");

        if (SpringWebMVC.ES2.BLL.Quinta.adicionarQuinta(area, localizacao, idEmpresa)) {
            msg = "sucessoAddQuinta";
        } else {
            msg = "erroAddQuinta";
        }

        mview = new ModelAndView("redirect:/quinta");
        redirectAttributes.addFlashAttribute("msg", msg);
        return mview;
    }

    @PostMapping("/updateQuinta")
    public ModelAndView updateQuinta(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        String idQuinta = request.getParameter("selectQuinta");
        int idQuintaInt = Integer.parseInt(idQuinta);
        String area = request.getParameter("areaEdit");
        String localizacao = request.getParameter("localizacaoEdit");

        if (SpringWebMVC.ES2.BLL.Quinta.updateQuinta(idQuintaInt, localizacao, area)) {
            msg = "sucessoUpdateQuinta";
        } else {
            msg = "erroUpdateQuinta";
        }

        mview = new ModelAndView("redirect:/quinta");
        redirectAttributes.addFlashAttribute("msg", msg);
        return mview;
    }

    @PostMapping("/removeQuinta")
    public ModelAndView deleteQuinta(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        String idQuinta = request.getParameter("selectQuintaRemove");
        int idQuintaInt = Integer.parseInt(idQuinta);
        if (SpringWebMVC.ES2.BLL.Quinta.removeQuinta(idQuintaInt)) {
            msg = "sucessoRemoveQuinta";
        } else {
            msg = "erroRemoveQuinta";
        }

        mview = new ModelAndView("redirect:/quinta");
        redirectAttributes.addFlashAttribute("msg", msg);
        return mview;
    }
}
