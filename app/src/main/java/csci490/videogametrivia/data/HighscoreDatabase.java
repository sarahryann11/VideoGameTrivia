package csci490.videogametrivia.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import csci490.videogametrivia.entities.Highscore;

@Database(entities = {Highscore.class}, version = 1)
public abstract class HighscoreDatabase extends RoomDatabase {

    private static HighscoreDatabase INSTANCE;

    public static HighscoreDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), HighscoreDatabase.class, "highscore_db")
                            .build();
        }
        return INSTANCE;
    }

    public abstract HighscoreDao scoreAndNameModel();

}
