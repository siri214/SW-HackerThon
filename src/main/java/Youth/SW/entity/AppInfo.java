package Youth.SW.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class AppInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String job;

    private String recApp;

    private String appURL;

    private String exp;

    private String imgPath;

    @OneToMany(mappedBy = "appInfo")
    private List<Likes> likeList;

    public AppInfo(){

    }

    public static class Builder{

        private String job;
        private String recApp;
        private String appURL;
        private String exp;
        private String imgPath;

        public Builder job(String job){
            this.job = job;
            return this;
        }

        public Builder recApp(String recApp){
            this.recApp = recApp;
            return this;
        }

        public Builder appURL(String appURL){
            this.appURL = appURL;
            return this;
        }

        public Builder exp(String exp){
            this.exp = exp;
            return this;
        }

        public Builder imgPath(String imgPath){
            this.imgPath = imgPath;
            return this;
        }

        public AppInfo build(){
            return new AppInfo(this);
        }
    }

    public AppInfo(Builder builder){
        this.job = builder.job;
        this.recApp = builder.recApp;
        this.appURL = builder.appURL;
        this.exp = builder.exp;
        this.imgPath = builder.imgPath;

    }


}
