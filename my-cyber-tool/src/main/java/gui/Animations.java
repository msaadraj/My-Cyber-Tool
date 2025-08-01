package gui;
import java.util.Scanner;

import model.Validation;

public class Animations {
    public static Scanner sc = new Scanner(System.in);

    public static void loadingCircle(String prompt){
    String[] load = {"\\","-","//","_","\\","-","//","_","\\","-","//","_"};
    System.out.print(Design.RED + prompt + "   ");
    try {
    for (String line : load) {
        for (char c : line.toCharArray()) {
            System.out.print("\b" + Design.YELLOW + c);
            Thread.sleep(125);
        }
    }
        System.out.print("\r");              // Return to beginning of the line
        System.out.print("               "); // Overwrite with spaces
        System.out.print("\r");              // Return again
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

        public static void loadingAnimation(){
        String bar = Design.YELLOW + "\n════════════════════════════════════════════════════════════════════════════════" + Design.RESET;
        try {
        for (char c : bar.toCharArray()) {
            System.out.print(c);    
            Thread.sleep(5);
        }   
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }   

    public static void myIntro(){
    String name = Design.RESET + "\n\n\nBuilt By:" + Design.YELLOW + " Muhammad Saad" + Design.RESET + "\nDate:" + Design.YELLOW + " 2025-07-27" + Design.RESET;
        
        try {
        for (char c : name.toCharArray()){
            System.out.print(c);
            Thread.sleep(20);
        }
        Validation.pressEnter(sc);
        } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
        }
    }

    public static void welcomeTo(){
    System.out.print("\u001B[H\u001B[2J");
    System.out.flush();
    System.out.println();
    String[] welcomeTo = {
    Design.YELLOW +
    "  __        __   _                            _             ",
    "  \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___       ",
    "   \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  ",
    "    \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |     ",
    "     \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ "
    };
    String[] phishingLink = {
    Design.WHITE +
    "__________.__    .__       .__    .__                 .____    .__        __    ",
    "\\______   \\  |__ |__| _____|  |__ |__| ____    ____   |    |   |__| ____ |  | __",
    " |     ___/  |  \\|  |/  ___/  |  \\|  |/    \\  / ___\\  |    |   |  |/    \\|  |/ /",
    " |    |   |   Y  \\  |\\___ \\|   Y  \\  |   |  \\/ /_/  > |    |___|  |   |  \\    < ",
    " |____|   |___|  /__/____  >___|  /__|___|  /\\___  /  |_______ \\__|___|  /__|_ \\",
    "               \\/        \\/     \\/        \\//_____/           \\/       \\/     \\/"
    };
    String[] scanner = {
    Design.YELLOW +
    "  _________                                         ",
    " /   _____/ ____ _____    ____   ____   ___________ ",
    " \\_____  \\_/ ___\\\\__  \\  /    \\ /    \\_/ __ \\_  __ \\",
    " /        \\  \\___ / __ \\|   |  \\   |  \\  ___/|  | \\/",
    "/_______  /\\___  >____  /___|  /___|  /\\___  >__|   ",
    "        \\/     \\/     \\/     \\/     \\/     \\/       "
    };
    try {
    for (String raw : welcomeTo) {
            System.out.println(raw);
            Thread.sleep(40);
    }   
        System.out.println();
    for (String raw : phishingLink) {
            System.out.println(raw);
            Thread.sleep(40);
     }   
        System.out.println();
    for (String raw : scanner) {
            System.out.println(raw);
            Thread.sleep(40);
     }
        System.out.println();
        myIntro();
        Design.clearContent();
    } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
    }
    }
}
