package uet.oop.bomberman;
import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<Entity> allEntity = new ArrayList<>();

    public GameBoard ( List<Entity> e) {
        this.allEntity = e;
    }
    public void AddEntity(Entity entity) {
        this.allEntity.add(entity);

    }
    public void setAllEntity(List<Entity> allEntity) {
        this.allEntity = allEntity;
    }
    public List<Entity> getAllEntity() {
        return allEntity;
    }

}
