package Youth.SW;

import Youth.SW.entity.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StaticMethod {

    public boolean ifUserExist(UserInfo userInfo){

        if(userInfo == null){
            return false;
        }else{
            return true;
        }
    }
}
