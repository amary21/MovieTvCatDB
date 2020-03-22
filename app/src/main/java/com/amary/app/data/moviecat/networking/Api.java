package com.amary.app.data.moviecat.networking;

import com.amary.app.data.moviecat.model.DisMovieResponse;
import com.amary.app.data.moviecat.model.DisTvResponse;
import com.amary.app.data.moviecat.model.DetailMovie;
import com.amary.app.data.moviecat.model.DetailTv;
import com.amary.app.data.moviecat.model.GetImageMovie;
import com.amary.app.data.moviecat.model.GetImageTv;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("discover/movie")
    Observable<DisMovieResponse> getDisMovie(@Query("api_key") String api_key,
                                                   @Query("language") String language);

    @GET("discover/tv")
    Observable<DisTvResponse> getDisTv(@Query("api_key") String api_key,
                                 @Query("language") String language);

    @GET("movie/{movie_id}")
    Observable<DetailMovie> getDetailMovie(@Path("movie_id") int movie_id,
                                           @Query("api_key") String api_key,
                                           @Query("language") String language);

    @GET("tv/{tv_id}")
    Observable<DetailTv> getDetailTv(@Path("tv_id") int tv_id,
                                     @Query("api_key") String api_key,
                                     @Query("language") String language);

    @GET("movie/{movie_id}/images")
    Observable<GetImageMovie> getImageMovie(@Path("movie_id") int movie_id,
                                            @Query("api_key") String api_key,
                                            @Query("language") String language,
                                            @Query("include_image_language") String include_image_language);

    @GET("tv/{tv_id}/images")
    Observable<GetImageTv> getImageTv(@Path("tv_id") int tv_id,
                                      @Query("api_key") String api_key,
                                      @Query("language") String language,
                                      @Query("include_image_language") String include_image_language);
}
