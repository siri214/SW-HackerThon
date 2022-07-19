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

    public String getName(Long uid){

        UserInfo userInfo = userInfoRepository.findById(uid).orElseThrow(NoSuchElementException::new);
        UserDTO user = new UserDTO();

        user.setUserName(userInfo.getUserName());
        String result = user.getUserName();

        return result;
    }

    public Long getUidByUserId(String userId){

        UserInfo userInfo = userInfoRepository.findByUserId(userId);

        return userInfo.getId();
    }
}
