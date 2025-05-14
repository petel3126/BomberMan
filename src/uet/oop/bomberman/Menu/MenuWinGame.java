package uet.oop.bomberman.Menu;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import static uet.oop.bomberman.BombermanGame.*;


    public class MenuWinGame extends Parent {
        public MenuWinGame() {
            VBox menu = new VBox(15);
            menu.setTranslateX(300);
            menu.setTranslateY(200);

            MyButton PlayBt = new MyButton("PlayAgain");
            PlayBt.setOnMouseClicked(event -> {

                root.getChildren().removeAll(pane, imgView);
                root.getChildren().add(bg);
                root.getChildren().add(pa);
            });

            MyButton ExitBt = new MyButton("Exit");
            ExitBt.setOnMouseClicked(event -> {
                System.exit(0);
            });

            menu.getChildren().addAll(PlayBt, ExitBt);

            getChildren().addAll(menu);
        }
    }



