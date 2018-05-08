package csci490.videogametrivia;

/**
 * Created by Sarah on 4/19/2018.
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import csci490.videogametrivia.data.HighscoreDatabase;
import csci490.videogametrivia.entities.Highscore;


public class AddHighscoreViewModel extends AndroidViewModel {

    private HighscoreDatabase highscoreDatabase;

    public AddHighscoreViewModel(Application application) {
        super(application);

        highscoreDatabase = HighscoreDatabase.getDatabase(this.getApplication());

    }

    public void addHighscore(final Highscore highscore) {
        new addAsyncTask(highscoreDatabase).execute(highscore);
    }

    private static class addAsyncTask extends AsyncTask<Highscore, Void, Void> {

        private HighscoreDatabase db;

        addAsyncTask(HighscoreDatabase highscoreDatabase) {
            db = highscoreDatabase;
        }

        @Override
        protected Void doInBackground(final Highscore... params) {
            db.scoreAndNameModel().addHighscore(params[0]);
            return null;
        }

    }
}