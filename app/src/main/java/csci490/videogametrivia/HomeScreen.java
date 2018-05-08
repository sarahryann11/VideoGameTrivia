package csci490.videogametrivia;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import csci490.videogametrivia.data.HighscoreDatabase;

/**
 * Created by Sarah on 2/22/2018.
 */

public class HomeScreen extends AppCompatActivity {
    private static final String DATABASE_NAME = "usernames";
    HighscoreDatabase highscoreDB;
    Button playButton;
    Button howToButton;
    Button leaderboardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);

        playButton = findViewById(R.id.playButton);
        howToButton = findViewById(R.id.howToButton);
        leaderboardsButton = findViewById(R.id.leaderboardsButton);

        highscoreDB = Room.databaseBuilder(this, HighscoreDatabase.class, DATABASE_NAME).build();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });

        howToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HowToScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });

        leaderboardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LeaderboardScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });
    }
}
