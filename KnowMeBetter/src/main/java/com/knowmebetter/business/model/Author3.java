package com.knowmebetter.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Author3 extends PersistableElement{

    @Column(name = "name")
    private String name;

    public Author3() {
    }

    public Author3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
