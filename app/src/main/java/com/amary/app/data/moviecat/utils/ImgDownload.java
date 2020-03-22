package com.amary.app.data.moviecat.utils;

import android.widget.ImageView;

import com.amary.app.data.moviecat.networking.ApiServer;
import com.squareup.picasso.Picasso;

public class ImgDownload {
    public static void imgPoster(String URL, ImageView IMG_PATH){
        Picasso.get().load(ApiServer.COVER_IMAGE + URL).into(IMG_PATH);
    }
}
