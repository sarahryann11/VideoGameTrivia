/*package csci490.videogametrivia.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.util.ArrayList;

import csci490.videogametrivia.LeaderboardScreen;
import csci490.videogametrivia.UsernameScreen;
import csci490.videogametrivia.data.HighscoreDatabase;
import csci490.videogametrivia.entities.Highscore;

*//**
 * Created by Sarah on 4/17/2018.
 *//*

public class QueryTask extends AsyncTask<Void,Void,ArrayList<Highscore>> {
    HighscoreDatabase highscoreDB;
    Context context;
    public QueryTask(HighscoreDatabase highscoreDB, Context context)
    {
        this.highscoreDB = highscoreDB;
        this.context = context;
    }

    @Override
    protected void onPostExecute(ArrayList<Highscore> highscores)
    {
        super.onPostExecute(highscores);
        ArrayList<String> highscoresList = new ArrayList<>();
        for(Highscore h: highscores) {
            highscoresList.add(h.getName());
        }

        Intent i = new Intent(context, LeaderboardScreen.class);
        i.putExtra("usernames", highscoresList);
        context.startActivity(i);
    }

    @Override
    protected ArrayList<Highscore> doInBackground(Void... voids)
    {
       // ArrayList<Highscore> highscores = (ArrayList) highscoreDB.highscoreDao().getAllHighscores();
       // return highscores;
    }
}*/
