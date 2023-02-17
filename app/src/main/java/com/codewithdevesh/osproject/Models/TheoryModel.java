package com.codewithdevesh.osproject.Models;

public class TheoryModel {
    String source;
    String link;
    String topic;
    String logo;


    public TheoryModel(String source, String link, String topic,String logo) {
        this.source = source;
        this.link = link;
        this.topic = topic;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
