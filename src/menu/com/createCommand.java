package menu.com;

public class createCommand implements Command {
    @Override
    public void execute() {
        Main.createGift();
    }
}