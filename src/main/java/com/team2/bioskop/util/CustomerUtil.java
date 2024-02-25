package com.team2.bioskop.util;

import com.team2.bioskop.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUtil {
    public static Customer readCustomerByName(String name) {
        Customer customer = null;
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM m_customer WHERE name = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, name);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                customer = new Customer(rs.getString(2), rs.getString(3));
            }

            pr.close();
            rs.close();
            conn.close();

            return customer;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
