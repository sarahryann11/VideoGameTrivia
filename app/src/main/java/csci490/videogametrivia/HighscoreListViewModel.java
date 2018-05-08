package csci490.videogametrivia;

/**
 * Created by Sarah on 4/19/2018.
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import java.util.List;

import csci490.videogametrivia.data.HighscoreDatabase;
import csci490.videogametrivia.entities.Highscore;


public class HighscoreListViewModel extends AndroidViewModel {

    private final LiveData<List<Highscore>> highscoreList;

    private HighscoreDatabase highscoreDatabase;

    public HighscoreListViewModel(Application application) {
        super(application);

        highscoreDatabase = HighscoreDatabase.getDatabase(this.getApplication());

        highscoreList = highscoreDatabase.scoreAndNameModel().getAllHighscores();
    }


    public LiveData<List<Highscore>> getAllHighscores() {
        return highscoreList;
    }

}
