package com.knowmebetter.business.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Jointure4 extends PersistableElement {

    @JoinColumn(name = "source", referencedColumnName = "id")
    private Long source;

    @JoinColumn(name = "target", referencedColumnName = "id")
    private Long target;

    public Jointure4() {
    }

    public Jointure4(Long source, Long target) {
        this.source = source;
        this.target = target;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }
}
