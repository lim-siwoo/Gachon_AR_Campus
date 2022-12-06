package com.siwoosiwoo.gachon_arnavigation_1011;

public class firebase_ChatData {
    private String userName;
    private String message;
    String sending_time;

    public firebase_ChatData() { }

    public firebase_ChatData(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
