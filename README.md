# BomberMan
# thiết kế tựa game kinh điển Bomberman 
![demo](https://github.com/user-attachments/assets/7ba00268-4b48-43f4-ba4f-01eda7c5192a)


# Mô tả về hoạt động của trò chơi :
Nếu bạn đã từng chơi Bomberman, bạn sẽ cảm thấy quen thuộc với những đối tượng này. Chúng được được chia làm hai loại chính là nhóm đối tượng động (Bomber, Enemy, Bomb) và nhóm đối tượng tĩnh (Grass, Wall, Brick, Door, Item).

![player_right_2](https://github.com/user-attachments/assets/7681327d-2cf8-4f3d-a502-7d5d92f60314)
 Bomber là nhân vật chính của trò chơi. Bomber có thể di chuyển theo 4 hướng trái/phải/lên/xuống theo sự điều khiển của người chơi.
![balloom_left1](https://github.com/user-attachments/assets/8fbea6a6-f9da-4d28-adb7-520a06e8d85e)
 Enemy là các đối tượng mà Bomber phải tiêu diệt hết để có thể qua Level. Enemy có thể di chuyển ngẫu nhiên hoặc tự đuổi theo Bomber tùy theo loại Enemy. Các loại Enemy sẽ được mô tả cụ thể ở phần dưới.
![bomb](https://github.com/user-attachments/assets/c19e3265-466d-4100-a264-5f33d204e2c3)
 Bomb là đối tượng mà Bomber sẽ đặt và kích hoạt tại các ô Grass. Khi đã được kích hoạt, Bomber và Enemy không thể di chuyển vào vị trí Bomb. Tuy nhiên ngay khi Bomber vừa đặt và kích hoạt Bomb tại ví trí của mình, Bomber có một lần được đi từ vị trí đặt Bomb ra vị trí bên cạnh. Sau khi kích hoạt 2s, Bomb sẽ tự nổ, các đối tượng Flame  được tạo ra.
 ![grass](https://github.com/user-attachments/assets/6bd1e2fd-2ea0-41d5-854c-8912b3f0cd0e)
 Grass là đối tượng mà Bomber và Enemy có thể di chuyển xuyên qua, và cho phép đặt Bomb lên vị trí của nó
![wall](https://github.com/user-attachments/assets/d07abd6c-90d2-4569-8b12-f22851993a28)
 Wall là đối tượng cố định, không thể phá hủy bằng Bomb cũng như không thể đặt Bomb lên được, Bomber và Enemy không thể di chuyển vào đối tượng này
![brick](https://github.com/user-attachments/assets/c2fbc494-37e3-465a-8d3a-cda0a905e4a8)
 Brick là đối tượng được đặt lên các ô Grass, không cho phép đặt Bomb lên nhưng có thể bị phá hủy bởi Bomb được đặt gần đó. Bomber và Enemy thông thường không thể di chuyển vào vị trí Brick khi nó chưa bị phá hủy.
![portal](https://github.com/user-attachments/assets/7eb2fc2a-7dc3-4d63-ac9b-f2b30330e96b)
 Portal là đối tượng được giấu phía sau một đối tượng Brick. Khi Brick đó bị phá hủy, Portal sẽ hiện ra và nếu tất cả Enemy đã bị tiêu diệt thì người chơi có thể qua Level khác bằng cách di chuyển vào vị trí của Portal.

Các Item cũng được giấu phía sau Brick và chỉ hiện ra khi Brick bị phá hủy. Bomber có thể sử dụng Item bằng cách di chuyển vào vị trí của Item. Thông tin về chức năng của các Item được liệt kê như dưới đây:

![powerup_speed](https://github.com/user-attachments/assets/580d5618-436e-4a05-8e0c-f31400da6388)
 SpeedItem Khi sử dụng Item này, Bomber sẽ được tăng vận tốc di chuyển thêm một giá trị thích hợp
 ![powerup_flames](https://github.com/user-attachments/assets/7e6c8821-3e38-414a-aacb-1e776e608146)
 FlameItem Item này giúp tăng phạm vi ảnh hưởng của Bomb khi nổ (độ dài các Flame lớn hơn)
 ![powerup_bombpass](https://github.com/user-attachments/assets/e248a8c9-e503-49ca-adc9-c98fee8a4147)
 BombItem Thông thường, nếu không có đối tượng Bomb nào đang trong trạng thái kích hoạt, Bomber sẽ được đặt và kích hoạt duy nhất một đối tượng Bomb. Item này giúp tăng số lượng Bomb có thể đặt thêm một.
![powerup_wallpass](https://github.com/user-attachments/assets/ab4ca098-3945-4b88-acbc-970c933034d0)
 WallPassItem Item này giúp Bomber có khả năng đi xuyên các Brick .
 ![powerup_flamepass](https://github.com/user-attachments/assets/1a8299da-36f7-48cf-a3f9-a84f3df701e9)
 FlamePassItem Khi sử dụng Item này, Bomber sẽ không bị trừ máu bởi các đối tượng Flame .
Có nhiều loại Enemy trong Bomberman, tuy nhiên trong phiên bản này chúng tôi chỉ cài đặt năm loại Enemy dưới đây:

 Balloom là Enemy đơn giản nhất, di chuyển ngẫu nhiên với vận tốc cố định
 Oneal có tốc độ di chuyển thay đổi, lúc nhanh, lúc chậm và di chuyển "thông minh" hơn so với Balloom (biết đuổi theo Bomber)
 Doll là Enemy di chuyển giống với Balloom  tuy nhiên vận tốc lớn hơn.
 Doria là Enemy di chuyển chậm nhất nhưng bù lại có khả năng đi xuyên các Brick .
 Minvo là Enemy di chuyển nhanh nhất trong trò chơi, có khả năng đuổi theo Bomber và né Bomb.

 // thiết kế cây kế thừa : 
 ![diagram](https://github.com/user-attachments/assets/70ae0d8c-48bb-4658-a31d-505003f2556f)

 Mô tả game play, xử lý va chạm và xử lý bom nổ
Trong một màn chơi, Bomber sẽ được người chơi di chuyển, đặt và kích hoạt Bomb với mục tiêu chính là tiêu diệt tất cả Enemy và tìm ra vị trí Portal để có thể qua màn mới

Bomber sẽ bị giết khi va chạm với Enemy hoặc thuộc phạm vi Bomb nổ. Lúc đấy trò chơi kết thúc.

Enemy bị tiêu diệt khi thuộc phạm vi Bomb nổ

Một đối tượng thuộc phạm vi Bomb nổ có nghĩa là đối tượng đó va chạm với một trong các tia lửa được tạo ra tại thời điểm một đối tượng Bomb nổ.

Khi Bomb nổ, một Flame trung tâm tại vị trí Bomb nổ và bốn Flame tại bốn vị trí ô đơn vị xung quanh vị trí của Bomb xuất hiện theo bốn hướng trên/dưới/trái/phải. Độ dài bốn Flame xung quanh mặc định là 1 đơn vị, được tăng lên khi Bomber sử dụng các FlameItem.

Khi các Flame xuất hiện, nếu có một đối tượng thuộc loại Brick/Wall nằm trên vị trí một trong các Flame thì độ dài Flame đó sẽ được giảm đi để sao cho Flame chỉ xuất hiện đến vị trí đối tượng Brick/Wall theo hướng xuất hiện. Lúc đó chỉ có đối tượng Brick/Wall bị ảnh hưởng bởi Flame, các đối tượng tiếp theo không bị ảnh hưởng. Còn nếu vật cản Flame là một đối tượng Bomb khác thì đối tượng Bomb đó cũng sẽ nổ ngay lập tức.

