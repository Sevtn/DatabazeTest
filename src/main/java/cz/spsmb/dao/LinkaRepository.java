package cz.spsmb.dao;

import cz.spsmb.model.Linka;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.Optional;

@ApplicationScoped
public class LinkaRepository implements PanacheRepository<Linka> {

    public Optional<Linka> listByname(String name){
        return find("name", name).singleResultOptional();
    }
}
