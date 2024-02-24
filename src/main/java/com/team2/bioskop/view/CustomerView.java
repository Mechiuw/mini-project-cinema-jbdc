package com.team2.bioskop.view;

import com.team2.bioskop.service.CustomerService;
import com.team2.bioskop.service.CustomerServiceImpl;


import java.util.Scanner;

public class CustomerView {
    public static void view(){
        boolean checkRating = false;
        Scanner input = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        do {
            System.out.println("==========CUSTOMER(CRUD)=========");
            System.out.println(" 1. show lists of customers      ");
            System.out.println(" 2. update data customer         ");
            System.out.println(" 3. Back to Menu                 ");
            System.out.println("=================================");
            System.out.println("Choose Menu : ");
            int chooseRating = input.nextInt();
            input.nextLine();

            switch (chooseRating){
                case 1 -> customerService.showCustomer();
                case 2 -> customerService.updateCustomer();
                case 3 -> MainView.run();
                default-> checkRating = true;
            }
        }while(checkRating);
    }
}
