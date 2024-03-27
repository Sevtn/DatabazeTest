package cz.spsmb.rest;


import cz.spsmb.dao.BusRepository;
import cz.spsmb.dto.BusDTO;
import cz.spsmb.model.Bus;
import cz.spsmb.model.Linka;
import cz.spsmb.model.Person;
import jakarta.inject.Inject;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import cz.spsmb.dao.PersonRepository;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("/buses")
public class BusResource {
    @Inject
    BusRepository busRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list(){
        List<Bus> buses = busRepository.listAll();
        return Response.ok().entity(buses).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Bus bus = busRepository.findById(id);
        return Response.ok().entity(bus).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        busRepository.deleteById(id);
        return Response.ok().entity("ok").build();



}

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(BusDTO busDTO) {
        if (busDTO.getModel() != null && busDTO.getAge() > 0) {
        Bus bus = new Bus();
        bus.setModel(busDTO.getModel());
        bus.setAge(busDTO.getAge());
        for (String linka: busDTO.getLinka()){
            Linka l = new Linka(linka);
            l.setBus(bus);
            bus.getLinks().add(l);
        }
            busRepository.persist(bus);
            return Response.ok().entity("ok").build();
        } else {
            return Response.status(400).entity("Bus must have attributes \"model\" and \"age\".").build();
        }

    }


}