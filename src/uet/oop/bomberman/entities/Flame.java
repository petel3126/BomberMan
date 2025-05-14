package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Flame extends Entity {
    private int animation;
    private int timeExplode = 120;

    public Flame(int x , int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void update() {
        timeExplode --;

        if(timeExplode <=0) {
            BombermanGame.entities.remove(this);
        }
    }

//    public void ExplodingLeft() {
//        img = Sprite.movingSprite(Sprite.)
//    }


}
