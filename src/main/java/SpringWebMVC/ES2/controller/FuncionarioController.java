package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Funcionario;
import SpringWebMVC.ES2.DAL.TipoFuncionario;
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
public class FuncionarioController {

    @GetMapping("/funcionario")
    public ModelAndView home(HttpServletRequest request) {

        ModelAndView mview = null;
        Funcionario funcionario = DashboardController.f;
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (funcionario != null) {
            List<Funcionario> listFuncionarioByEmpresa = SpringWebMVC.ES2.BLL.Funcionario.funcionariosByEmpresa(funcionario.getIdEmpresa().getIdEmpresa());
            List<TipoFuncionario> listTipoFuncionario = SpringWebMVC.ES2.BLL.TipoFuncionario.readAllTipoFuncionario();

            mview = new ModelAndView("funcionario");

            if (!listFuncionarioByEmpresa.isEmpty() && !listTipoFuncionario.isEmpty()) {
                mview.addObject("listaFuncionarios", listFuncionarioByEmpresa);
                mview.addObject("listaCargos", listTipoFuncionario);
            }
            if (inputFlashMap != null) {
                String msg = (String) inputFlashMap.get("msg");
                mview.addObject("msg", msg);
            }
        } else {
            mview = new ModelAndView("redirect:/index");
        }


        return mview;
    }

    @PostMapping("/addFuncionario")
    public ModelAndView addFuncionario(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        int cargo = Integer.parseInt(request.getParameter("selectTipoFuncionario"));
        String username = request.getParameter("username");
        String pw = request.getParameter("password");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String tlm = request.getParameter("tlm");
        String rua = request.getParameter("rua");
        int porta = Integer.parseInt(request.getParameter("porta"));
        String codPostal = request.getParameter("codPostal");


        if (SpringWebMVC.ES2.BLL.Funcionario.adicionarFuncionario(idEmpresa, cargo, username, pw, nome, email, tlm, rua, porta, codPostal)) {
            msg = "sucessoAddFunc";
        } else {
            msg = "erroAddFunc";
        }

        mview = new ModelAndView("redirect:/funcionario");
        redirectAttributes.addFlashAttribute("msg", msg);

        return mview;
    }

    @PostMapping("/updateFuncionario")
    public ModelAndView updateFuncionario(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        int idFuncionario = Integer.parseInt(request.getParameter("selectFuncionario"));
        int idCargo = Integer.parseInt(request.getParameter("selectTipoFuncionarioEdit"));
        String pw = request.getParameter("passwordEdit");
        String nome = request.getParameter("nomeEdit");
        String email = request.getParameter("emailEdit");
        String tlm = request.getParameter("tlmEdit");
        String rua = request.getParameter("ruaEdit");
        int porta = Integer.parseInt(request.getParameter("portaEdit"));
        String cp = request.getParameter("codPostalEdit");

        if (SpringWebMVC.ES2.BLL.Funcionario.updateFuncionario(idFuncionario, idCargo, pw, nome, email, tlm, rua, porta, cp)) {
            msg = "sucessoUpdateFunc";
        } else {
            msg = "erroUpdateFunc";
        }

        mview = new ModelAndView("redirect:/funcionario");
        redirectAttributes.addFlashAttribute("msg", msg);

        return mview;
    }

    @PostMapping("/removeFuncionario")
    public ModelAndView deleteFuncionario(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mview;
        String msg = "";

        String idFuncionario = request.getParameter("selectFuncionarioRemove");
        int idFuncionarioInt = Integer.parseInt(idFuncionario);

        if (SpringWebMVC.ES2.BLL.Funcionario.removeFuncionario(idFuncionarioInt)) {
            msg = "sucessoRemoveFunc";
        } else {
            msg = "erroRemoveFunc";
        }

        mview = new ModelAndView("redirect:/funcionario");
        redirectAttributes.addFlashAttribute("msg", msg);

        return mview;
    }
}
