package Youth.SW.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class AppCom {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "APP_ID")
    private String rid;

    @Column(name = "APP_COMMENT")
    private String appCom;

    public AppCom(){

    }

    public static class Builder{

        private String rid;
        private String appCom;

        public Builder rid(String rid){
            this.rid = rid;
            return this;
        }

        public Builder appCom(String appCom){
            this.appCom = appCom;
            return this;
        }

        public AppCom build(){

            return new AppCom(this);
        }
    }

    public AppCom(Builder builder){
        this.rid = builder.rid;
        this.appCom = builder.appCom;
    }
}
