import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable
{
    private static int UID=0;
    private int ID=0;
    private String name;
    private String username;



    private Player_Menu player_menu;
    private Game_Screen gameScreen;

    private ArrayList<Game_Screen> gamescreens=new ArrayList<>();


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


    public Player_Menu getPlayer_menu() {
        return player_menu;
    }

    public void setPlayer_menu(Player_Menu player_menu) {
        this.player_menu = player_menu;
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

    public void setGameScreen(Game_Screen gs) {
        this.gameScreen = gs;
        gamescreens.add(gs);

    }

    public int getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(int playerscore) {
        this.playerscore = playerscore;

    }


}
