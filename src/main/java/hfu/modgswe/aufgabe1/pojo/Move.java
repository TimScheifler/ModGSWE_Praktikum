package hfu.modgswe.aufgabe1.pojo;

public class Move {
    private String MoveID;
    private String Move_White;
    private String Move_Black;

    public Move() {
    }

    public String getMoveID() {
        return MoveID;
    }

    public void setMoveID(String moveID) {
        MoveID = moveID;
    }

    public String getMove_White() {
        return Move_White;
    }

    public void setMove_White(String move_White) {
        Move_White = move_White;
    }

    public String getMove_Black() {
        return Move_Black;
    }

    public void setMove_Black(String move_Black) {
        Move_Black = move_Black;
    }
}
