package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.move.CanMove;
import uet.oop.bomberman.BombermanGame;

public class Bomber extends Entity {
    private int animation;
    private boolean moving;
    private boolean movingup;
    private boolean movingleft;
    private boolean movingright;
    private boolean movingdown;
    private int timeDead = 60;
    private int direction = -1; // 0= up , 1 = right , 2 = down , 3 = left

    private int heart = 1;

    public void setHeart(int heart) {
        this.heart = heart;
    }
    public int getHeart() {
        return heart;
    }

    public Bomber(int x, int y, Image img ) {
        super( x, y, img);
    }

    public void handleKeyPress(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                movingup = true;
                break;
            case DOWN:
                movingdown = true;
                break;
            case LEFT:
                movingleft = true;
                break;
            case RIGHT:
                movingright = true;
                break;
            case SPACE:
                Bom.PlantBom(this);
                break;
        }
    }
    public void handleKeyRelease(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                movingup = false;
                break;
            case DOWN:
                movingdown = false;
                break;
            case LEFT:
                movingleft = false;
                break;
            case RIGHT:
                movingright = false;
                break;
        }
    }
    @Override
    public void update() {
        animation ++;
        chooseSprite();
        calculateMove();
        if(heart == 0) {
            BomBerDie();
            timeDead --;
            if(timeDead <=0) {
                this.remove();
            }
        }
    }
    private void calculateMove() {
        moving = false;
        if(movingleft) {
            x--; direction =3;
            if(CanMove.checkRun(this)) {
                moving = true;
            }
            else {
                x++;
            }
        }
        if(movingright) {
            x ++; direction = 1;
            if(CanMove.checkRun(this)) {
                moving = true;
            }
            else {
                x--;
            }
        }

        if(movingdown) {
            y++; direction = 2;
            if(CanMove.checkRun(this)) {
                moving = true;
            }
            else {
                y--;
            }
        }
        if(movingup) {
            y --; direction =0;
            if(CanMove.checkRun(this)) {
                moving = true;
            }
            else {
                y++;
            }
        }
    }
    private void chooseSprite() {
        switch (direction) {
            case 0: // UP
                img = moving ? Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animation, 60).getFxImage()
                        : Sprite.player_up.getFxImage();
                break;
            case 1: // RIGHT
                img = moving ? Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animation, 60).getFxImage()
                        : Sprite.player_right.getFxImage();
                break;
            case 2: // DOWN
                img = moving ? Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animation, 60).getFxImage()
                        : Sprite.player_down.getFxImage();
                break;
            case 3: // LEFT
                img = moving ? Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animation, 60).getFxImage()
                        : Sprite.player_left.getFxImage();
                break;
        }
    }
    public void BomBerDie() {
        img = Sprite.movingSprite(Sprite.player_dead1,Sprite.player_dead2,Sprite.player_dead3,animation,60).getFxImage();
    }
}
