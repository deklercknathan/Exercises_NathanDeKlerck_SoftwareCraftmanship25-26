public class Main {
    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        GameController controller = new GameController();

        controller.setCross(new CrossCommand(receiver));
        controller.setTriangle(new TriangleCommand(receiver));
        controller.setSquare(new SquareCommand(receiver));
        controller.setCircle(new CircleCommand(receiver));

        controller.pressCross();
        controller.pressTriangle();
        controller.pressSquare();
        controller.pressCircle();

        System.out.println("\n--- Remapping Circle to Jump now! ---\n");

        controller.setCircle(new CrossCommand(receiver)); // Circle calls Jump
        controller.pressCircle();

    }
}
