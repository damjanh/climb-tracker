package com.damjanh.climbtracker.controller.request;

public class CreateAttemptRequest {

    private long userId;

    private long routeId;

    private String attemptType;

    public CreateAttemptRequest(long userId, long routeId, String attemptType) {
        this.userId = userId;
        this.routeId = routeId;
        this.attemptType = attemptType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getAttemptType() {
        return attemptType;
    }

    public void setAttemptType(String attemptType) {
        this.attemptType = attemptType;
    }
}
