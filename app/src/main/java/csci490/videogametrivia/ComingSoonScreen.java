package csci490.videogametrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sarah on 4/21/2018.
 */

public class ComingSoonScreen extends AppCompatActivity{
    private Button backToCategoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comingsoon_view);

        backToCategoriesButton = findViewById(R.id.backToCategoriesButton);

        backToCategoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CategoryScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });
    }
}
