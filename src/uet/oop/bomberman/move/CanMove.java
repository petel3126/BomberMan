package uet.oop.bomberman.move;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;


public class CanMove {
    public static boolean checkRun(Entity entity) {
        if (entity instanceof Bomber) {
            for (Entity e : BombermanGame.stillObjects) {
                if (e instanceof Wall) {
                    if (intersects(entity, e)) {
                        return false;
                    }
                }
                if(e instanceof Brick) {
                    if (intersects(entity, e)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean intersects(Entity a, Entity b) {
        // kiem tra theo toa do hinh chu nhat thay vi tam
        int aX = a.getx();
        int aY = a.gety();
        int bX = b.getx();
        int bY = b.gety();

        int size = Sprite.SCALED_SIZE;

        return aX < bX + size &&
                aX + size > bX &&
                aY < bY + size &&
                aY + size > bY;
    }


}
