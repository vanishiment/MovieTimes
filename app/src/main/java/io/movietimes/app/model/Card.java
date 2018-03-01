package io.movietimes.app.model;


import java.util.List;

public class Card {

    private String img;

    private String title;

    private int rate;

    private String tagLine;

    private String desc;

    private List<String> photoList;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                ", tagLine='" + tagLine + '\'' +
                ", desc='" + desc + '\'' +
                ", photoList=" + photoList +
                '}';
    }
}
