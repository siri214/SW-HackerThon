package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    @GetMapping("")
    public String main(HttpServletRequest request, Model model){

//        HttpSession session = request.getSession();
//        String job = session.getAttribute("job").toString();
//        model.addAttribute(mainService.appList(job));

        return "main";
    }

    @RequestMapping("/{job}")
    public String Job(@PathVariable("job") String job, Model model){

        model.addAttribute(mainService.appList(job));

        return "main";

    }

    @GetMapping("/App")
    public String App(AppDTO form, Model model){

        model.addAttribute(mainService.appInfo(form.getRid()));

        return "app";

    }

    @PostMapping("/App/addCom")
    public String addCom(AppDTO form){

        mainService.addCom(form);

        return "redirect:/App";
    }

    @GetMapping("/App/addImg")
    public String addImg(){

        return "addExp";
    }

    @PostMapping("/App/addExp")
    public String addExp(AppDTO form, String imgPath){

        form.setImgPath(imgPath);
        mainService.addApp(form);

        return "redirect:/App";

    }

}
