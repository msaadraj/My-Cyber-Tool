package gui;

public class Design {

    public static final String RESET = "\033[0m";  

    // Text Color
    public static final String BLACK = "\033[0;30m";  
    public static final String RED = "\033[0;31m";    
    public static final String GREEN = "\033[0;32m";  
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m";   
    public static final String PURPLE = "\033[0;35m"; 
    public static final String CYAN = "\033[0;36m";   
    public static final String WHITE = "\033[0;37m";  

    // Background Color
    public static final String BG_RED = "\033[41m";   
    public static final String BG_GREEN = "\033[42m"; 
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";  
    public static final String BG_PURPLE = "\033[45m";
    public static final String BG_CYAN = "\033[46m";  
    public static final String BG_WHITE = "\033[47m"; 

    // Bold + Underline
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\033[4m";

    // Method for Clearing the Screen
public static void clearContent() {
    System.out.print("\u001B[H\u001B[2J");
    System.out.flush();
    String[] banner = {
    BG_RED + "                                                                                         " + BG_RED + "  ",
    "  " + YELLOW + "    _____          _________        ___.                  ___________           .__    " + BG_RED + "  ",
    "  " + YELLOW + "   /     \\ ___.__. \\_   ___ \\___.__.\\_ |__   ___________  \\__    ___/___   ____ |  |   " + BG_RED + "  ",
    "  " + YELLOW + "  /  \\ /  <   |  | /    \\  \\<   |  | | __ \\_/ __ \\_  __ \\   |    | /  _ \\ /  _ \\|  |   " + BG_RED + "  ",
    "  " + YELLOW + " /    Y    \\___  | \\     \\___\\___  | | \\_\\ \\  ___/|  | \\/   |    |(  <_> |  <_> )  |__ " + BG_RED + "  ",
    "  " + YELLOW + " \\____|__  / ____|  \\______  / ____| |___  /\\___  >__|      |____| \\____/ \\____/|____/ " + BG_RED + "  ",
    "  " + YELLOW + "         \\/\\/              \\/\\/          \\/     \\/                                     " + BG_RED + "  ",
    "                                                                                           " + RESET,
    };
    for (String line : banner) {
        System.out.println(line);
    }
}
}
