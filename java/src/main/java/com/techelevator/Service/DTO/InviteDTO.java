package com.techelevator.Service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InviteDTO {

    @JsonProperty("invite_id")
    private int inviteId;
    @JsonProperty("sender_user_id")
    private int senderUserId;
    @JsonProperty("closing_date")
    private String closingDate;
    @JsonProperty("closing_time")
    private String closingTime;

    private String uniqueLink;

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

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getUniqueLink() {
        return uniqueLink;
    }

    public void setUniqueLink(String uniqueLink) {
        this.uniqueLink = uniqueLink;
    }

    public InviteDTO() {
    }
}
