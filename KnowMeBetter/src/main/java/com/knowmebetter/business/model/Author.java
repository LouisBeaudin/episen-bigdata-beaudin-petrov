package com.knowmebetter.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Author extends PersistableElement{

    @Column(name = "name")
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
