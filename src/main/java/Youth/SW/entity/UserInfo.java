package Youth.SW.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UID")
    private Long id;

    private String userName;

    private String userId;

    private String userPw;

    private String userJob;

    @OneToMany(mappedBy = "userInfo")
    private List<Likes> likeList;

    public UserInfo() {

    }

    public static class Builder {
        private Long id;
        private String userName;
        private String userId;
        private String userPw;
        private String userJob;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userPw(String userPw) {
            this.userPw = userPw;
            return this;
        }

        public Builder userJob(String userJob) {
            this.userJob = userJob;
            return this;
        }


        public UserInfo build() {
            return new UserInfo(this);
        }
    }

    public UserInfo(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.userId = builder.userId;
        this.userPw = builder.userPw;
        this.userJob = builder.userJob;
    }

}
