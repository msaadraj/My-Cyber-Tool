package model;
import java.io.IOException;
import java.util.Scanner;

import gui.Animations;
import gui.Design;

public class Validation {

    public static void pressEnter(Scanner sc){
    System.out.println( Design.WHITE + "\n\n\n                      >>>     Press " + Design.YELLOW + " ENTER " + Design.WHITE + " to continue    <<<               " + Design.RESET);
    try{
    System.in.read();
    }catch(IOException e){
    e.printStackTrace();    
    }
    Animations.loadingAnimation();
    }

    public static String validMenu(Scanner sc, String prompt){
    System.out.print(Design.YELLOW +prompt);
    String option = " ";
    sc.nextLine();
    while (true) { 
    option = sc.nextLine().trim();
    if (!option.matches("[1-5]") || option.isEmpty()){
    System.out.print("\033[F"); // Move cursor up one line
    System.out.print("\033[2K"); // Clear entire line
    System.out.flush();
    System.out.print(Design.RED + "Invalid option selected. Please enter a valid choice from the menu  " + Design.YELLOW + ">   " + Design.RESET);
    continue;
    }
    break;
    }
    return option;
    }

    public static String validateEmail(Scanner sc, String prompt){
    System.out.print(Design.YELLOW + prompt + Design.RESET);
    String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    String email = " ";
    while(true){
    email = sc.nextLine().trim();
    if(email.matches(emailPattern)){
    break;
    }
    else {
    System.out.print("\033[F\033[2K");
    System.out.flush();
    System.out.print(Design.RED + "Invalid Email. Please enter a valid email " + Design.YELLOW + ">   " + Design.RESET);
    continue;
    }
    }
    return email;
    }

    public static String validateURL(Scanner sc, String prompt) {
        String regex = "^(https?://)([\\w-]+\\.)+[\\w-]{2,}(:\\d{1,5})?(/\\S*)?$";
        System.out.print(Design.YELLOW + prompt + Design.RESET);
        while (true) {
            String url = sc.nextLine().trim();

            if (url.matches(regex)) {
                return url;
            }
            System.out.print("\033[F\033[2K");
            System.out.flush();
            System.out.print(Design.RED + "Invalid URL. Please enter a valid URL  "
                    + Design.YELLOW + ">   " + Design.RESET);
        }
    }
}
    
