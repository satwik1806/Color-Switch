import java.io.Serializable;
import java.util.ArrayList;

public class Player
{
    private static int UID=0;
    private int ID=0;
    private String name;
    private String username;
    private Player_Menu player_menu;
    private Game_Screen gameScreen;
    private Player_Menu playermenu;


    private int playerscore=0;

    Player()
    {
        UID=this.ID;
    }

    public void start(){
        if(player_menu == null){
//            this.player_menu =
        }
        player_menu.operatenow();
    }

    Player(String name, String username)
    {
        this.name = name;
        this.username = username;
        UID++;
        UID=this.ID;
    }


    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }


    public Game_Screen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(Game_Screen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public int getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(int playerscore) {
        this.playerscore = playerscore;
    }


}
