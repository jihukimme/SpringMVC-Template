package org.example.SpringMVCTemplate.simpleAuth.repository;

import org.example.SpringMVCTemplate.simpleAuth.entity.User;

public interface UserRepository {
    public int deleteUser(String id);

    public User selectUser(String id);

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    public int insertUser(User user);

    // 매개변수로 받은 사용자 정보로 user_info테이블을 update하는 메서드
    public int updateUser(User user);

    public void deleteAll() throws Exception;
}
