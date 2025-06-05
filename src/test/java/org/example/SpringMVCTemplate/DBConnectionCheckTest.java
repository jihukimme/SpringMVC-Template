package org.example.SpringMVCTemplate;

import static org.junit.Assert.*;

import org.example.SpringMVCTemplate.simpleAuth.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnectionCheckTest {

    @Autowired
    private DataSource ds;

    private final String TEST_USER_ID = "testuser";

    @Before
    public void setUp() throws Exception {
        deleteUser(TEST_USER_ID);
    }

    @Test
    public void insertUserTest() throws Exception {
        UserEntity user = new UserEntity(TEST_USER_ID, "pass", "테스터", "test@ex.com", new Date(), "sns", new Date());
        int result = insertUser(user);
        assertEquals("사용자 삽입 실패", 1, result);
    }

    @Test
    public void selectUserTest() throws Exception {
        // Insert는 따로 테스트되므로 여기선 데이터가 있다고 가정
        insertUser(new UserEntity(TEST_USER_ID, "1234", "홍길동", "test@ex.com", new Date(), "sns", new Date()));
        UserEntity user = selectUser(TEST_USER_ID);
        assertNotNull("사용자 조회 실패", user);
        assertEquals(TEST_USER_ID, user.getId());
    }

    @Test
    public void deleteUserTest() throws Exception {
        int deleted = deleteUser(TEST_USER_ID);
        assertEquals("존재하지 않는 사용자 삭제 결과", 0, deleted);

        insertUser(new UserEntity(TEST_USER_ID, "pass", "이름", "mail@mail.com", new Date(), "sns", new Date()));
        deleted = deleteUser(TEST_USER_ID);
        assertEquals("사용자 삭제 실패", 1, deleted);

        assertNull("삭제 후 사용자 존재", selectUser(TEST_USER_ID));
    }

    @Test
    public void jdbcConnectionTest() throws Exception {
        try (Connection conn = ds.getConnection()) {
            assertNotNull("DB 연결 실패", conn);
        }
    }

    // ================== 헬퍼 메서드 ===================

    private int insertUser(UserEntity user) throws Exception {
        String sql = "INSERT INTO user (id, pwd, name, email, birth, sns, reg_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
            pstmt.setString(6, user.getSns());
            pstmt.setTimestamp(7, new java.sql.Timestamp(user.getReg_date().getTime()));
            return pstmt.executeUpdate();
        }
    }

    private UserEntity selectUser(String id) throws Exception {
        String sql = "SELECT * FROM user WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new UserEntity(
                            rs.getString("id"),
                            rs.getString("pwd"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getDate("birth"),
                            rs.getString("sns"),
                            rs.getTimestamp("reg_date")
                    );
                }
            }
        }
        return null;
    }

    private int deleteUser(String id) throws Exception {
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection conn = ds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate();
        }
    }
}