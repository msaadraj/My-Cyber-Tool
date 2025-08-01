package model;

import static org.fusesource.jansi.Ansi.ansi;

import gui.Design;
public class Instructions {

    public static void instructions(){
    Design.clearContent();
    System.out.println(Design.RED+"\n╔═════════════════════════════════════════════════════════════════════════════════════════╗"+Design.RESET);
    System.out.println(Design.RED+"║           "+Design.BOLD+Design.YELLOW + ansi().bold() +"                           INSTRUCTIONS                           "+Design.RED+"            ║"+Design.RESET);
    System.out.println(Design.RED+"╚═════════════════════════════════════════════════════════════════════════════════════════╝\n"+Design.RESET); 
    System.out.println(Design.YELLOW + "1. Scan URL Link\n" +
                                       "\nWhat it does:" + Design.WHITE + " Analyzes the URL you enter for known phishing indicators.\n" + Design.YELLOW +
                                       "How to use:\n" + Design.WHITE +
                                       "  1. Paste or type the full URL (including http:// or https://).\n" +
                                       "  2. The scanner checks for:\n" +
                                       Design.YELLOW + "      - " + Design.WHITE + "Numeric IP addresses instead of proper domains\n" +
                                       Design.YELLOW + "      - " + Design.WHITE + "Embedded '@' symbols in the link\n" +
                                       Design.YELLOW + "      - " + Design.WHITE + "Punycode (IDN homograph) tricks\n"  +
                                       Design.YELLOW + "      - " + Design.WHITE + "Excessive subdomains or hyphens\n"  +
                                       Design.YELLOW + "      - " + Design.WHITE + "Suspicious keywords (e.g. 'verify', 'secure', 'invoice')\n"  +
                                       Design.YELLOW + "      - " + Design.WHITE + "Chained domains (e.g. bank-secure.com.verify-now.com)\n"  +
                                       Design.YELLOW + "      - " + Design.WHITE + "Non-HTTPS protocols and non-standard port\n"  +
                                       Design.YELLOW + "      - " + Design.WHITE + "Direct downloads of executables or archives\n" +
                                       "  3. Paste or type the full URL (including http:// or https://).\n" 
    );
    System.out.println(Design.YELLOW + "2. Scan Email for Phishing\n" +
                   "\nWhat it does:" + Design.WHITE + " Examines a sender’s email address for red flags.\n" + Design.YELLOW +
                   "How to use:\n" + Design.WHITE +
                   "  1. Enter the sender's address exactly as shown in the email header.\n" +
                   "  2. The scanner checks the local-part (before '@') and domain for:\n" +
                   Design.YELLOW + "      - " + Design.WHITE + "Suspicious keywords (e.g. \"billing\", \"invoice\", \"alert\", \"support\")\n" +
                   Design.YELLOW + "      - " + Design.WHITE + "Unusual domain parts (e.g. \"secure-update.com\", numeric IPs)\n" +
                   Design.YELLOW + "      - " + Design.WHITE + "Multiple hyphens or excessive subdomain levels\n" +
                   "  3. It reports each indicator it finds, or confirms that none were detected.\n"
    );

    }
}
