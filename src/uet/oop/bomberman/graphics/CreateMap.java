package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.entities.Bomitem;
import uet.oop.bomberman.entities.Flameitem;
import uet.oop.bomberman.entities.Speeditem;
import uet.oop.bomberman.entities.WallPassitem; // các import này giúp chương trình truy cấp đến các lớp class khác nhau bao gồm
// các lơp đối tượng entities và các loại Block item trong game

import static uet.oop.bomberman.BombermanGame.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class   CreateMap {  // tạo bản đồ từ 1 tệp tin từ dữ liệu được lưu
    public CreateMap(String pathLevel) {
        File fileName = new File(pathLevel);        //tạo đối tượng File từ tệp pathlevel
        try (FileReader reader = new FileReader(fileName)) {            // mở tệp tin
            Scanner sc = new Scanner(reader);           // dùng scanner để đọc tệp tin
            String mapInfo = sc.nextLine();                // đọc dòng 1 chứa thông tin về cấp độ chiều cao chiều rộng của map
            StringTokenizer token = new StringTokenizer(mapInfo);      //tách chuỗi mapInfo thành các token
            // chuyển từu string sang interger
            _gameLevel = Integer.parseInt(token.nextToken());
            _mapHeight = Integer.parseInt(token.nextToken());
            _mapWidth = Integer.parseInt(token.nextToken());

            while (sc.hasNextLine()) {              // trong khi sc có thể lặp qua từng dòng
                objIdx = new int[_mapWidth][_mapHeight];            // Create new obj mapIdx in main file.
                listIsKilled = new int[_mapWidth][_mapHeight];         // Create new obj listKill in main file.
                for (int i = 0; i < _mapHeight; ++i) {
                    String lineInfo = sc.nextLine();                // đọc thông tin từ dòng
                    StringTokenizer tokenLineInfo = new StringTokenizer(lineInfo);      // tách dong lineinfo thành các token

                    for (int j = 0; j < _mapWidth; ++j) {
                        int value = Integer.parseInt(tokenLineInfo.nextToken());
                        Entity object;                              // Khởi tạo một đối tượng kiểu Entity(lơp cha của các đối tượng trong game)

                        // This if - else statement running, and we got a full map for a game.
                        // Through the program, in the for-loop statement, we can get the map according to each loop it passed.
                        switch (value) {
                            case 1:
                                objIdx[j][i] = value;
                                object = new Portal(j, i, Sprite.portal.getFxImage());//vị triws portal
                                value = 0;
                                break;
                            case 2:
                                objIdx[j][i] = value;
                                object = new Wall(j, i, Sprite.wall.getFxImage());//tường
                                break;
                            case 3:
                                objIdx[j][i] = value;
                                object = new Brick(j, i, Sprite.brick.getFxImage());//gạch
                                break;
                            case 5:
                                objIdx[j][i] = value;
                                object = new WallPassitem(j, i, Sprite.brick.getFxImage());//vật phẩm giúp người chơi vượt qua tường
                                break;
                            case 6:
                                objIdx[j][i] = value;
                                object = new Speeditem(j, i, Sprite.brick.getFxImage());//tăng tốc
                                break;
                            case 7:
                                objIdx[j][i] = value;
                                object = new Flameitem(j, i, Sprite.brick.getFxImage());//tặng phạm vi lửa
                                break;
                            case 8:
                                objIdx[j][i] = value;
                                object = new Bomitem(j, i, Sprite.brick.getFxImage());//vượt qua boom
                                break;
                            default:
                                objIdx[j][i] = value;
                                object = new Grass(j, i, Sprite.grass.getFxImage());
                        }

                        stillObjects.add(object);

                    }
                }

            }

        } catch (IOException e) {               // Catch exception.
            e.printStackTrace();                // printStackTrace(): Help to understand where the problem is actually happening.
        }
    }
}
