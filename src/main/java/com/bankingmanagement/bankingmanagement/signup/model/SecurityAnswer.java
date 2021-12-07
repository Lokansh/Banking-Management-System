package com.bankingmanagement.bankingmanagement.signup.model;


public class SecurityAnswer {

    private String userLoginID;
    private int questionID;
    private String questionAnswer;

    public SecurityAnswer(String userLoginID, int questionID, String questionAnswer) {
        this.userLoginID = userLoginID;
        this.questionID = questionID;
        this.questionAnswer = questionAnswer;
    }

    public String getUserLoginID() {
        return userLoginID;
    }

    public void setUserLoginID(String userLoginID) {
        this.userLoginID = userLoginID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
