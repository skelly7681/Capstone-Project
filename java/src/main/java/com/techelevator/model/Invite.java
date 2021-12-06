package com.techelevator.model;

public class Invite {

    private int inviteId;
    private int senderUserId;
    private String closingDate;
    private double closingTime;
    private String uniqueLink;

    public Invite(int inviteId, int senderUserId, String closingDate, double closingTime, String uniqueLink) {
        this.inviteId = inviteId;
        this.senderUserId = senderUserId;
        this.closingDate = closingDate;
        this.closingTime = closingTime;
        this.uniqueLink = uniqueLink;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public int getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public double getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(double closingTime) {
        this.closingTime = closingTime;
    }

    public String getUniqueLink() {
        return uniqueLink;
    }

    public void setUniqueLink(String uniqueLink) {
        this.uniqueLink = uniqueLink;
    }
}
