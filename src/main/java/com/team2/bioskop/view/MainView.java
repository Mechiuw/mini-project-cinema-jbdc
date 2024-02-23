package com.team2.bioskop.view;

import com.team2.bioskop.service.FilmServiceImpl;

import java.util.Scanner;

public class MainView {
    public static void run(){
        boolean checkMenu = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("===================ENIGMA XXI====================");
            System.out.println("1. CUSTOMER");
            System.out.println("2. ADMIN");
            System.out.println("3. EXIT");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseMenu = input.nextInt();
            input.nextLine();

//            switch (chooseMenu){
//                case 1 :
//                    CustomerView.view();
//                    break;
//                case 2 :
//                    AdminView.viewAdmin();
//                    break;
//                case 3 :
//                    checkMenu = false;
//                    break;
//                default :
//                    checkMenu = true;
//                    break;
//            }
        }while(checkMenu);
    }
}
