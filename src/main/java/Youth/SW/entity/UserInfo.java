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

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_PW")
    private String userPw;

    @Column(name = "USER_JOB")
    private String userJob;

    @Column(name = "BOOK_MARK")
    private String bookMark;

    @OneToMany(mappedBy = "userInfo")
    private List<Likes> likeList;

    public UserInfo(){

    }

    public static class Builder{

        private String userName;
        private String userId;
        private String userPw;
        private String userJob;
        private String bookMark;

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }

        public Builder userPw(String userPw){
            this.userPw = userPw;
            return this;
        }

        public Builder userJob(String userJob){
            this.userJob = userJob;
            return this;
        }

        public Builder bookMark(String bookMark){
            this.bookMark = bookMark;
            return this;
        }

        public UserInfo build(){
            return new UserInfo(this);
        }
    }

    public UserInfo(Builder builder){
        this.userName = builder.userName;
        this.userId = builder.userId;
        this.userPw = builder.userPw;
        this.userJob = builder.userJob;
        this.bookMark = builder.bookMark;
    }

}
