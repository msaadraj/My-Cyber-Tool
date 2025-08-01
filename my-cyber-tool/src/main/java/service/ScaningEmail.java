package service;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

import gui.Animations;
import gui.Design;
import model.Validation;
public class ScaningEmail extends MainMenu{
    
    public static void header(){
    Design.clearContent();
    System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
    System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW + ansi().bold() +"                           SCAN EMAIL                             "+Design.RED+"            ║"+Design.RESET);
    System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET); 
    } 

public static void emailScan() {
    header();
    System.out.println(Design.RED + "\n───────────────────────────────────────────────────────────────────────────────────────────");
    String sender = Validation.validateEmail(sc, "   Enter SENDER EMAIL Here >    ");
    System.out.println(Design.RED + "───────────────────────────────────────────────────────────────────────────────────────────\n");

    Animations.loadingCircle("Scanning");
    header();

    List<String> alerts = new ArrayList<>();

    String local = sender.substring(0, sender.indexOf('@')).toLowerCase();
    String domain = sender.substring(sender.indexOf('@') + 1).toLowerCase();

    String[] localKeywords = {"invoice", "billing", "admin", "support", "security", "alert"};
    for (String kw : localKeywords) {
        if (local.contains(kw)) {
            alerts.add("Suspicious local-part keyword: \"" + kw + "\"");
        }
    }

    String[] domainKeywords = {"secure", "alert", "verify", "update", "payments"};
    for (String kw : domainKeywords) {
        if (domain.contains(kw) && !domain.equals("secure")) {
            alerts.add("Suspicious domain keyword: \"" + kw + "\"");
        }
    }

    long hyphenCount = domain.chars().filter(ch -> ch == '-').count();
    if (hyphenCount > 0) {
        alerts.add("Hyphen(s) detected in domain (" + hyphenCount + ")");
    }

    String[] parts = domain.split("\\.");
    if (parts.length > 3) {
        alerts.add("Unusual subdomain depth: " + parts.length + " levels");
    }

    if (alerts.isEmpty()) {
        System.out.println(Design.YELLOW +
            "\n───────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Design.GREEN + "No suspicious indicators found in '" + sender + "'" + Design.RESET);
        System.out.println(Design.YELLOW +
            "───────────────────────────────────────────────────────────────────────────────────────────\n");
    } else {
        System.out.println(Design.YELLOW +
            "───────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(Design.RED +
            "Suspicious sender '" + Design.YELLOW + sender + Design.RED + "' detected:" + Design.RESET);
        System.out.println(Design.YELLOW +
            "───────────────────────────────────────────────────────────────────────────────────────────\n");
        alerts.forEach(a -> System.out.println("  - " + Design.RED + a + Design.RESET));
        System.out.println(Design.YELLOW +
            "\n───────────────────────────────────────────────────────────────────────────────────────────\n");
    }
}

 
}
