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

    public boolean appExist(AppDTO form){
        AppInfo app = appInfoRepository.findByAppURL(form.getAppURL());

        if(app != null){
            return true;
        }

        return false;

    }
    public String addApp(AppDTO form){

        String result = "";
        System.out.println(form.getImgName());
        try{

            if(appExist(form)){
                result = "fail";
            }else {
                AppInfo app = new AppInfo.Builder()

                        .job(form.getJob())
                        .appName(form.getAppName())
                        .appURL(form.getAppURL())
                        .exp(form.getAppExp())
                        .imgPath(form.getImgName())
                        .build();

                appInfoRepository.save(app);

                result = "sucsess";
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    public List<AppDTO> appList(String userJob){

        AppDTO appd = new AppDTO();
        List<AppInfo> app = new ArrayList<>();

        app = appInfoRepository.findByJob(userJob);

        List<AppDTO> list = appd.convert(app);


        return list;
    }

    public List<AppInfo> EappList(String userJob){
        List<AppInfo> app = new ArrayList<>();

        app = appInfoRepository.findByJob(userJob);

        return app;
    }

}
