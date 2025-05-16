package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.move.CanMove;

import java.util.Random;


public class Ballom extends Entity{
    private int speedX = 1;
//    private int speedY = 1;
    private int hearBalloom = 1;
    private int timedied = 30;

    public void setHearBallom (int hearBallom) {
        this.hearBalloom = hearBallom;
    }
    public int getHearBallom() {
        return hearBalloom;
    }
    private int animation ;
    public Ballom (int x , int y, Image img) {
        super(x,y,img);
    }
    @Override
    public void update() {
        animation ++;
        move();
        moving();
        x += speedX;
//        y += speedY;
        if(hearBalloom == 0) {
            timedied --;
            if(timedied ==0) {
                this.remove();
            }
        }
    }
    public void move() {
        Random rand = new Random();
        for(Entity e : BombermanGame.stillObjects) {
            if(e instanceof  Wall && CanMove.intersects(this,e)){
                speedX = speedX * (-1);
            }
        }
    }

    public void moving() {
        if(speedX <0) {
            img  = Sprite.movingSprite(Sprite.balloom_left1,Sprite.balloom_left2,Sprite.balloom_left3,animation,60).getFxImage();
        }
        else if (speedX > 0) {
            img = Sprite.movingSprite(Sprite.balloom_right1,Sprite.balloom_right2,Sprite.balloom_right3,animation,60).getFxImage();
        }
        if(hearBalloom ==0) {
            img = Sprite.balloom_dead.getFxImage();
            img = Sprite.movingSprite(Sprite.mob_dead1,Sprite.mob_dead2,Sprite.mob_dead3,animation,45).getFxImage();
        }
    }
}
