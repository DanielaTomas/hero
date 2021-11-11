import com.googlecode.lanterna.graphics.TextGraphics;
public abstract class Element {
    final Position position;

    Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public abstract void draw(TextGraphics graphics);

    public Position getPosition() {
        return position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
}
