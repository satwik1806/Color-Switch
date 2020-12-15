import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable
{
    private static int UID=0;
    private int ID=0;
    private String name;
    private String username;

    private Game_Screen gameScreen;

    private ArrayList<Game_Screen> glist=new ArrayList<>();


    private int playerscore=0;

    Player()
    {
        UID=this.ID;
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

    public void addGameScreen(Game_Screen g)
    {
        glist.add(g);
    }

    public int getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(int playerscore) {
        this.playerscore = playerscore;
    }


}
