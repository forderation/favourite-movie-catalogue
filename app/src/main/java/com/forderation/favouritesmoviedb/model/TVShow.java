package com.forderation.favouritesmoviedb.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.forderation.favouritesmoviedb.DatabaseContract;

import org.json.JSONObject;

import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.backdrop_path;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.first_air_date;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.idJSON;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.original_language;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.original_name;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.poster_path;
import static com.forderation.favouritesmoviedb.DatabaseContract.TVShowColumns.vote_average;

public class TVShow implements Parcelable {
    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
    private long id;
    private String name, voteAverage, backdropPath, posterPath, overview, originalLanguage, originalName, firstAirDate;

    public TVShow(JSONObject object) {
        try {
            setId(object.getLong("id"));
            setBackdropPath(object.getString("backdrop_path"));
            setFirstAirDate(object.getString("first_air_date"));
            setName(object.getString("name"));
            setOriginalLanguage(object.getString("original_language"));
            setOriginalName(object.getString("original_name"));
            setOverview(object.getString("overview"));
            setVoteAverage(object.getString("vote_average"));
            setPosterPath(object.getString("poster_path"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected TVShow(Parcel in) {
        id = in.readLong();
        name = in.readString();
        voteAverage = in.readString();
        backdropPath = in.readString();
        posterPath = in.readString();
        overview = in.readString();
        originalLanguage = in.readString();
        originalName = in.readString();
        firstAirDate = in.readString();
    }

    public TVShow(Cursor cursor) {
        setId(cursor.getLong(cursor.getColumnIndexOrThrow(idJSON)));
        setBackdropPath(cursor.getString(cursor.getColumnIndexOrThrow(backdrop_path)));
        setFirstAirDate(cursor.getString(cursor.getColumnIndexOrThrow(first_air_date)));
        setName(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TVShowColumns.name)));
        setOriginalLanguage(cursor.getString(cursor.getColumnIndexOrThrow(original_language)));
        setOriginalName(cursor.getString(cursor.getColumnIndexOrThrow(original_name)));
        setVoteAverage(cursor.getString(cursor.getColumnIndexOrThrow(vote_average)));
        setPosterPath(cursor.getString(cursor.getColumnIndexOrThrow(poster_path)));
        setOverview(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TVShowColumns.overview)));
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(voteAverage);
        dest.writeString(backdropPath);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeString(originalLanguage);
        dest.writeString(originalName);
        dest.writeString(firstAirDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

}
