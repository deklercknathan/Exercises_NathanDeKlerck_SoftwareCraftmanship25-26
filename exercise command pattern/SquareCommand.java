public class SquareCommand implements Command {

    private Receiver receiver;

    public SquareCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionSquare();
    }
}
