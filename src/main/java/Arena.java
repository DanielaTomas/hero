import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(new Position(10,10));
    }

    public void processKey(KeyStroke key) {
        switch(key.getKeyType()) {
           case ArrowUp :
               moveHero(hero.moveUp());
               break;
           case ArrowRight :
               moveHero(hero.moveRight());
               break;
           case ArrowLeft :
               moveHero(hero.moveLeft());
               break;
           case ArrowDown :
               moveHero(hero.moveDown());
               break;
       }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width+1, height+1), ' ');
        hero.draw(graphics);
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
         hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        return (position.getX() >= 0 && position.getX() <= width && position.getY() >= 0 && position.getY() <= height);
    }

}
