package Youth.SW.service;

import Youth.SW.DTO.AppDTO;
import Youth.SW.entity.AppInfo;
import Youth.SW.repository.AppInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainService {

    private final AppInfoRepository appInfoRepository;

    public void addApp(AppDTO form){

        try{
            System.out.println("pass2");
            AppInfo app = new AppInfo.Builder()
                    .job(form.getJob())
                    .recApp(form.getAppName())
                    .appURL(form.getAppURL())
                    .exp(form.getAppExp())
                    .imgPath(form.getImgPath())
                    .build();
            System.out.println("pass3");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public List<AppInfo> appList(String userJob){


        List<AppInfo> list = appInfoRepository.findByJob(userJob);

        return list;
    }

    public AppDTO appInfo(String rid){

        AppDTO app = new AppDTO();
        List<String> com = new ArrayList<>();

        try{

            Optional<AppInfo> info = appInfoRepository.findById(Long.parseLong(rid));

            AppInfo ainfo = info.orElseThrow(NoSuchElementException::new);


            app.setImgPath(ainfo.getImgPath());
            app.setAppURL(ainfo.getAppURL());
            app.setAppName(ainfo.getRecApp());
            app.setAppExp(ainfo.getExp());
            app.setJob(ainfo.getJob());
            app.setRid(ainfo.getId().toString());


        }catch (Exception e){
            e.printStackTrace();
        }


        return app;

    }
}
