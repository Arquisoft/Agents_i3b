package repository;

import hello.UserInfo2;

public interface DBService {

//    boolean updateInfo(String id, String oldPass, String newPass);
//    UserInfo getParticipant(String email, String password);
//    void insertUser(UserInfo user);
    //////////////////////////////////////////////////////////
    UserInfo2 getAgent(String id, String password, String kind);
    void insertUser(UserInfo2 user);
    void deleteUser(UserInfo2 user);
}
