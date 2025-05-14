package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;


import static uet.oop.bomberman.BombermanGame.*;

public class MenuGame extends Parent {
    public MenuGame() {
        VBox menu = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(350);


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
