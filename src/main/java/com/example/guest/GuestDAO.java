// GuestDAO.java

package com.example.guest;

import com.example.common.DB;
import com.example.common.Global;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO extends Global {

    public GuestDAO() {
        connection = DB.getConnection();
    }

    public void insertGuest(GuestVO guest) {
        try {
            String query = "INSERT INTO guest (guestId, guestName, guestTitle, guestContent, guestWdate, guestImgFile ) VALUES (?, ?, ?, ?, NOW(), ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, guest.getGuestId());
            preparedStatement.setString(2, guest.getGuestName());
            preparedStatement.setString(3, guest.getGuestTitle());
            preparedStatement.setString(4, guest.getGuestContent());
            preparedStatement.setString(5, guest.getGuestImgFile());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GuestVO> getAllGuests(int start, int total) {
        List<GuestVO> guestList = new ArrayList<>();
        try {
            String query = "SELECT * FROM guest ORDER BY guestNumber DESC LIMIT ?, ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, total);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GuestVO guestVO = new GuestVO();
                guestVO.setGuestNumber(resultSet.getInt("guestNumber"));
                guestVO.setGuestId(resultSet.getString("guestId"));
                guestVO.setGuestName(resultSet.getString("guestName"));
                guestVO.setGuestTitle(resultSet.getString("guestTitle"));
                guestVO.setGuestContent(resultSet.getString("guestContent"));
                guestVO.setGuestWdate(resultSet.getString("guestWdate"));
                guestVO.setGuestHit(resultSet.getInt("guestHit"));
                guestVO.setGuestImgFile(resultSet.getString("guestImgFile"));
                guestList.add(guestVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }

    public int getTotalGuestsCount() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM guest";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<GuestVO> searchByTitle(String keyword, int start, int total) {
        List<GuestVO> guestList = new ArrayList<>();
        try {
            String query = "SELECT * FROM guest WHERE guestTitle LIKE ? ORDER BY guestNumber DESC LIMIT ?, ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, total);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GuestVO guestVO = new GuestVO();
                guestVO.setGuestNumber(resultSet.getInt("guestNumber"));
                guestVO.setGuestId(resultSet.getString("guestId"));
                guestVO.setGuestName(resultSet.getString("guestName"));
                guestVO.setGuestTitle(resultSet.getString("guestTitle"));
                guestVO.setGuestContent(resultSet.getString("guestContent"));
                guestVO.setGuestWdate(resultSet.getString("guestWdate"));
                guestVO.setGuestHit(resultSet.getInt("guestHit"));
                guestVO.setGuestImgFile(resultSet.getString("guestImgFile"));
                guestList.add(guestVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }

    public List<GuestVO> searchByAuthor(String keyword, int start, int total) {
        List<GuestVO> guestList = new ArrayList<>();
        try {
            String query = "SELECT * FROM guest WHERE guestId LIKE ? ORDER BY guestNumber DESC LIMIT ?, ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, total);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GuestVO guestVO = new GuestVO();
                guestVO.setGuestNumber(resultSet.getInt("guestNumber"));
                guestVO.setGuestId(resultSet.getString("guestId"));
                guestVO.setGuestName(resultSet.getString("guestName"));
                guestVO.setGuestTitle(resultSet.getString("guestTitle"));
                guestVO.setGuestContent(resultSet.getString("guestContent"));
                guestVO.setGuestWdate(resultSet.getString("guestWdate"));
                guestVO.setGuestHit(resultSet.getInt("guestHit"));
                guestVO.setGuestImgFile(resultSet.getString("guestImgFile"));
                guestList.add(guestVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }

    public List<GuestVO> searchByName(String keyword, int start, int total) {
        List<GuestVO> guestList = new ArrayList<>();
        try {
            String query = "SELECT * FROM guest WHERE guestName LIKE ? ORDER BY guestNumber DESC LIMIT ?, ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setInt(2, start);
            preparedStatement.setInt(3, total);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GuestVO guestVO = new GuestVO();
                guestVO.setGuestNumber(resultSet.getInt("guestNumber"));
                guestVO.setGuestId(resultSet.getString("guestId"));
                guestVO.setGuestName(resultSet.getString("guestName"));
                guestVO.setGuestTitle(resultSet.getString("guestTitle"));
                guestVO.setGuestContent(resultSet.getString("guestContent"));
                guestVO.setGuestWdate(resultSet.getString("guestWdate"));
                guestVO.setGuestHit(resultSet.getInt("guestHit"));
                guestVO.setGuestImgFile(resultSet.getString("guestImgFile"));
                guestList.add(guestVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestList;
    }

    public int getTotalGuestsCountByTitle(String keyword) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM guest WHERE guestTitle LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getTotalGuestsCountByAuthor(String keyword) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM guest WHERE guestId LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getTotalGuestsCountByName(String keyword) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM guest WHERE guestName LIKE ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public GuestVO getGuestByNumber(int guestNumber) {
        GuestVO guestVO = null;
        try {
            String query = "SELECT * FROM guest WHERE guestNumber = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, guestNumber);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                guestVO = new GuestVO();
                guestVO.setGuestNumber(resultSet.getInt("guestNumber"));
                guestVO.setGuestId(resultSet.getString("guestId"));
                guestVO.setGuestName(resultSet.getString("guestName"));
                guestVO.setGuestTitle(resultSet.getString("guestTitle"));
                guestVO.setGuestContent(resultSet.getString("guestContent"));
                guestVO.setGuestWdate(resultSet.getString("guestWdate"));
                guestVO.setGuestHit(resultSet.getInt("guestHit"));
                guestVO.setGuestImgFile(resultSet.getString("guestImgFile"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestVO;
    }

    public void updateGuest(GuestVO guest) {
        try {
            String query = "UPDATE guest SET guestName = ?, guestTitle = ?, guestContent = ?, guestImgFile = ? WHERE guestNumber = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, guest.getGuestName());
            preparedStatement.setString(2, guest.getGuestTitle());
            preparedStatement.setString(3, guest.getGuestContent());
            preparedStatement.setString(4, guest.getGuestImgFile());
            preparedStatement.setInt(5, guest.getGuestNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGuestHit(int guestNumber){
        try{
            String query = "UPDATE guest SET guestHit = guestHit + 1 WHERE guestNumber = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, guestNumber);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
