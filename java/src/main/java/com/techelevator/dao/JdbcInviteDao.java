package com.techelevator.dao;

import com.techelevator.model.Invite;
import com.techelevator.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
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

        String sql = "SELECT invite_id, sender_user_id, closing_date, closing_time, unique_link " +
                "FROM invites WHERE invite_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inviteId);
        while (results.next()){
            invite = mapRowToInvite(results);
        }
        return invite;
    };

    @Override
    public Invite getInviteBySenderId(int senderUserId) {
        Invite invite = null;

        String sql = "SELECT invite_id, closing_date, closing_time, unique_link " +
                "FROM invites WHERE sender_user_id = ? ";
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
                "FROM invites WHERE sender_user_id = ? ";
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
                "FROM invites WHERE unique_link = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, uniqueLink);
        if (results.next()){
            invite = mapRowToInvite(results);
        }
        return invite;
    };

    @Override
    public void createInvite(int senderUserId, Date closingDate, Time closingTime, String uniqueLink) {

        String sql = "INSERT INTO invites (sender_user_id, closing_date, closing_time, unique_link)\n" +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, senderUserId, closingDate, closingTime, uniqueLink);
    }

    public void addRestaurantToInvite(int restaurantId, int inviteId, boolean veto) {

        boolean defaultVeto = false; // do this on the front end??

        String sql = "INSERT INTO invite_restaurant (invite_id, restaurant_id, vetoed) " +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, inviteId, restaurantId, veto);
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
