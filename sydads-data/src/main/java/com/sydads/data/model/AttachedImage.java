package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */
@Entity
@Table(name = "AttachedImage")
public class AttachedImage extends Guid {

    private String fileName;
    private Long fileSize;

    private Advertisement advertisement;
    private News news;

    @Column(name = "FileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "FileSize")
    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AdvertisementId")
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NewsId")
    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
