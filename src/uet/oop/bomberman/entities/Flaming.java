package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.move.CheckMove;

import java.util.HashSet;
import java.util.Set;


public class Flaming extends Entity {
    private int animation;
    private int timeFlaming = 30;
    private  final int FlameType;
    private final Set<Entity> damagedEntities = new HashSet<>();

    public Flaming(int x , int y, Image img, int FlameType) { // 0: top , 1 : left , 2 : right , 3 : down , 4 : up 5 : vertical 6 ; horizontal
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
        for(int i = 1;  i < bom.getLength(); i++) {
            Flaming flamingVertical = new Flaming(FlameX , FlameY +i,Sprite.explosion_vertical.getFxImage(),5);
            Flaming flamingVertical1 = new Flaming(FlameX , FlameY -i,Sprite.explosion_vertical.getFxImage(),5);
            Flaming flamingHorizontal = new Flaming(FlameX +i, FlameY ,Sprite.explosion_horizontal.getFxImage(),6);
            Flaming flamingHorizontal1 = new Flaming(FlameX  -i, FlameY ,Sprite.explosion_horizontal.getFxImage(),6);
            BombermanGame.entities.add(flamingHorizontal);
            BombermanGame.entities.add(flamingHorizontal1);
            BombermanGame.entities.add(flamingVertical1);
            BombermanGame.entities.add(flamingVertical);
        }
        Flaming flaming = new Flaming(FlameX,FlameY,Sprite.bomb_exploded.getFxImage(),0);
        Flaming flamingLeft = new Flaming(FlameX- bom.getLength(), FlameY,Sprite.explosion_horizontal_left_last.getFxImage(),1);
        Flaming flamingRight = new Flaming(FlameX + bom.getLength() , FlameY,Sprite.explosion_horizontal_right_last.getFxImage(),2);
        Flaming flamingDown = new Flaming(FlameX, FlameY + bom.getLength(),Sprite.explosion_vertical_down_last.getFxImage(),3);
        Flaming flamingUp = new Flaming(FlameX, FlameY - bom.getLength(),Sprite.explosion_vertical_top_last.getFxImage(),4);


        BombermanGame.entities.add(flaming);
        BombermanGame.entities.add(flamingLeft);
        BombermanGame.entities.add(flamingRight);
        BombermanGame.entities.add(flamingDown);
        BombermanGame.entities.add(flamingUp);

        for(Entity e : BombermanGame.stillObjects) {
            if (e instanceof Wall) {
                for(Entity f : BombermanGame.entities) {
                    if(f instanceof Flaming) {
                        if (CheckMove.intersects(e, f)) {
                            BombermanGame.entitiesToRemove.add(f);
                        }
                    }
                }
            }
        }
    }

    public void ExplodeFlaming() {
        switch (FlameType) {
            case 0:
                img = Sprite.movingSprite(
                        Sprite.bomb_exploded,
                        Sprite.bomb_exploded1,
                        Sprite.bomb_exploded2,
                        animation, 30
                ).getFxImage();
                break;

            case 1:
                img = Sprite.movingSprite(
                        Sprite.explosion_horizontal_left_last,
                        Sprite.explosion_horizontal_left_last1,
                        Sprite.explosion_horizontal_left_last2,
                        animation, 30
                ).getFxImage();
                break;

            case 2:
                img = Sprite.movingSprite(
                        Sprite.explosion_horizontal_right_last,
                        Sprite.explosion_horizontal_right_last1,
                        Sprite.explosion_horizontal_right_last2,
                        animation, 30
                ).getFxImage();
                break;

            case 3:
                img = Sprite.movingSprite(
                        Sprite.explosion_vertical_down_last,
                        Sprite.explosion_vertical_down_last1,
                        Sprite.explosion_vertical_down_last2,
                        animation, 30
                ).getFxImage();
                break;

            case 4:
                img = Sprite.movingSprite(
                        Sprite.explosion_vertical_top_last,
                        Sprite.explosion_vertical_top_last1,
                        Sprite.explosion_vertical_top_last2,
                        animation, 30
                ).getFxImage();
                break;
            case 5 :
                img = Sprite.movingSprite(
                        Sprite.explosion_vertical,
                        Sprite.explosion_vertical1,
                        Sprite.explosion_vertical2,
                        animation,60
                ).getFxImage();
                break;
            case 6 :
                img = Sprite.movingSprite(
                        Sprite.explosion_horizontal,
                        Sprite.explosion_horizontal1,
                        Sprite.explosion_horizontal2,
                        animation,60
                ).getFxImage();
                break;
        }


    }

    public void checkLife() {
        for(Entity e : BombermanGame.entities) {
            if (CheckMove.intersects(e, this) && !damagedEntities.contains(e)) {
                if (e instanceof Bomber) {
                    ((Bomber) e).setHeart(((Bomber) e).getHeart() - 1);
                    damagedEntities.add(e);
                }
                else if (e instanceof Balloom) {
                    ((Balloom) e).setHeartBalloom(((Balloom) e).getHeartBalloom() - 1);
                    damagedEntities.add(e);
                }
            }
        }
    }
}
