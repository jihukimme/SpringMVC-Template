package org.example.SpringMVCTemplate.simpleAuth.dao;

import org.example.SpringMVCTemplate.simpleAuth.entity.UserEntity;

public interface UserDao {
    public int deleteUser(String id);

    public UserEntity selectUser(String id);

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    public int insertUser(UserEntity user);

    // 매개변수로 받은 사용자 정보로 user_info테이블을 update하는 메서드
    public int updateUser(UserEntity user);

    public void deleteAll() throws Exception;
}
