package Youth.SW.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AppDTO {

    private String rid;
    private String job;
    private String recApp;
    private String appURL;
    private String exp;
    private String imgPath;
    private String sComment;
    private List<String> comment;
}
