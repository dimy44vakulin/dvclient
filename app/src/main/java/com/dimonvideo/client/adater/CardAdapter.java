package com.dimonvideo.client.adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dimonvideo.client.AllContent;
import com.dimonvideo.client.Config;
import com.dimonvideo.client.util.CustomVolleyRequest;
import com.dimonvideo.client.R;
import com.dimonvideo.client.model.Feed;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    //Imageloader to load image
    private ImageLoader imageLoader;
    private Context context;

    //List to store all
    List<Feed> jsonFeed;

    //Constructor of this class
    public CardAdapter(List<Feed> jsonFeed, Context context){
        super();
        //Getting all feed
        this.jsonFeed = jsonFeed;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //Getting the particular item from the list
        final Feed Feed =  jsonFeed.get(position);

        //Loading image from url
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(Feed.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.drawable.ic_menu_gallery, android.R.drawable.ic_dialog_alert));

        holder.imageView.setImageUrl(Feed.getImageUrl(), imageLoader);
        holder.textViewTitle.setText(Feed.getTitle());
        holder.textViewText.setText(Feed.getText());
        holder.textViewDate.setText(Feed.getDate());
        holder.textViewCategory.setText(Feed.getCategory());
        holder.textViewComments.setText(String.valueOf(Feed.getComments()));
        holder.textViewComments.setVisibility(View.VISIBLE);
        holder.rating_logo.setVisibility(View.VISIBLE);
        if (Feed.getComments() == 0) {
            holder.textViewComments.setVisibility(View.INVISIBLE);
            holder.rating_logo.setVisibility(View.INVISIBLE);
        }
        holder.textViewHits.setText(String.valueOf(Feed.getHits()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AllContent.class);
                intent.putExtra(Config.TAG_TITLE, Feed.getTitle());
                intent.putExtra(Config.TAG_ID, String.valueOf(Feed.getId()));
                intent.putExtra(Config.TAG_DATE,Feed.getDate());
                intent.putExtra(Config.TAG_HEADERS,Feed.getHeaders());
                intent.putExtra(Config.TAG_IMAGE_URL, Feed.getImageUrl());
                intent.putExtra(Config.TAG_CATEGORY, Feed.getCategory());
                intent.putExtra(Config.TAG_RAZDEL, Feed.getRazdel());
                intent.putExtra(Config.TAG_USER, Feed.getUser());
                intent.putExtra(Config.TAG_SIZE, Feed.getSize());
                intent.putExtra(Config.TAG_LINK, Feed.getLink());
                intent.putExtra(Config.TAG_MOD, Feed.getMod());
                intent.putExtra(Config.TAG_HITS, String.valueOf(Feed.getHits()));
                intent.putExtra(Config.TAG_COMMENTS, String.valueOf(Feed.getComments()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jsonFeed.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        //Views
        public NetworkImageView imageView;
        public TextView textViewTitle, textViewText, textViewDate, textViewComments, textViewCategory, textViewHits;
        public ImageView rating_logo;

        //Initializing Views
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.thumbnail);
            rating_logo = (ImageView) itemView.findViewById(R.id.rating_logo);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewText = (TextView) itemView.findViewById(R.id.listtext);
            textViewDate = (TextView) itemView.findViewById(R.id.date);
            textViewComments = (TextView) itemView.findViewById(R.id.rating);
            textViewCategory = (TextView) itemView.findViewById(R.id.category);
            textViewHits = (TextView) itemView.findViewById(R.id.views_count);

        }

    }
}
