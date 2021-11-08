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

    public void draw(Screen screen) throws IOException {
        hero.draw(screen);
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
         hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        if(position.getX() >= width && position.getY() <= height) return true;
        return false;
    }

}
