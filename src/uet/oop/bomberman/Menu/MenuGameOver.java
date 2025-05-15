package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import uet.oop.bomberman.BombermanGame;

import static uet.oop.bomberman.BombermanGame.*;

public class MenuGameOver extends Parent {
    private MenuGame menuGame;

    public MenuGameOver() {
        VBox menu = new VBox(15);

        menu.setTranslateX(300);
        menu.setTranslateY(200);
        MyButton PlayBt = new MyButton("PlayAgain");
        PlayBt.setOnMouseClicked(event -> {

            BombermanGame.root.getChildren().removeAll(p, V);
            root.getChildren().add(bg);
            root.getChildren().add(pa);
        });

        MyButton MenuBt = new MyButton("Back To Menu");
        MenuBt.setOnMouseClicked(event -> {
            entities.clear();
//            enemies.clear();
            stillObjects.clear();
            root.getChildren().removeAll(bg, pa);
            root.getChildren().removeAll(V, p);
            root.getChildren().addAll(imageView, r);
        });
        MyButton ExitBt = new MyButton("Exit");
        ExitBt.setOnMouseClicked(event -> {
            System.exit(0);
        });

        menu.getChildren().addAll(PlayBt, MenuBt, ExitBt);

        getChildren().addAll(menu);
    }
}
