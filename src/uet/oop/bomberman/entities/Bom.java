package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;


public class Bom extends Entity {
    private int timeToExplode = 180;
    private int animation;


    public Bom(int x, int y, Image img) {
        super(x,y,img);
    }

    @Override
    public void update() {
        animation++;
        timeToExplode --;
        this.Explode();
        if(timeToExplode == 0 ) {
            Flaming.Exploding(this);
            this.remove();
        }
    }

    public static void PlantBom(Entity entity) {
            int tileSize = Sprite.SCALED_SIZE;
            int BomX = Math.round((float) entity.getx() /tileSize);
            int BomY =Math.round((float) entity.gety()/tileSize);

            Entity bom = new Bom(BomX,BomY,Sprite.bomb.getFxImage());
            BombermanGame.entities.add(bom);
    }

    public void Explode() {
        img = Sprite.movingSprite(Sprite.bomb,Sprite.bomb_1,Sprite.bomb_2,  animation,60).getFxImage();
    }
}
