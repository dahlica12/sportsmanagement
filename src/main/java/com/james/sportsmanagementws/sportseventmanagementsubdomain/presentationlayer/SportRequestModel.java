package com.james.sportsmanagementws.sportseventmanagementsubdomain.presentationlayer;

public class SportRequestModel {

    public SportRequestModel() {
    }

    String type;

    public SportRequestModel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
