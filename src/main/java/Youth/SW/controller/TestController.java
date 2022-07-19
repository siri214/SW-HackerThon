package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.entity.AppInfo;
import Youth.SW.repository.AppInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final AppInfoRepository appInfoRepository;

    @GetMapping("/test")
    public String asd(Model model){

        AppDTO appd = new AppDTO();
        List<AppInfo> app = new ArrayList<>();

        app = appInfoRepository.findAll();

        System.out.println(app.get(1).getImgName());
        List<AppDTO> appDto = appd.convert(app);
        System.out.println(appDto.get(0).getImgName());
        System.out.println(appDto.get(1).getImgName());
        System.out.println(appDto.get(2).getImgName());
        model.addAttribute("app", appDto);
        return "test";
    }

}
