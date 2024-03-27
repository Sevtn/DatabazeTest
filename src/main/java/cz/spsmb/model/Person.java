package cz.spsmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "driver-table")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String driver;
    int age;

    public Person(){};

    public Person(String name, Integer age){
        this.driver = driver;
        this.age = age;
    }

    public Person(String driver, Integer age, List<String> linka) {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", driver='" + driver + '\'' +
                ", age=" + age +
                ", bus=" + bus +
                '}';
    }

    @OneToOne(fetch = FetchType.LAZY)
    Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
