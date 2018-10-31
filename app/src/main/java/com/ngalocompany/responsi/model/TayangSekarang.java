package com.ngalocompany.responsi.model;

public class TayangSekarang {

    private String vote_count;
    private String id;
    private String title;
    private String vote_average;
    private String overview;
    private String poster_path;

    public TayangSekarang() {
    }

    public TayangSekarang(String vote_count, String id, String title, String vote_average, String overview, String poster_path) {
        this.vote_count = vote_count;
        this.id = id;
        this.title = title;
        this.vote_average = vote_average;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public String getVote_count() {
        return vote_count;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
