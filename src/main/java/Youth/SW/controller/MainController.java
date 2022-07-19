package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.DTO.UserDTO;
import Youth.SW.entity.AppInfo;
import Youth.SW.entity.UserInfo;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
        String name = userService.getName(uid);

        model.addAttribute("job", job);
        model.addAttribute("userName", name);

        return "searchMain";
    }

    @PostMapping("/search")
    public String Search(UserDTO user, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        Long uid = Long.parseLong(session.getAttribute("uid").toString());
        String job = user.getUserJob();
        String name = userService.getName(uid);

        model.addAttribute("job", job);
        model.addAttribute("userName", name);

        return "searchMain";
    }
//    @PostMapping("/search")
//    public String Search(UserDTO user, Model model, HttpServletRequest request){
//
//        HttpSession session = request.getSession();
//        Long uid = Long.parseLong(session.getAttribute("uid").toString());
//        String job = userService.getJob(uid);
//        String name = userService.getName(uid);
//
//        model.addAttribute("job", job);
//        model.addAttribute("userName", name);
//
//        return "searchMain";
//    }
    @RequestMapping("/search/{job}")
    public String Job(@PathVariable("job") String userJob, Model model, HttpServletRequest req){

        List<AppInfo> app = mainService.EappList(userJob);
        List<String> count = new ArrayList<>();
        List<AppDTO> list = mainService.appList(userJob);

        for(int i = 0; i < app.size(); i++){
            count.add(i, likeService.getCount(app.get(i)));
            list.get(i).setCount(count.get(i));
        }

        model.addAttribute("app", list);

        return "job";

    }

    @GetMapping("/App")
    public String App(AppDTO form, Model model){

        return "AddAppIcon";

    }

    @PostMapping("/App/addExp")
    public void addExp(AppDTO form, HttpServletResponse res) throws IOException {

        String result = mainService.addApp(form);

        if(result.trim().equals("fail")){
            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('존재하는 앱입니다.'); location.href='/main';</script>");
            out.flush();
        }else {
            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('등록 성공'); location.href='/main';</script>");
            out.flush();
        }



    }

}
