package org.example.SpringMVCTemplate;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
            String DB_USER = "root";
            String DB_PASSWORD = "7164";

            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt  = conn.createStatement();

            String query = "SELECT now()";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String curDate = rs.getString(1);
                System.out.println("DBConnectionTest (시스템 현재 날짜시간 출력) : " + curDate);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("DB 연결/쿼리 실패");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("기타 예외 발생");
            e.printStackTrace();
        }
    } // main()
}