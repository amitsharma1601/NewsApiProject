package com.example.getnews;

import java.util.ArrayList;

public class RecyclerModel {
   public ArrayList<Article> articles;
}

class Article{
    public String author;
    public String content;
    public String title;
    public String urlToImage;
    public String thumbnail;
    public String urlToArticle;

    public Article(String author, String content, String title, String urlToImage,String thumbnail, String urlToArticle) {
        this.author = author;
        this.content = content;
        this.title = title;
        this.urlToImage = urlToImage;
        this.thumbnail = thumbnail;
        this.urlToArticle = urlToArticle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getThumbnail() {
        return author;
    }

    public void setThumbnailr(String author) {
        this.author = author;
    }

    public String getUrlToArticle() {
        return urlToArticle;
    }

    public void setUrlToArticle(String urlToArticle) {
        this.urlToArticle = urlToArticle;
    }
}
