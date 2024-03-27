package cz.spsmb.dto;

import java.util.List;

public class BusDTO {
  String model;
  Integer age;
  List<String> linka;
  String driver;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getLinka() {
        return linka;
    }

    public void setLinka(List<String> linka) {
        this.linka = linka;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "BusDTO{" +
                "model='" + model + '\'' +
                ", age=" + age +
                ", linka=" + linka +
                ", driver='" + driver + '\'' +
                '}';
    }
}
