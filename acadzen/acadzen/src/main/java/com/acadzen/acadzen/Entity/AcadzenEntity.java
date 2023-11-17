package com.acadzen.acadzen.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblacadzen")
public class AcadzenEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userno;

    private String username;

    private String password;

    private String email;

    public AcadzenEntity() {
        super();
    }

    public AcadzenEntity(int userno, String username, String password, String email) {
        this.userno = userno;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
