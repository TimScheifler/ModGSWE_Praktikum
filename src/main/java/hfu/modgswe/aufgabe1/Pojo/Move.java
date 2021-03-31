package hfu.modgswe.aufgabe1.Pojo;

public class Move {
    private String MoveID;
    private String OriginField;
    private String TargetField;

    public Move() {
    }

    public String getMoveID() {
        return MoveID;
    }

    public void setMoveID(String moveID) {
        MoveID = moveID;
    }

    public String getOriginField() {
        return OriginField;
    }

    public void setOriginField(String originField) {
        OriginField = originField;
    }

    public String getTargetField() {
        return TargetField;
    }

    public void setTargetField(String targetField) {
        TargetField = targetField;
    }
}
