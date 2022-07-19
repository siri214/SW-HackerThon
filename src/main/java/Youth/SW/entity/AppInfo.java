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

    @Column(name = "appName")
    private String appName;

    @Column(name = "appURL")
    private String appURL;

    private String exp;

    @Column(name = "imgName")
    private String imgName;

    @OneToMany(mappedBy = "appInfo")
    private List<Likes> likeList;

    public AppInfo(){

    }

    public static class Builder{

        private String job;
        private String appName;
        private String appURL;
        private String exp;
        private String imgName;

        public Builder job(String job){
            this.job = job;
            return this;
        }

        public Builder recApp(String appName){
            this.appName = appName;
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

        public Builder imgPath(String imgName){
            this.imgName = imgName;
            return this;
        }

        public AppInfo build(){
            return new AppInfo(this);
        }
    }

    public AppInfo(Builder builder){
        this.job = builder.job;
        this.appName = builder.appName;
        this.appURL = builder.appURL;
        this.exp = builder.exp;
        this.imgName = builder.imgName;

    }


}
