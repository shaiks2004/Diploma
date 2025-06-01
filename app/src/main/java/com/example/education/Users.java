
package com.example.education;

public class Users {
    private String profilepic;
    private String num;  // Changed 'Num' to 'num' to follow Java naming conventions
    private String mail;
    private String college;
    private String userName;
    private String password;
    private String userId;
    private String lastMessage;
    private String status;

    // Constructor with parameters
    public Users(String userId, String userName, String mail, String college, String num, String password, String profilepic, String status) {
        this.userId = userId;
        this.userName = userName;
        this.mail = mail;
        this.college=college;
        this.num = num;
        this.password = password;
        this.profilepic = profilepic;
        this.status = status;
    }

    // Default constructor
    public Users() {
        // Default values or empty initialization
    }

    // Getters and Setters
    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

