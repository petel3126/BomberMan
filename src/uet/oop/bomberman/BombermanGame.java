package uet.oop.bomberman;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.entities.Bom;
import uet.oop.bomberman.entities.Bomber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BombermanGame extends Application {
    
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    public static int _gameLevel=1;
    public static int _mapHeight=0;
    public static int _mapWidth=0;
    public static int[][] objIdx;
    public static int[][] listIsKilled;

    public static Bomber player;
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // tao laybel
        Label scoreLabel = new Label("score :              " +  " level  : ");
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-padding: 10;");

        // Tao root container
        VBox root = new VBox();
        root.getChildren().addAll(scoreLabel,canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();
        GameBoard gameBoard = new GameBoard(stillObjects);
        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage(),gameBoard);
        entities.add(bomberman);

        // xu ly phim
        scene.setOnKeyPressed(bomberman::handleKeyPress);
        scene.setOnKeyReleased(bomberman:: handleKeyRelease);

    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity e = iterator.next();
            e.update();
            if (e.isRemoved()) {
                iterator.remove();
            }
        }
        ;
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

}
