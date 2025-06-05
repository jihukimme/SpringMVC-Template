package org.example.SpringMVCTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;

public class DBConnectionCheck {
    public static void main(String[] args) throws Exception {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//            String DB_USER = "root";
//            String DB_PASSWORD = "7164";
//
//            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            Statement stmt  = conn.createStatement();
//
//            String query = "SELECT now()";
//            ResultSet rs = stmt.executeQuery(query);
//
//            while (rs.next()) {
//                String curDate = rs.getString(1);
//                System.out.println("DBConnectionTest (시스템 현재 날짜시간 출력) : " + curDate);
//            }
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (ClassNotFoundException e) {
//            System.err.println("JDBC 드라이버 로딩 실패");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.err.println("DB 연결/쿼리 실패");
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("기타 예외 발생");
//            e.printStackTrace();
//        }


        // 수동 주입 방법
        // root-context.xml에서 DataSource관련 Bean을 가져옴
        ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
        DataSource ds = ac.getBean(DataSource.class);

        // 데이터베이스의 연결을 얻는다.
        Connection conn = ds.getConnection();

        System.out.println("conn = " + conn);
    } // main()
}