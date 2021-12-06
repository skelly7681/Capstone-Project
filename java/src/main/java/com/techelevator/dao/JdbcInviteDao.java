package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcInviteDao implements InviteDao {

    private final InviteDao inviteDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcInviteDao(InviteDao inviteDao, JdbcTemplate jdbcTemplate) {
        this.inviteDao = inviteDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Invite getInviteById(int inviteId) {

        return null;
    };

    public Invite getInviteBySenderId(int senderUserId) {

        return null;
    };

    public List<Invite> getAllInvitesBySenderId(int senderUserId) {

        return null;
    };

    public Invite getInviteByUniqueLink(String uniqueLink) {

        return null;
    };

    private Invite mapRowToInvite(SqlRowSet rs) {

        Invite invite = new Invite();

        invite.setInviteId(rs.getInt("invite_id"));
        invite.setSenderUserId(rs.getInt("sender_user_id"));
        invite.setClosingDate(rs.getDate("closing_date"));
        invite.setClosingTime(rs.getTime("closing_time"));
        invite.setUniqueLink(rs.getString("unique_link"));

        return invite;
    }
}
