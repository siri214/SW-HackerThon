package Youth.SW.controller;

import Youth.SW.DTO.AppDTO;
import Youth.SW.entity.AppInfo;
import Youth.SW.repository.AppInfoRepository;
import Youth.SW.service.LikeService;
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
    private final LikeService likeService;

    @GetMapping("/test")
    public String asd(Model model){

        AppDTO appd = new AppDTO();
        List<AppInfo> app = new ArrayList<>();

        app = appInfoRepository.findAll();



        List<AppDTO> appDto = appd.convert(app);

        model.addAttribute("app", appDto);
        return "test";
    }

}
