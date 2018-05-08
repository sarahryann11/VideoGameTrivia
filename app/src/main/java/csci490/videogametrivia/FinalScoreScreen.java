package csci490.videogametrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sarah on 2/22/2018.
 */

public class FinalScoreScreen extends AppCompatActivity {
    Button finalBackHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscore_view);

        finalBackHomeButton = findViewById(R.id.finalBackHomeButton);
        finalBackHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalScoreScreen.this, HomeScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);

                // This is to launch another Activity with expectation that it will return
                //startActivityForResult(intent, BACKGROUND_CODE);
            }
        });
    }
}
