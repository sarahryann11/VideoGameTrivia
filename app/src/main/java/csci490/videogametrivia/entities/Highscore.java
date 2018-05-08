package csci490.videogametrivia.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Highscore {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String score;

    public Highscore(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

}

