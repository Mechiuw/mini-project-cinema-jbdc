package com.team2.bioskop.view;

import com.team2.bioskop.util.AuthenticationUtil;

import java.util.Scanner;

public class MainView {
    public static void run(){
        boolean checkMenu = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("===================ENIGMA XXI====================");
            System.out.println("1. CUSTOMER");
            System.out.println("2. ADMIN");
            System.out.println("3. TRANSACTION");
            System.out.println("4. EXIT");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseMenu = input.nextInt();
            input.nextLine();

            switch (chooseMenu){
                case 1 :
                    AuthenticationUtil.userInput();
                    break;
                case 2 :
                    AdminView.viewAdmin();
                    break;
                case 3 :
                    TicketView.view();
                    break;
                case 4 :
                    checkMenu = false;
                    break;
                default :
                    checkMenu = true;
                    break;
            }
        }while(checkMenu);
    }
}
