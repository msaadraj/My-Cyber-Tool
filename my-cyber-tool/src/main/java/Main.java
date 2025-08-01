
import org.fusesource.jansi.AnsiConsole;

import gui.Animations;
import service.MainMenu;

public class Main {

    public static void main(String[] args){
    
    AnsiConsole.systemInstall();  
    Animations.welcomeTo();
    MainMenu.mainMenu();
    AnsiConsole.systemUninstall();
    }
}
