package com.amary.app.data.moviecat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieCatData implements Parcelable {
    private int poster;
    private int screen1;
    private int screen2;
    private int screen3;
    private int screen4;
    private int screen5;
    private String judul;
    private String thnRilis;
    private String durasiMovie;
    private String genreMovie;
    private String tglRilis;
    private String directors;
    private String actors;
    private String sinopsis;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getScreen1() {
        return screen1;
    }

    public void setScreen1(int screen1) {
        this.screen1 = screen1;
    }

    public int getScreen2() {
        return screen2;
    }

    public void setScreen2(int screen2) {
        this.screen2 = screen2;
    }

    public int getScreen3() {
        return screen3;
    }

    public void setScreen3(int screen3) {
        this.screen3 = screen3;
    }

    public int getScreen4() {
        return screen4;
    }

    public void setScreen4(int screen4) {
        this.screen4 = screen4;
    }

    public int getScreen5() {
        return screen5;
    }

    public void setScreen5(int screen5) {
        this.screen5 = screen5;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getThnRilis() {
        return thnRilis;
    }

    public void setThnRilis(String thnRilis) {
        this.thnRilis = thnRilis;
    }

    public String getDurasiMovie() {
        return durasiMovie;
    }

    public void setDurasiMovie(String durasiMovie) {
        this.durasiMovie = durasiMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public String getTglRilis() {
        return tglRilis;
    }

    public void setTglRilis(String tglRilis) {
        this.tglRilis = tglRilis;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeInt(this.screen1);
        dest.writeInt(this.screen2);
        dest.writeInt(this.screen3);
        dest.writeInt(this.screen4);
        dest.writeInt(this.screen5);
        dest.writeString(this.judul);
        dest.writeString(this.thnRilis);
        dest.writeString(this.durasiMovie);
        dest.writeString(this.genreMovie);
        dest.writeString(this.tglRilis);
        dest.writeString(this.directors);
        dest.writeString(this.actors);
        dest.writeString(this.sinopsis);
    }

    public MovieCatData() {
    }

    protected MovieCatData(Parcel in) {
        this.poster = in.readInt();
        this.screen1 = in.readInt();
        this.screen2 = in.readInt();
        this.screen3 = in.readInt();
        this.screen4 = in.readInt();
        this.screen5 = in.readInt();
        this.judul = in.readString();
        this.thnRilis = in.readString();
        this.durasiMovie = in.readString();
        this.genreMovie = in.readString();
        this.tglRilis = in.readString();
        this.directors = in.readString();
        this.actors = in.readString();
        this.sinopsis = in.readString();
    }

    public static final Parcelable.Creator<MovieCatData> CREATOR = new Parcelable.Creator<MovieCatData>() {
        @Override
        public MovieCatData createFromParcel(Parcel source) {
            return new MovieCatData(source);
        }

        @Override
        public MovieCatData[] newArray(int size) {
            return new MovieCatData[size];
        }
    };
}
