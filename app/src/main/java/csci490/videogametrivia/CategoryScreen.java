package csci490.videogametrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sarah on 2/22/2018.
 */

public class CategoryScreen extends AppCompatActivity {
    Button actionAdventureButton;
    Button storyDrivenButton;
    Button mmoButton;
    Button anyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_view);

        actionAdventureButton = findViewById(R.id.actionAdventureButton);
        storyDrivenButton = findViewById(R.id.storyDrivenButton);
        mmoButton = findViewById(R.id.mmoButton);
        anyButton = findViewById(R.id.anyButton);

        actionAdventureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryScreen.this, MainActivity.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });

        storyDrivenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryScreen.this, StoryActivity.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });

        mmoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryScreen.this, MMOActivity.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });

        anyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryScreen.this, ComingSoonScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });
    }
}
