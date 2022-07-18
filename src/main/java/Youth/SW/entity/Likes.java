package Youth.SW.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Likes {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "APP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppInfo appInfo;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    public Likes(){

    }

    public static class Builder{
        private Long id;
        private AppInfo appInfo;
        private UserInfo userInfo;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
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
        this.id = builder.id;
    }

    public Likes(UserInfo user, AppInfo appInfo){
        this.userInfo = user;
        this.appInfo = appInfo;
    }
}
