package service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

import gui.Animations;
import gui.Design;

public class ScaningURL extends MainMenu {
    private static String urlStr ;

    public static void header(){
    Design.clearContent();
    System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
    System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW + ansi().bold() +"                           SCAN URL LINK                          "+Design.RED+"            ║"+Design.RESET);
    System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET); 
    }

    public static void urlScan() {
        header();
        System.out.println(Design.RED + "\n───────────────────────────────────────────────────────────────────────────────────────────");
        urlStr = validateURL(sc, "   Enter URL Here >    ");
        System.out.println(Design.RED + "───────────────────────────────────────────────────────────────────────────────────────────\n");

        Animations.loadingCircle("Scanning");
        header();

        List<String> issues = scanURL(urlStr);
        if (issues.isEmpty()) {
            System.out.println(Design.YELLOW + "\n───────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println(Design.GREEN + "No issues detected. URL '" + Design.YELLOW + urlStr + Design.GREEN + "' appears safe." + Design.RESET);
            System.out.println(Design.YELLOW + "───────────────────────────────────────────────────────────────────────────────────────────\n");        
        } else {
            System.out.println(Design.YELLOW + "\n───────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println(Design.RED + "In URl '" + Design.YELLOW + urlStr + Design.RED + "' Detected the following potential issues:" + Design.RESET);
            System.out.println(Design.YELLOW + "───────────────────────────────────────────────────────────────────────────────────────────\n"); 
            for (String issue : issues) {
                System.out.println(Design.RED + " - " + issue + Design.RESET);
            }
            System.out.println(Design.YELLOW + "\n───────────────────────────────────────────────────────────────────────────────────────────\n"); 
        }
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

    private static List<String> scanURL(String urlStr) {
    List<String> issues = new ArrayList<>();
    try {
        URL url = new URL(urlStr);
        String host = url.getHost().toLowerCase();

        if (host.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
            issues.add("Numeric IP address instead of domain");
        }

        if (urlStr.contains("@")) {
            issues.add("Embedded '@' in URL");
        }

        if (host.startsWith("xn--")) {
            issues.add("Punycode (IDN homograph) domain");
        }

        String[] parts = host.split("\\.");
        if (parts.length > 4) {
            issues.add("Excessive subdomain levels: " + parts.length);
        }

        String tld = parts[parts.length - 1];
        String[] rareTlds = {"tk","ml","ga","cf","gq"};
        for (String rare : rareTlds) {
            if (tld.equalsIgnoreCase(rare)) {
                issues.add("Rare/Free TLD: ." + rare);
            }
        }

        if (!url.getProtocol().equalsIgnoreCase("https")) {
            issues.add("Non-HTTPS (fails TLS)");
        }

        int port = url.getPort();
        if (port != -1 && port != 80 && port != 443) {
            issues.add("Non-standard port: " + port);
        }

        String[] shorteners = {"bit.ly","tinyurl.com","goo.gl","t.co"};
        for (String s : shorteners) {
            if (host.equalsIgnoreCase(s)) {
                issues.add("URL uses shortening service: " + s);
            }
        }

        if (url.getPath().matches(".*\\.(exe|scr|zip|rar)$")) {
            issues.add("Direct link to executable/archive");
        }

        String[] hostKeywords = {
            "secure", "alert", "verify", "reset",
            "pay", "payment", "invoice", "update", "now", "info"
        };
        for (String kw : hostKeywords) {
            if (host.contains(kw)) {
                issues.add("Suspicious keyword in domain: \"" + kw + "\"");
            }
        }

        long hyphens = host.chars().filter(ch -> ch == '-').count();
        if (hyphens > 2) {
            issues.add("Too many hyphens in domain (" + hyphens + ")");
        }

        int chainMarkers = host.split("\\.com\\.").length - 1;
        if (chainMarkers >= 1) {
            issues.add("Chained domains detected (" + chainMarkers + " extra '.com.')");
        }

    } catch (MalformedURLException e) {
        issues.add("Malformed URL (parsing error)");
    }
    return issues;
}
}

