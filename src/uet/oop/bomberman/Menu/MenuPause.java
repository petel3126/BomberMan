package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.graphics.Sound.screen;

public class MenuPause extends Parent {
    public MenuPause() {
        VBox menu = new VBox(15);
        menu.setTranslateX(300);
        menu.setTranslateY(200);


        MyButton MenuBt = new MyButton("Back To Menu");
        MenuBt.setOnMouseClicked(event -> {
            entities.clear();
            enemies.clear();
            stillObjects.clear();

            root.getChildren().removeAll(pp,View);
            root.getChildren().removeAll(bg, pa);
            root.getChildren().addAll(imageView,r);
            running = true;
        });

        MyButton ResumeBt = new MyButton("Resume");
        ResumeBt.setOnMouseClicked(event -> {
            isPause = false;
            running = true;
            root.getChildren().removeAll(pp,View);
        });
        MyButton ExitBt = new MyButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(MenuBt, ResumeBt, ExitBt);

        getChildren().addAll(menu);
    }
}

