package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import uet.oop.bomberman.Menu.MenuGame;
import uet.oop.bomberman.Menu.MenuGameOver;
import uet.oop.bomberman.Menu.MenuPause;
import uet.oop.bomberman.Menu.MenuWinGame;
import uet.oop.bomberman.entities.*;

import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;


public class BombermanGame extends Application {
    public static int score = 0;
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;

    public static Group root;

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
    public static List<Entity> entitiesToRemove = new ArrayList<>(); // tao list cac object can xoa


    public static ImageView imageView;

    public static ImageView View;
    public static boolean isPause = false;
    public static boolean running = true;
    public static ImageView V;
    public static ImageView imgView;
    public static Pane p;
    public static Pane r;
    public static Pane pane;
    public static Pane pa;
    public static Pane pp;
    public static Rectangle bg;


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {

        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // tao label
        Label scoreLabel = new Label("score :        " +  " level  : ");
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-padding: 10;");

        // Tao root container

        root = new Group();
        root.getChildren().add(canvas);

        // thiet ke giao dien
        MenuGame menuGame = new MenuGame();
        r = new Pane();
        r.getChildren().add(menuGame);
        Image img1 = new Image("file:res/imageMenu/BomberMenu.png");
        imageView = new ImageView(img1);

        MenuGameOver menuGameOver = new MenuGameOver();
        p = new Pane();
        p.getChildren().add(menuGameOver);
        Image img2 = new Image("file:res/imageMenu/Gameover.png");
        V = new ImageView(img2);


        MenuWinGame menuWinGame = new MenuWinGame();
        pane = new Pane();
        pane.getChildren().add(menuWinGame);
        Image img3 = new Image("file:res/imageMenu/winner.png");
        imgView = new ImageView(img3);

        MenuPause menuPause = new MenuPause();
        pp = new Pane();
        pp.getChildren().add(menuPause);
        bg = new Rectangle(300, 28);
        bg.setFill(Color.GRAY);
        bg.setY(2);
        bg.setX(300);
        pa = new Pane();
        root.getChildren().clear(); // Đảm bảo không thêm đối tượng trùng lặp vào root
        root.getChildren().addAll(canvas, imageView, r);



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
        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        Entity ballom = new Balloom(5,10,Sprite.balloom_left1.getFxImage());
        Entity bomitem = new Bomitem(5,5,Sprite.powerup_bombs.getFxImage());
        Entity flameitem = new Flameitem(5,6,Sprite.powerup_flames.getFxImage());
        entities.add(flameitem);
        entities.add(bomitem);
        entities.add(ballom);
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
        for(Entity e : new ArrayList<>(entities)) {  // tranh viec xoa doi tuong nao day trong vong lap  ko gay loi
            e.update();
        }
        entities.removeAll(entitiesToRemove);
        entitiesToRemove.clear();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }

}
