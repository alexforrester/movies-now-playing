package com.digian.movies.screens.grid;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.digian.movies.model.MovieGridImage;

import java.util.List;

/**
 * Created by alexforrester on 17/09/2017.
 */

public class MoviesImageAdapter extends BaseAdapter {

    @VisibleForTesting
    Context context;

    @VisibleForTesting
    List<MovieGridImage> movieGridImages;

    public MoviesImageAdapter(Context context, List<MovieGridImage> movieGridImages) {

        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }

        if (movieGridImages == null) {
            throw new NullPointerException("List<MovieGridImage> cannot be null");
        }

        this.context = context;
        this.movieGridImages = movieGridImages;
    }

    public int getCount() {
        return movieGridImages.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(context).load(movieGridImages.get(position).getImageUrl()).into(imageView);

        return imageView;
    }

}
