package cz.spsmb.view;


import cz.spsmb.dao.BusRepository;

import cz.spsmb.dto.BusDTO;
import cz.spsmb.model.Bus;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.List;

@Named
@RequestScoped
public class BusView {

    @Inject
    BusRepository busRepository;

    BusDTO newBus = new BusDTO();

    List<Bus> busList;
    String model;
    int age;

    @PostConstruct
    public void init() {
        busList = busRepository.listAll();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BusDTO getNewBus() {
        return newBus;
    }

    public void setNewBus(BusDTO newBus) {
        this.newBus = newBus;
    }

    @Transactional
    public void saveBus() {
        Bus bus = new Bus(newBus.getModel(), newBus.getAge());
        busRepository.persist(bus);
        busList.add(bus);
        System.out.println("Saved " + bus);


    }


}
