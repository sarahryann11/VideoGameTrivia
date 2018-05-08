package csci490.videogametrivia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import csci490.videogametrivia.entities.Highscore;

public class LeaderboardScreen extends AppCompatActivity implements View.OnLongClickListener {

    private HighscoreListViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    Button leaderBackHomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_view);

        leaderBackHomeButton = findViewById(R.id.leaderBackHomeButton);

        leaderBackHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaderboardScreen.this, HomeScreen.class);

                // This is to launch another Activity without expecting to return
                startActivity(intent);
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<Highscore>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel = ViewModelProviders.of(this).get(HighscoreListViewModel.class);

        viewModel.getAllHighscores().observe(LeaderboardScreen.this, new Observer<List<Highscore>>() {
            @Override
            public void onChanged(@Nullable List<Highscore> itemAndPeople) {
                recyclerViewAdapter.addItems(itemAndPeople);
            }
        });

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}
