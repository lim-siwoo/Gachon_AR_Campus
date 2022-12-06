package com.siwoosiwoo.gachon_arnavigation_1011;

public class UserAccount {
    private String email;
    private String password;
    private String idToken;
    private String name;

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public UserAccount() { } //빈 생성자가 필요 (firebase 관련)

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

}
