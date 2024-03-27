package cz.spsmb.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "linka")
public class Linka implements Serializable {
    @Id
    @Column(name = "linka")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    Bus bus;

    public Linka(String name) {
        this.name = name;
    }
    public Linka(){}

    @Override
    public String toString() {
        return "Linka{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bus=" + bus +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }





}

