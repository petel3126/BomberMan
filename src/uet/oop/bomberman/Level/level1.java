package uet.oop.bomberman.Level;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity.*;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bom.*;
import static uet.oop.bomberman.graphics.Sound.updateSound;
import static uet.oop.bomberman.graphics.Sound.*;


public class level1 {
    public level1(){
        isPause=false;
        entities.clear();
        enemies.clear();
        stillObjects.clear();
        new CreateMap("res/levels/level1.txt");
        Image image1=new Image("file:res/imageMenu/Pause.png");
        View=new ImageView(image1);
        View.setX(0);
        score = 0;
        stateExplosion = 1;
        isPlanted = 0;
        bombPower = 0;
        bombPowerLeft = 0;
        bombPowerRight = 0;
        bombPowerUp = 0;
        bombPowerDown = 0;
        lastEdgeUp = null;
        lastEdgeDown = null;
        lastEdgeLeft = null;
        lastEdgeRight = null;
        isEdge = false;
        isMiddle = false;
        listBombMiddleVertical.clear();
        listBombMiddleHorizontal.clear();
        isSoundDie = false;
        isSoundScreen = false;

        player = new Bomber(1, 1, Sprite.player_right.getFxImage());
        player.setLife(true);
    }

}
