package com.example.balancebag;

public class UserAccount {
    private String idToken;  //firebase Uid (고유 토큰 정보)
    private String emailId;  //이메일 아이디
    private String password;  //비밀번호
    private String weight;//몸무게
    private String Gender; //성별


    public UserAccount() {}

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
