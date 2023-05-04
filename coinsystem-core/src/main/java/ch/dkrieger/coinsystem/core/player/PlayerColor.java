package ch.dkrieger.coinsystem.core.player;

public class PlayerColor {

    private final String permission, color;

    public PlayerColor(String permission, String color){
        this.permission = permission;
        this.color = color;
    }

    public String getPermission(){
        return this.permission;
    }

    public String getColor(){
        return this.color;
    }
}
