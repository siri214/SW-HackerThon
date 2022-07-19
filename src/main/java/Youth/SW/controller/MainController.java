package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.DTO.UserDTO;
import Youth.SW.entity.AppInfo;
import Youth.SW.service.LikeService;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;
    private final UserService userService;
    private final LikeService likeService;


    @GetMapping("")
    public String main(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        Long uid = Long.parseLong(session.getAttribute("uid").toString());
        String job = userService.getJob(uid);

        model.addAttribute("job", job);

        return "searchMain";
    }

    @PostMapping("/search")
    public String Search(UserDTO user, Model model){

        model.addAttribute(mainService.appList(user.getUserJob()));

        return "searchMain";
    }
    @RequestMapping("/search/{job}")
    public String Job(@PathVariable("job") String userJob, Model model, HttpServletRequest req){

        HttpSession session = req.getSession();
        Long uid = Long.parseLong(session.getAttribute("uid").toString());
        List<AppInfo> app = mainService.EappList(userJob);

        List<String> count = new ArrayList<>();
        List<AppDTO> list = mainService.appList(userJob);

        for(int i = 0; i < app.size(); i++){
            count.add(i, likeService.getCount(app.get(i)));
            list.get(i).setCount(count.get(i));
        }

        Collection<AppDTO> sortList = list;

        sortList
        for(Board board : boardList) {
            System.out.println(board);
        }
        출처: https://offbyone.tistory.com/154 [쉬고 싶은 개발자:티스토리]
        model.addAttribute("app", list);

        return "job";

    }

    @GetMapping("/App")
    public String App(AppDTO form, Model model){



        return "AddAppIcon";

    }



    @PostMapping("/App/addExp")
    public String addExp(AppDTO form){


        mainService.addApp(form);

        return "redirect:/App";

    }

}
