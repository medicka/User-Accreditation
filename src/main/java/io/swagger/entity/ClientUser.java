package io.swagger.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientUser {

    @Id
    private String id;
    private String userName;

    public ClientUser() {
    }

    public ClientUser(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
