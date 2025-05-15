package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.move.CanMove;

import javax.crypto.EncryptedPrivateKeyInfo;

public class Flaming extends Entity {
    private int animation;
    private int timeFlaming = 30;
    private  final int FlameType;
    private boolean alreadyDamaged = false;

    public Flaming(int x , int y, Image img, int FlameType) { // 0: top , 1 : left , 2 : right , 3 : down , 4 : up
        super(x,y,img);
        this.FlameType = FlameType;
    }

    @Override
    public void update() {
        timeFlaming --;
        animation ++;
        this.ExplodeFlaming();
        this.checkLife();
        if(timeFlaming == 0) {
            this.remove();
        }
    }

    public static void Exploding(Bom bom) {
        int tileSize = Sprite.SCALED_SIZE;
        int FlameX = Math.round((float) bom.getx() /tileSize);
        int FlameY = Math.round((float) bom.gety()/tileSize);

        // tao cac doi tuong ngon lua
        Flaming flaming = new Flaming(FlameX,FlameY,Sprite.bomb_exploded.getFxImage(),0);
        Flaming flamingLeft = new Flaming(FlameX-1, FlameY,Sprite.explosion_horizontal_left_last.getFxImage(),1);
        Flaming flamingRight = new Flaming(FlameX +1 , FlameY,Sprite.explosion_horizontal_right_last.getFxImage(),2);
        Flaming flamingDown = new Flaming(FlameX, FlameY +1,Sprite.explosion_vertical_down_last.getFxImage(),3);
        Flaming flamingUp = new Flaming(FlameX, FlameY -1,Sprite.explosion_vertical_top_last.getFxImage(),4);


        BombermanGame.entities.add(flaming);
        BombermanGame.entities.add(flamingLeft);
        BombermanGame.entities.add(flamingRight);
        BombermanGame.entities.add(flamingDown);
        BombermanGame.entities.add(flamingUp);

        for(Entity e : BombermanGame.stillObjects) {
            if (e instanceof Wall) {
                if (CanMove.intersects(e, flamingLeft)) {
                    BombermanGame.entitiesToRemove.add(flamingLeft);
                }
                if (CanMove.intersects(e, flamingRight)) {
                    BombermanGame.entitiesToRemove.add(flamingRight);
                }
                if (CanMove.intersects(e, flamingDown)) {
                    BombermanGame.entitiesToRemove.add(flamingDown);
                }
                if (CanMove.intersects(e, flamingUp)) {
                    BombermanGame.entitiesToRemove.add(flamingUp);
                }
            }
        }
    }

    public void ExplodeFlaming() {
        if(FlameType == 0) {
            img = Sprite.movingSprite(Sprite.bomb_exploded,Sprite.bomb_exploded1,Sprite.bomb_exploded2,animation,30).getFxImage();
        }
        else if (FlameType == 1) {
            img = Sprite.movingSprite(Sprite.explosion_horizontal_left_last,Sprite.explosion_horizontal_left_last1,Sprite.explosion_horizontal_left_last2, animation, 30).getFxImage();
        }
        else if (FlameType == 2) {
            img = Sprite.movingSprite(Sprite.explosion_horizontal_right_last,Sprite.explosion_horizontal_right_last1,Sprite.explosion_horizontal_right_last2,animation,30).getFxImage();

        }
        else if (FlameType == 3) {
            img = Sprite.movingSprite(Sprite.explosion_vertical_down_last,Sprite.explosion_vertical_down_last1,Sprite.explosion_vertical_down_last2,animation,30).getFxImage();
        }

        else if (FlameType == 4) {
            img = Sprite.movingSprite(Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last1,Sprite.explosion_vertical_top_last2,animation,30).getFxImage();
        }

    }

    public void checkLife() {
        for(Entity e : BombermanGame.entities) {
            if(e instanceof Bomber && !alreadyDamaged) {
                if (CanMove.intersects(e, this)) {
                    ((Bomber) e).setHeart(((Bomber) e).getHeart()-1);
                    alreadyDamaged = true;
                }
            }
            if(e instanceof Ballom && !alreadyDamaged) {
                if(CanMove.intersects(e,this)) {
                    ((Ballom) e).setHearBallom(((Ballom) e).getHearBallom() -1);
                    alreadyDamaged = true;
                }
            }
        }
    }
}
