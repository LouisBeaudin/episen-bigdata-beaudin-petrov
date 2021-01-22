package com.knowmebetter.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Author5 extends PersistableElement{

    @Column(name = "name")
    private String name;

    public Author5() {
    }

    public Author5(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
