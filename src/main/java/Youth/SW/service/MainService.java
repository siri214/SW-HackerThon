package Youth.SW.service;

import Youth.SW.DTO.AppDTO;
import Youth.SW.entity.AppCom;
import Youth.SW.entity.AppInfo;
import Youth.SW.repository.AppComRepository;
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
    private final AppComRepository appComRepository;

    public void addApp(AppDTO form){

        try{

            AppInfo app = new AppInfo.Builder()
                    .job(form.getJob())
                    .recApp(form.getRecApp())
                    .appURL(form.getAppURL())
                    .exp(form.getExp())
                    .imgPath(form.getImgPath())
                    .build();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addCom(AppDTO form){

        try{

            AppCom saveCom = new AppCom.Builder()
                    .rid(form.getRid())
                    .appCom(form.getSComment())
                    .build();


            appComRepository.save(saveCom);

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
            List<AppCom> cinfo = appComRepository.findCommentByRid(rid);
            AppInfo ainfo = info.orElseThrow(NoSuchElementException::new);

            for(int i = 0; i<cinfo.size(); i++){
                com.set(i, cinfo.get(i).getAppCom());
            }
            app.setImgPath(ainfo.getImgPath());
            app.setAppURL(ainfo.getAppURL());
            app.setRecApp(ainfo.getRecApp());
            app.setExp(ainfo.getExp());
            app.setJob(ainfo.getJob());
            app.setRid(ainfo.getId().toString());
            app.setComment(com);

        }catch (Exception e){
            e.printStackTrace();
        }


        return app;

    }
}
