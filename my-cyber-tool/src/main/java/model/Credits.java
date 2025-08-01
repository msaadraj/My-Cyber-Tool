package model;

import static org.fusesource.jansi.Ansi.ansi;

import gui.Design;
public class Credits {
    
    public static void credits(){
    Design.clearContent();
    System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
    System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW + ansi().bold() +"                              CREDITS                             "+Design.RED+"            ║"+Design.RESET);
    System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET);
    
        System.out.println(Design.WHITE +
                   "\nThis Phishing Scanner CLI tool was designed and developed to help identify potential online \nthreats through suspicious URLs and email addresses.\n" +
                   "\nDeveloped By: " + Design.YELLOW + "Muhammad Saad" + Design.WHITE +
                   "\nSpecialization: " + Design.YELLOW + "Cybersecurity | Ethical Hacking | Java Development\n" +
                   "\nContributions:\n" +
                   Design.YELLOW + "  - " + Design.WHITE + "URL Scanner Design & Phishing Pattern Detection\n" +
                   Design.YELLOW + "  - " + Design.WHITE + "Email Scanner Logic & Keyword Heuristics\n" +
                   Design.YELLOW + "  - " + Design.WHITE + "Threaded Loading Animations & UI Enhancements\n" +
                   Design.YELLOW + "  - " + Design.WHITE + "Blacklist File Handling and Menu Integration\n" +
                   "\nPowered By: " + Design.YELLOW + "Java Standard Edition (Java SE)\n" +
                   Design.WHITE + "Libraries Used: java.util, java.net, java.util.regex, java.io\n" +
                   "\nSpecial Thanks: " + Design.YELLOW + "Open Source Community & Cybersecurity Enthusiasts\n" +
                   Design.WHITE +
                   "\nStay Safe, Stay Secure.\n"
        );
    }
}
