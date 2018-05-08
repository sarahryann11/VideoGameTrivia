package csci490.videogametrivia;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import csci490.videogametrivia.entities.Highscore;


public class UsernameScreen extends AppCompatActivity{

    private EditText nameEditText;
    private TextView finalScore;
    private int score;

    private AddHighscoreViewModel addHighscoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.username_view);

        nameEditText = findViewById(R.id.usernameEditText);
        finalScore = findViewById(R.id.score);

        MainActivity scoreKeeper = new MainActivity();

        addHighscoreViewModel = ViewModelProviders.of(this).get(AddHighscoreViewModel.class);
        addScore();

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addScore() == null || nameEditText.getText() == null)
                    Toast.makeText(UsernameScreen.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(getApplicationContext(), LeaderboardScreen.class);

                    // This is to launch another Activity without expecting to return
                    startActivity(intent);
                    addHighscoreViewModel.addHighscore(new Highscore(
                            nameEditText.getText().toString(),
                            addScore()));
                    finish();
                }
            }
        });

    }

    public String addScore()
    {
        int score = getIntent().getIntExtra("score", -1);
        finalScore.setText(String.valueOf(score));
        return Integer.toString(score);
    }
}
