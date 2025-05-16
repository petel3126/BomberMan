package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.move.CheckMove;

import java.util.Random;


public class Balloom extends Entity{
    private int speedX = 1;
    //private int speedY = 1;
    private int heartBalloom = 1;
    private int timedied = 30;

    public void setHeartBalloom (int hearBallom) {
        this.heartBalloom = hearBallom;
    }
    public int getHeartBalloom() {
        return heartBalloom;
    }
    private int animation ;
    public Balloom(int x , int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void update() {
        animation ++;
        move();
        moving();
//        x += speedX;
        //y += speedY;
        if(heartBalloom <= 0) {
            timedied --;
            if(timedied == 0) {
                this.remove();
            }
        }
    }
    private boolean hasAttack = false;
    public void move() {
        Random rand = new Random();
        for(Entity e : BombermanGame.stillObjects) {
            if(e instanceof  Wall && CheckMove.intersects(this,e)){
                speedX = speedX * (-1);
            }
        }
        for(Entity e : BombermanGame.entities) {
            if(e instanceof  Bomber && CheckMove.intersects(this,e) && !hasAttack) {
                ((Bomber) e).setHeart(((Bomber) e).getHeart()-1);
                hasAttack = true;
            }
        }
    }

    public void moving() {
        if(speedX <0) {
            img  = Sprite.movingSprite(Sprite.balloom_left1,Sprite.balloom_left2,Sprite.balloom_left3,animation,30).getFxImage();
        }
        else if (speedX > 0) {
            img = Sprite.movingSprite(Sprite.balloom_right1,Sprite.balloom_right2,Sprite.balloom_right3,animation,30).getFxImage();
        }
        if(heartBalloom ==0) {
            img = Sprite.balloom_dead.getFxImage();
            img = Sprite.movingSprite(Sprite.mob_dead1,Sprite.mob_dead2,Sprite.mob_dead3,animation,30).getFxImage();
        }
    }
}
