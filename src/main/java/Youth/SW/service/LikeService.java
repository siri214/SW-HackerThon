package Youth.SW.service;

import Youth.SW.entity.AppInfo;
import Youth.SW.entity.Likes;
import Youth.SW.entity.UserInfo;
import Youth.SW.repository.AppInfoRepository;
import Youth.SW.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final AppInfoRepository appInfoRepository;

    public boolean addLike(UserInfo user, Long appId) {
        AppInfo appInfo = appInfoRepository.findById(appId).orElseThrow();

        //중복 좋아요 방지
        if(isNotAlreadyLike(user, appInfo)) {
            likeRepository.save(new Likes(user, appInfo));
            return true;
        }

        return false;
    }

    //사용자가 이미 좋아요 한 게시물인지 체크
    private boolean isNotAlreadyLike(UserInfo user, AppInfo appInfo) {
        return likeRepository.findByUserInfoAndAppInfo(user, appInfo).isEmpty();
    }

}
