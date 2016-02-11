package me.declangao.wordpressreader.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

/**
 * Post object along with its properties, as well as their corresponding getter and setter methods
 */
@DatabaseTable(tableName = "post")
public class Post extends ormliteModel{

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String content;

    @DatabaseField
    private String thumbnailUrl;

    @DatabaseField
    private String featuredImageUrl = "";

    @DatabaseField
    private String viewCount;

    @DatabaseField
    private String date;

    @DatabaseField
    private String author;

    @DatabaseField
    private String url;

    @DatabaseField
    private int commentCount;


    public Post() {

    }

    /**
     * Override equals method to help Set decide if two posts are the same
     *
     * @param o Another object
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Post && this.getId() == (((Post) o).getId());
    }

    /**
     * Override hashCode method to help Set decide if two posts are the same
     */
    @Override
    public int hashCode() {
        //return this.getId();
        return Integer.valueOf(this.getId()).hashCode();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
