package com.knowmebetter.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Friend extends PersistableElement{

    @Column(name = "twitteraccount")
    private String twitteraccount;

    public Friend() {
    }

    public Friend(String twitteraccount) {
        this.twitteraccount = twitteraccount;
    }

    public String getTwitteraccount() {
        return twitteraccount;
    }

    public void setTwitteraccount(String twitteraccount) {
        this.twitteraccount = twitteraccount;
    }
}
