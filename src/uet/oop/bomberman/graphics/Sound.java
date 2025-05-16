package uet.oop.bomberman.graphics;

import javax.sound.sampled.*; //cung cấp các lớp cần thiết để xử lí âm thanh
import javax.swing.*;//sử dụng để tạo giao diện người dùng cơ bản
import java.io.IOException;// sử dụng để xử lí lôi đến nhập xuất dữ liệu
import java.net.URL;
//sử dụng âm thanh từ đường dẫn URL
import uet.oop.bomberman.BombermanGame;

public class Sound extends JFrame{
    //khai báo các thuộc tính tĩnh
    public static Clip screen;//âm thanh nền
    public static Clip bombExplode;//âm thanh bom nổ
    public static Clip bomberDie;//âm thanh người chơi chết
    public static Clip plantBomb;//âm thanh đặt bom

    public static boolean isSoundDie;//kiemer tra âm thanh bomber
    public static boolean isSoundScreen;//kiểm tra âm thanh màn hình
    public Sound(String name,String sound){//tên tệp và âm thanh cần phát
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            URL url = this.getClass().getClassLoader().getResource(name);
            assert url != null;
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);// Mở tệp âm thanh và tạo AudioInputStream để đọc âm thanh.
            if (sound.equals("screen")) {
                screen = AudioSystem.getClip();
                screen.open(audioInput);
                FloatControl gainControl = (FloatControl) screen.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-8.0f);//giảm âm lượng
                screen.loop(1);//phát âm thanh 1 lần
            }

            if (sound.equals("explosion")) {
                bombExplode = AudioSystem.getClip();
                bombExplode.open(audioInput);
                FloatControl gainControl = (FloatControl) bombExplode.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-8.0f);
                bombExplode.start(); //phát âm thanh nổ một lần
            }

            if (sound.equals("plantBomb")) {
                plantBomb = AudioSystem.getClip();
                plantBomb.open(audioInput);
                FloatControl gainControl = (FloatControl) plantBomb.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(+6.0206f);
                plantBomb.start();
            }

            if (sound.equals("bomberDie")) {
                bomberDie = AudioSystem.getClip();
                bomberDie.open(audioInput);
                bomberDie.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void updateSound() {
        if (!isSoundScreen) {
            new Sound("sound/title_screen.wav", "screen");
            isSoundScreen = true;
        }

        if (!BombermanGame.player.getLife()) {
            screen.stop();
            if (!isSoundDie) {
                new Sound("sound/just_died.wav", "bomberDie");
                isSoundDie = true;
            }
        }
    }
}
