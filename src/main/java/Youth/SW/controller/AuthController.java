package Youth.SW.controller;

import Youth.SW.DTO.UserDTO;
import Youth.SW.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService homeService;

    @GetMapping("/")
    public String login(){

        return "login";
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
    public void loginpro(UserDTO form, HttpServletRequest request, HttpServletResponse res) throws IOException {


        String result = homeService.login(form, request);

        if(result.equals("fail")){
            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('아이디 혹은 비밀번호가 일치하지 않습니다..'); location.href='/';</script>");
            out.flush();

        }else{
            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('로그인 성공!'); location.href='/main';</script>");
            out.flush();
        }

    }
}
