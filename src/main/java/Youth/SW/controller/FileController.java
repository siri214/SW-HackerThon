package Youth.SW.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
public class FileController {

    @PostMapping("/main/App/addImg")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestParam(value = "image", required = false) MultipartFile files) throws Exception {

        String originalfileName = files.getOriginalFilename();
        File dest = new File("/Users/laykis/Desktop/img/" + originalfileName);
        files.transferTo(dest);
            // TODO

        return "addExp";
    }
}
