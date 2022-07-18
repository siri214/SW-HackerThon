package Youth.SW.controller;

import Youth.SW.DTO.UserDTO;
import Youth.SW.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public String login(){

        return "login.html";
    }
    @GetMapping("/join")
    public String join(){

        return "joinForm";
    }

    @PostMapping("/joinpro")
    public String joinpro(HttpServletRequest request, UserDTO form){

        String result = homeService.join(form);

        return result;
    }

    @PostMapping("/loginpro")
    public String loginpro(HttpServletRequest request, UserDTO form){

        String result = homeService.login(request, form);

        return result;
    }
}
