package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface InviteDao {

    Invite getInviteByInviteId(int inviteId);

    Invite getInviteBySenderId(int senderUserId);

    List<Invite> getAllInvitesBySenderId(int senderUserId);

    Invite getInviteByUniqueLink(String uniqueLink);

    void createInvite(int senderUserId, Date closingDate, Time closingTime, String uniqueLink);

    void addRestaurantToInvite(int inviteId, int restaurantId, boolean isVetoed);

}
