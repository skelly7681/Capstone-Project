package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInviteDao implements InviteDao {

    private final RestaurantDao restaurantDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcInviteDao(RestaurantDao restaurantDao, JdbcTemplate jdbcTemplate) {
        this.restaurantDao = restaurantDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invite getInviteByInviteId(int inviteId) {

        Invite invite = null;

        String sql = "SELECT sender_user_id, closing_date, closing_time, unique_link " +
                " FROM invite WHERE invite_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inviteId);
        if (results.next()){
            invite = mapRowToInvite(results);
        }
        return invite;
    };

    @Override
    public Invite getInviteBySenderId(int senderUserId) {
        Invite invite = null;

        String sql = "SELECT invite_id, closing_date, closing_time, unique_link " +
                "FROM invite WHERE sender_user_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, senderUserId);
        if (results.next()){
            invite = mapRowToInvite(results);
        }
        return invite;
    };

    @Override
    public List<Invite> getAllInvitesBySenderId(int senderUserId) {
        List<Invite> invites = new ArrayList<>();

        String sql = "SELECT invite_id, closing_date, closing_time, unique_link " +
                "FROM invite WHERE sender_user_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, senderUserId);
        while (results.next()){
            Invite invite = mapRowToInvite(results);
            invites.add(invite);
        }
        return invites;
    };

    @Override
    public Invite getInviteByUniqueLink(String uniqueLink) {
        Invite invite = null;

        String sql = "SELECT invite_id, sender_user_id, closing_date, closing_time " +
                "FROM invite WHERE unique_link = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, uniqueLink);
        if (results.next()){
            invite = mapRowToInvite(results);
        }
        return invite;
    };

    // Some kind of POST method for putting invites into DB

    public Invite createInvite() {

        return null;
    }

    // POST (or PUT?) method to establish the connection in the associative table

    public void addRestaurantToInvite() {


    }

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
