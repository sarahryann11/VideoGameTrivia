package csci490.videogametrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sarah on 2/22/2018.
 */

public class WelcomeScreen extends AppCompatActivity {
    Button startAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_view);

        startAppButton = findViewById(R.id.startAppButton);
        startAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, HomeScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });
    }
}
