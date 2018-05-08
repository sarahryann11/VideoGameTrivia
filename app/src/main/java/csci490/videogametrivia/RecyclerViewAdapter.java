package csci490.videogametrivia;

/**
 * Created by Sarah on 4/19/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import csci490.videogametrivia.entities.Highscore;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Highscore> highscoreList;
    private View.OnLongClickListener longClickListener;

    public RecyclerViewAdapter(List<Highscore> highscoreList, View.OnLongClickListener longClickListener) {
        this.highscoreList = highscoreList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Highscore highscore = highscoreList.get(position);
        holder.nameTextView.setText(highscore.getName());
        holder.scoreTextView.setText(highscore.getScore());
        holder.itemView.setTag(highscore);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return highscoreList.size();
    }

    public void addItems(List<Highscore> highscoreList) {
        this.highscoreList = highscoreList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView scoreTextView;
        private TextView nameTextView;

        RecyclerViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            scoreTextView = view.findViewById(R.id.scoreTextView);
        }
    }
}