package menu.com;

import java.util.*;

public class MainMenu {
    private Map<String, Command> MenuItems;

    public MainMenu(){
        MenuItems = new LinkedHashMap<>();
        MenuItems.put("info", new infoCommand());
        MenuItems.put("create", new createCommand());
        MenuItems.put("check", new checkCommand());
        MenuItems.put("delete", new deleteCommand());
        MenuItems.put("exit", new exitCommand());
    }
    public void execute(String command){
        MenuItems.getOrDefault(command, () -> System.out.println("Incorrect command")).execute();
    }
    public Set<String> getCommands(){
        return  MenuItems.keySet();
    }
}
