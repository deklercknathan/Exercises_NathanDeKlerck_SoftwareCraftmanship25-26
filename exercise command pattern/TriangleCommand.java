public class TriangleCommand implements Command {

    private Receiver receiver;

    public TriangleCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.actionTriangle();
    }
}
