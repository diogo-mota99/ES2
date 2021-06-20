package SpringWebMVC.ES2.controller;

import SpringWebMVC.ES2.DAL.Casta;
import SpringWebMVC.ES2.DAL.Controlo;
import SpringWebMVC.ES2.DAL.Funcionario;
import SpringWebMVC.ES2.DAL.Produtofinal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    private static Funcionario f;

    @RequestMapping("/dashboard")
    public ModelAndView dashboard(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        ModelAndView mview = null;

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        mview = new ModelAndView("dashboard");

        if (inputFlashMap != null) {

            Funcionario funcionario = (Funcionario) inputFlashMap.get("funcionario");
            f = funcionario;

            FuncionarioModel(model, funcionario);


        } else {
            mview = new ModelAndView("dashboard");

            if (f != null) {
                FuncionarioModel(model, f);
            } else {
                mview = new ModelAndView("redirect:/index");
            }

        }
        return mview;


    }

    private void FuncionarioModel(Model model, Funcionario f) {
        List<Funcionario> funcionarioList = SpringWebMVC.ES2.BLL.Funcionario.funcionariosByEmpresa(f.getIdEmpresa().getIdEmpresa());
        List<Controlo> allControlos = SpringWebMVC.ES2.BLL.Controlo.readAllControlos();
        List<Controlo> controloList = SpringWebMVC.ES2.BLL.Controlo.readControlosByResultado(1);
        List<Object> plantVindimaList = SpringWebMVC.ES2.BLL.PlantacaoVindima.readPlantVindimaByFuncAndEmp(f.getIdEmpresa().getIdEmpresa());
        float ControlosBemSUcedidos = SpringWebMVC.ES2.BLL.Controlo.percControlosBemSucedidos(allControlos.size(), controloList.size());
        List<Object> plantacaoAtiva = SpringWebMVC.ES2.BLL.Plantacao.readPlantAtivas(f.getIdEmpresa().getIdEmpresa());
        List<Casta> listCastas = SpringWebMVC.ES2.BLL.Casta.readAllCastas();
        Produtofinal produtoFinal = SpringWebMVC.ES2.BLL.Produtofinal.readProdutoFinalByEmpresa(f.getIdEmpresa().getIdEmpresa());


        model.addAttribute("funcionario", f);
        model.addAttribute("plantacaoVindima", plantVindimaList);
        model.addAttribute("listFuncionario", funcionarioList);
        model.addAttribute("listControlo", controloList);
        model.addAttribute("plantacaoAtiva", plantacaoAtiva);
        model.addAttribute("controlosBemSUcedicos", ControlosBemSUcedidos);
        model.addAttribute("listaCastas", listCastas);
        model.addAttribute("listaProdutoFinal", produtoFinal);
    }

}
