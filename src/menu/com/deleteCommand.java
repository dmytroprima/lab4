package menu.com;

public class deleteCommand implements Command {
    @Override
    public void execute() {
        Main.deleteGift();
    }
}
