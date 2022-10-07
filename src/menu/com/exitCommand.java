package menu.com;

public class exitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
