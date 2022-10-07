package menu.com;

public class checkCommand implements Command {
    @Override
    public void execute() {
        Main.printGiftComposition();
    }
}