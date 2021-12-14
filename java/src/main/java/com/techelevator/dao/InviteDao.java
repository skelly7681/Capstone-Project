package com.techelevator.dao;

import com.techelevator.Service.DTO.InviteDTO;
import com.techelevator.Service.DTO.RestaurantDTO;
import com.techelevator.model.Invite;
import com.techelevator.model.RestaurantInviteDTO;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface InviteDao {

    Invite getInviteByInviteId(int inviteId);

    Invite getInviteBySenderId(int senderUserId);

    List<Invite> getAllInvitesBySenderId(int senderUserId);

    Invite getInviteByUniqueLink(String uniqueLink);

    Invite createInvite(Invite invite);

    void addRestaurantToInvite(RestaurantInviteDTO restaurantInviteBundle);

}
