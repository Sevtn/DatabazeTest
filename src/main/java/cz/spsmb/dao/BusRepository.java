package cz.spsmb.dao;


import cz.spsmb.model.Bus;
import cz.spsmb.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BusRepository implements PanacheRepository<Bus> {

    public List<Bus> listByName(String model) {


        return find("model", model).list();
    }

    public Bus listById(Long id){
        return findById(id);
    }

}