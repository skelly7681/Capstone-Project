package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDao {

    Invite getInviteByInviteId(int inviteId);

    Invite getInviteBySenderId(int senderUserId);

    List<Invite> getAllInvitesBySenderId(int senderUserId);

    Invite getInviteByUniqueLink(String uniqueLink);

}
