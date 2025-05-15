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

    protected Image img;

    private boolean removed = false;

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

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
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
