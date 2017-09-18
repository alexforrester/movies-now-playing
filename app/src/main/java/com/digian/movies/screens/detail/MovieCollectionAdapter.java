package com.digian.movies.screens.detail;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digian.movies.R;
import com.digian.movies.model.Part;

import java.util.List;

/**
 * Created by alexforrester on 18/09/2017.
 */

public class MovieCollectionAdapter extends RecyclerView.Adapter<MovieCollectionAdapter.ViewHolder> {
        private List<Part> parts;
        private RecyclerViewClickListener recyclerViewClickListener;

        public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private static final String TAG = ViewHolder.class.getSimpleName();

            public TextView title;
            public RecyclerViewClickListener listener;

            public ViewHolder(TextView v, RecyclerViewClickListener listener) {
                super(v);
                title = v;
                this.listener = listener;
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick(View view)");
                listener.onClick(view, getAdapterPosition());
            }
        }

        public MovieCollectionAdapter(List<Part> parts, RecyclerViewClickListener recyclerViewClickListener) {
            this.recyclerViewClickListener = recyclerViewClickListener;
            this.parts = parts;
        }

        @Override
        public MovieCollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_collection_row, parent, false);
            ViewHolder vh = new ViewHolder(v, recyclerViewClickListener);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText(parts.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return parts.size();
        }
    }

