package Youth.SW.service;

import Youth.SW.DTO.UserDTO;
import Youth.SW.entity.UserInfo;
import Youth.SW.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserInfoRepository userInfoRepository;

    public String getJob(Long uid){

        UserInfo userInfo = userInfoRepository.findById(uid).orElseThrow(NoSuchElementException::new);
        UserDTO user = new UserDTO();

        user.setUserJob(userInfo.getUserJob());
        String result = user.getUserJob();

        return result;
    }
}
