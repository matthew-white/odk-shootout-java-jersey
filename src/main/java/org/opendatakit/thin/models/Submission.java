package org.opendatakit.thin.models;

import javax.persistence.*;

@Entity
@Table(name="submissions")
public class Submission {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String xml;

    public Submission() { }

    public Submission(String xml) {
        this.xml = xml;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
