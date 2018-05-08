package csci490.videogametrivia.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import csci490.videogametrivia.entities.Highscore;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface HighscoreDao {

    @Query("SELECT * FROM Highscore ORDER BY CAST(score AS unsigned) DESC LIMIT 10")
    LiveData<List<Highscore>> getAllHighscores();

    @Insert(onConflict = REPLACE)
    void addHighscore(Highscore highscore);

}
