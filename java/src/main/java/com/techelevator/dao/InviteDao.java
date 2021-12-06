package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDao {

    Invite getInviteById(int inviteId);

    Invite getInviteBySenderId(int senderUserId);

    List<Invite> getAllInvitesBySenderId(int senderUserId);

    Invite getInviteByUniqueLink(String uniqueLink);

}
