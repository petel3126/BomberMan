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
        Image image1 = new Image("file:res/imageMenu/Pause.png");
        // Tạo ImageView từ Image
        ImageView pauseImageView = new ImageView(image1);


        MyButton PlayBt = new MyButton("Play");
        PlayBt.setOnMouseClicked(event -> {

            root.getChildren().removeAll(r, imageView);
            root.getChildren().addAll(bg, pa);
        });

        MyButton ExitBt = new MyButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt, ExitBt);

        getChildren().addAll(menu);
    }

}
