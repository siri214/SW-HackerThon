package Youth.SW.controller;

import Youth.SW.entity.UserInfo;
import Youth.SW.repository.UserInfoRepository;
import Youth.SW.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/main/App/like")
public class LikeController {

    private final LikeService likeService;
    private final UserInfoRepository userInfoRepository;

    @PostMapping("/{AppId}")
    public ResponseEntity<String> addLike(@PathVariable Long AppId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Long uid = Long.parseLong(session.getAttribute("uid").toString());
        UserInfo user = userInfoRepository.findById(uid).orElseThrow(NoSuchElementException::new);

        boolean result = false;

        if (user != null) {
            result = likeService.addLike(user, AppId);
        }

        return result ?
                new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
