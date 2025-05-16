package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;


public class Bom extends Entity {
    private int timeToExplode = 120;
    private int animation;
    private  int length;

    public void setLength(int length) {
        this.length = length;
    }

    public  int getLength() {
        return this.length;
    }

    public Bom(int x, int y, Image img, int length) {
        super(x,y,img);
        this.length = length;
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

    public static void PlantBom(Bomber entity,int length) {
            int tileSize = Sprite.SCALED_SIZE;
            int BomX = Math.round((float) entity.getx() /tileSize);
            int BomY =Math.round((float) entity.gety()/tileSize);
            int x = 0;
            int numberBom = entity.getNumberBom();
            for(Entity e : BombermanGame.entities) {
                if(e instanceof Bom) {
                    x +=1;
                }
            }
            if( x < numberBom) {
                Entity bom = new Bom(BomX,BomY,Sprite.bomb.getFxImage(),length);
                BombermanGame.entities.add(bom);
            }
    }

    public void Explode() {
        img = Sprite.movingSprite(Sprite.bomb,Sprite.bomb_1,Sprite.bomb_2,  animation,60).getFxImage();
    }
}
