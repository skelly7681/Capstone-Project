package com.techelevator.dao;

import com.techelevator.model.Invite;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcInviteDao implements InviteDao {

    private final InviteDao inviteDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcInviteDao(InviteDao inviteDao, JdbcTemplate jdbcTemplate) {
        this.inviteDao = inviteDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invite getInviteById(int inviteId) {

        return null;
    };

    @Override
    public Invite getInviteBySenderId(int senderUserId) {

        return null;
    };

    @Override
    public List<Invite> getAllInvitesBySenderId(int senderUserId) {

        return null;
    };

    @Override
    public Invite getInviteByUniqueLink(String uniqueLink) {

        return null;
    };
}
