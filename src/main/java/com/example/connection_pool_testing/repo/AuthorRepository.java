package com.example.connection_pool_testing.repo;

import com.example.connection_pool_testing.db.ConnectFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    private final ConnectFactory connectionFactory;

    public AuthorRepository(ConnectFactory connectFactory) {
        this.connectionFactory = connectFactory;
    }

    public void fetchUsers() {
        long startTime = new Date().getTime();
        System.out.println("Start get connection: " + startTime);

        DataSource dataSource = connectionFactory.gConnectionStrategy().getDataSource();

        try {
            Connection connection = dataSource.getConnection();
            System.out.println("End time get connection: " + (new Date().getTime() - startTime));
            long startQuery = new Date().getTime();
            System.out.println("start Query: " + startQuery);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author");

            while (resultSet.next()) {
                System.out.println("First name: " + resultSet.getString("first_name"));
            }

            long endTime = new Date().getTime() - startQuery;
            System.out.println("end query: " + endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
