package com.padcmyanmar.viewtesting.data.vo;

/**
 * Created by ICE on 17-12-2017.
 */

public class SentTosVO {

private String senttoId;
private String sentDate;
private ActedUserVO actedUser;
private ActedUserVO receivedUser;

    public String getSenttoId() {
        return senttoId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
