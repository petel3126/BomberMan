package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.graphics.Sprite;


public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;
    protected int count;
    protected int direction;
    protected int delayPerStep;
    protected boolean life = true;

    protected int standing = 1;

    protected Image img;

    private boolean removed = false;
    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }
    public Entity(){

    }


    public boolean isRemoved() {
        return removed;
    }

    public void remove() {
        this.removed = true;
    }

    public int getx() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int gety() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean getLife(){
        return life;
    }
    public void setLife(boolean life){
        this.life=life;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDelayPerStep() {
        return delayPerStep;
    }

    public void setDelayPerStep(int delayPerStep) {
        this.delayPerStep = delayPerStep;
    }
    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public void run() {
        setDelayPerStep(getDelayPerStep() + 1);
    }

    // ve hinh
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
    // nhan dau hien di chuyen tu ban phim
    public void handleKeyPress(KeyEvent event) {

    };
    public  void handleKeyRelease(KeyEvent event) {

    };
}
