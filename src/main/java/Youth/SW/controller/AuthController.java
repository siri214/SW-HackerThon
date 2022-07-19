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

    private final AuthService authService;

    @GetMapping("/")
    public String login(){

        return "login";
    }
    @GetMapping("/signin")
    public String signIn(){

        return "signin";
    }

    @PostMapping("/signin/signpro")
    public void signinpro(UserDTO form, HttpServletResponse res) throws IOException {

        String result = authService.join(form);

        if(result.trim().equals("sucsess")){

            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('회원가입 완료'); location.href='/';</script>");
            out.flush();
        }else{

            res.setContentType("text/html; charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("<script>alert('알 수 없는 오류입니다. 다시 시도해주세요.'); location.href='/signin';</script>");
            out.flush();
        }


    }

    @PostMapping("/loginpro")
    public void loginpro(UserDTO form, HttpServletRequest request, HttpServletResponse res) throws IOException {


        String result = authService.login(form, request);

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
