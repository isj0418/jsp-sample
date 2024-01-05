package com.example.guestReply;

import com.example.common.DB;
import com.example.common.Global;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestReplyDAO extends Global {

    public GuestReplyDAO() {
        connection = DB.getConnection();
    }

    public void addReply(GuestReplyVO reply) {
        try {
            String query = "INSERT INTO guestreply (replyId, replyContent, replyWdate, replyCode) VALUES (?, ?, Now(), ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, reply.getReplyId());
            preparedStatement.setString(2, reply.getReplyContent());
            preparedStatement.setInt(3, reply.getReplyCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GuestReplyVO> getRepliesForGuest(int guestNumber) {
        List<GuestReplyVO> replies = new ArrayList<>();
        try {
            String query = "SELECT * FROM guestreply WHERE replyCode = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, guestNumber);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GuestReplyVO reply = new GuestReplyVO();
                reply.setReplyId(resultSet.getString("replyId"));
                reply.setReplyContent(resultSet.getString("replyContent"));
                reply.setReplyWdate( resultSet.getString("replyWdate"));
                reply.setReplyCode(resultSet.getInt("replyCode"));
                replies.add(reply);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replies;
    }

}
