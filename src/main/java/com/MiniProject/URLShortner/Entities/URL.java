package com.MiniProject.URLShortner.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Uniform_Resource_Locator")
public class URL {
    @Id
    @Column(name="id" ,nullable = false ,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name="count")
    private int count;
    @Column(name="user")
    private String user;
    @Column(name="longUrl")
    private String longurl;
    @Column(name="shortenurl")
    private String shortenUrl;

    @Column(name="shortcode")
    private String ShortCode;

    public String getShortCode() {
        return ShortCode;
    }

    public void setShortCode(String shortCode) {
        ShortCode = shortCode;
    }

    @Column(name="create_ts")
    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLongurl() {
        return longurl;
    }

    public void setLongurl(String longurl) {
        this.longurl = longurl;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    public URL(int count, String user, String longurl, String shortenUrl, String shortCode, Date date) {
        this.count = count;
        this.user = user;
        this.longurl = longurl;
        this.shortenUrl = shortenUrl;
        this.date=date;
        ShortCode=shortCode;
    }

    public URL(){

    }

    public URL(int id, int count, String user, String longurl, String shortenUrl, String shortCode, Date date) {
        this.id = id;
        this.count = count;
        this.user = user;
        this.longurl = longurl;
        this.shortenUrl = shortenUrl;
        ShortCode = shortCode;
        this.date = date;
    }
}
