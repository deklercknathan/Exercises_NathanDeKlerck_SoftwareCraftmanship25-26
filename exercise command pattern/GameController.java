public class GameController {

    private Command cross;
    private Command triangle;
    private Command square;
    private Command circle;

    public void setCross(Command cross) {
        this.cross = cross;
    }

    public void setTriangle(Command triangle) {
        this.triangle = triangle;
    }

    public void setSquare(Command square) {
        this.square = square;
    }

    public void setCircle(Command circle) {
        this.circle = circle;
    }

    public void pressCross() {
        cross.execute();
    }

    public void pressTriangle() {
        triangle.execute();
    }

    public void pressSquare() {
        square.execute();
    }

    public void pressCircle() {
        circle.execute();
    }
}
