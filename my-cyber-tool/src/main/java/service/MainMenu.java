package service;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

import gui.Animations;
import gui.Design;
import model.Credits;
import model.Instructions;
import model.Validation;

public class MainMenu{
    public static final Scanner sc = new Scanner(System.in);
    public static void menu(){
        Design.clearContent();
        System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
        System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW + ansi().bold() +"                             MAIN MENU                            "+Design.RED+"            ║"+Design.RESET);
        System.out.println(Design.RED+"╠═════════════════════════════════════════════════════════════════════════════════════════╣"+Design.RESET);
        System.out.println(Design.RED+"║  "+Design.RESET+"1. "+Design.YELLOW+"Scan URL Link                                                          "+Design.RED+"             ║"+Design.RESET);
        System.out.println(Design.RED+"║  "+Design.RESET+"2. "+Design.YELLOW+"Scan Email                                                                       "+Design.RED+"   ║"+Design.RESET);
        System.out.println(Design.RED+"║  "+Design.RESET+"3. "+Design.YELLOW+"Instructions                                                                     "+Design.RED+"   ║"+Design.RESET);
        System.out.println(Design.RED+"║  "+Design.RESET+"4. "+Design.YELLOW+"Credits                                                                          "+Design.RED+"   ║"+Design.RESET);
        System.out.println(Design.RED+"║  "+Design.RESET+"5. "+Design.YELLOW+"Exit                                                                             "+Design.RED+"   ║"+Design.RESET);
        System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET); 
    }

    public static void mainMenu(){
        while(true){
        menu();
        String option = Validation.validMenu(sc, "  >   ");
        Animations.loadingAnimation();
        Design.clearContent();

        switch (option) {

            case "1":               // Scan URL
            ScaningURL.urlScan();
            Validation.pressEnter(sc);
            continue;
            
            case "2":                   // Scan Email
            ScaningEmail.emailScan();
            Validation.pressEnter(sc);
            break;
            
            case "3":               // Instructions
            Instructions.instructions();
            Validation.pressEnter(sc);
            break;

            case "4":               // Credits
            Credits.credits();
            Validation.pressEnter(sc);
            break;

            case "5":
            System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
            System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW+"Thank you for using the Phishing Scanner CLI Tool. Stay safe online!"+Design.RED+"          ║"+Design.RESET);
            System.out.println(Design.RED+"║                                                                                         ║"+Design.RESET);
            System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW+"Developed by Muhammad Saad | Cybersecurity & Java Developer"+Design.RED+"                   ║"+Design.RESET);
            System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET);
            System.exit(0);
            break;
        }
        }
    }
}