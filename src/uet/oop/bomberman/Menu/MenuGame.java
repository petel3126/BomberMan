package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import uet.oop.bomberman.graphics.Sprite;


import javax.swing.text.View;

import static uet.oop.bomberman.BombermanGame.*;

public class MenuGame extends Parent {
    public MenuGame() {
        VBox menu = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(350);

        Image img = new Image("file:res/imageMenu/1Pause.png");

        MyButton PlayBt = new MyButton("Play");
        PlayBt.setOnMouseClicked(event -> {
            root.getChildren().removeAll(r, imageView, pp);

            // ⚠️ Reset lại phần chơi
            pa.getChildren().clear();         // Dọn phần chơi cũ
                              // ⚠️ Gọi lại hàm setup map, bomber, enemy...

            // Thêm lại phần chơi
            root.getChildren().addAll(bg, pa);

            // Thêm lại nút pause nếu chưa có
            if (!root.getChildren().contains(pauseBt)) {
                root.getChildren().add(pauseBt);
            }
        });

        MyButton ExitBt = new MyButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt, ExitBt);

        getChildren().addAll(menu);
    }

}
