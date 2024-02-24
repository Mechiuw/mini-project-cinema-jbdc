package com.team2.bioskop.service;

import com.team2.bioskop.entity.Customer;
import com.team2.bioskop.repositories.CustomerRepositories;
import com.team2.bioskop.util.DbConnector;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void addCustomer() {
        try (Connection connect = DbConnector.connectToDb()){

            Scanner scan = new Scanner(System.in);
            System.out.println("please enter your name and your birth date : ");
            String name = scan.nextLine();
            String birth_date = scan.nextLine();

            Customer customer = new Customer(name,birth_date);
            CustomerRepositories.insert(connect,customer);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showCustomer() {
        try(Connection connect = DbConnector.connectToDb()){
            CustomerRepositories.read(connect);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCustomer() {
        try(Connection connect = DbConnector.connectToDb()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("please enter your selection (name/birth)");
            String nameOrBirth = scan.nextLine();
            System.out.print("please type old (name/birth)= ");
            String oldNameOrBirth = scan.nextLine();
            System.out.print("please type new (name/birth)= ");
            String newNameOrBirth = scan.nextLine();
            Customer customer = new Customer(nameOrBirth,oldNameOrBirth,newNameOrBirth);
            CustomerRepositories.update(connect,customer);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
