package Youth.SW.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "APP_ID")
    @ManyToOne
    private AppInfo appInfo;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private UserInfo userInfo;

    public Likes(){

    }

    public static class Builder{
        private AppInfo appInfo;
        private UserInfo userInfo;

        public Builder appInfo(AppInfo appInfo){
            this.appInfo = appInfo;
            return this;
        }

        public Builder userInfo(UserInfo userInfo){
            this.userInfo = userInfo;
            return this;
        }

        public Likes build(){
            return new Likes(this);
        }
    }

    public Likes(Builder builder){
        this.appInfo = builder.appInfo;
        this.userInfo = builder.userInfo;
    }
}
