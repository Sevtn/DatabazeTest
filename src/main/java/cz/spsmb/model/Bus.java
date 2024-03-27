package cz.spsmb.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test-bus-table")
public class Bus implements Serializable {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "bus_id")
    long id;
String model;
int age;


    @OneToMany(mappedBy = "bus" , cascade = CascadeType.ALL )
    List<Linka> links = new ArrayList<>();
public Bus(){};




public Bus(String model, Integer age) {
    this.model = model;
    this.age = age;


}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Linka> getLinks() {
        return links;
    }

    public void setLinks(List<Linka> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", age=" + age +
                '}';
    }


}
