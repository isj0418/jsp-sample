package com.example.user;

import com.example.common.DB;
import com.example.common.Global;

public class UserDAO extends Global {

    public UserDAO() {
        connection = DB.getConnection();
    }

    public boolean signUp(UserVO userVO) { // 회원가입
        try {
            String query = "insert into login(userId, userPwd, userName, userPhoneNumber) values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userVO.getUserId());
            preparedStatement.setString(2, userVO.getUserPwd());
            preparedStatement.setString(3, userVO.getUserName());
            preparedStatement.setString(4, userVO.getUserPhoneNumber());
            int success = preparedStatement.executeUpdate();
            if (success > 0) {
                return true;
            } else {
                return false;
            }


        } catch (Exception ex) {
            System.out.println("error");
            return false;
        }
    }

    public boolean login(String userId, String userPwd){ //로그인
        try{
            String query = "select * from login where userId = ? and userPwd = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userPwd);
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ){
                return true;
            } else {
                return false;
            }
        } catch (Exception ex){
            System.out.println("error");
            return false;
        }
    }
}
