package Youth.SW.service;

import Youth.SW.DTO.UserDTO;
import Youth.SW.entity.UserInfo;
import Youth.SW.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserInfoRepository userInfoRepository;

    public String login(UserDTO form, HttpServletRequest request){

        String result = "";
        UserInfo exInfo = userInfoRepository.findByUserId(form.getUserId());


        try{

            if(exInfo.getUserId() != null){

                if(exInfo.getUserPw().trim().equals(form.getUserPw())){

                    HttpSession session = request.getSession();
                    session.setAttribute("uid", exInfo.getId());
                    session.setMaxInactiveInterval(1800);

                    result = "redirect:/main";
                }else{
                    System.out.println("비밀번호가 틀립니다.");
                    result = "redirect:/";
                }

            }else{
                System.out.println("존재하지 않는 아이디입니다.");
                result = "redirect:/";
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public String join(UserDTO form){

        String result = "";

        try{

            UserInfo user = new UserInfo.Builder()
                    .userId(form.getUserId())
                    .userPw(form.getUserPw())
                    .userName(form.getUserName())
                    .build();

            userInfoRepository.save(user);

            result = "sucsess";

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
