package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.DTO.UserDTO;
import Youth.SW.service.MainService;
import Youth.SW.service.UserService;
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
    private final UserService userService;

    @GetMapping("")
    public String main(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        Long uid = Long.parseLong(session.getAttribute("uid").toString());
        String job = userService.getJob(uid);

        model.addAttribute(mainService.appList(job));

        return "searchMain";
    }

    @PostMapping("/search")
    public String Search(UserDTO user, Model model){

        model.addAttribute(mainService.appList(user.getUserJob()));

        return "searchMain";
    }
    @RequestMapping("/search/{job}")
    public String Job(@PathVariable("job") String userJob, Model model){

        model.addAttribute(mainService.appList(userJob));

        return "login";

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


    @PostMapping("/App/addExp")
    public String addExp(AppDTO form){


        mainService.addApp(form);

        return "redirect:/App";

    }

}
