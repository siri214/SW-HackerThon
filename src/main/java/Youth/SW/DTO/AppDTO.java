package Youth.SW.DTO;

import Youth.SW.entity.AppInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AppDTO {

    private String rid;
    private String job;
    private String appName;
    private String appURL;
    private String appExp;
    private String imgName;
    private String count;

    public AppDTO(){

    }

    public AppDTO(AppInfo appInfo){
        this.setAppURL(appInfo.getAppURL());
        this.setAppName(appInfo.getAppName());
        this.setAppExp(appInfo.getExp());
        this.setImgName(appInfo.getImgName());
        this.setJob(appInfo.getJob());
        this.setRid(appInfo.getId().toString());
    }


    public List<AppDTO> convert(List<AppInfo> appInfo){

        List<AppDTO> app = new ArrayList<>();

        for(int i = 0; i < appInfo.size(); i++){

            AppDTO appd = new AppDTO(appInfo.get(i));

            app.add(i, appd);
        }

        return app;

    }
}
