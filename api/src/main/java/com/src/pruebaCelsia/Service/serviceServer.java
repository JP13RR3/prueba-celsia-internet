package com.src.pruebaCelsia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.src.pruebaCelsia.Exception.DuplicateException;
import com.src.pruebaCelsia.Exception.NotFoundException;
import com.src.pruebaCelsia.Model.Services;
import com.src.pruebaCelsia.Repository.ClientRepository;
import com.src.pruebaCelsia.Repository.serviceReporsitory;
import java.util.List;

@Service
public class serviceServer {
    @Autowired
    private serviceReporsitory serviceRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Services saveService (Services services) {
        if (serviceRepository.existsByIdentificationService(services.getIdentificacion(), services.getServicio())) {
            throw new DuplicateException("Ya existe un registro para ese ID", 409);
        }

        if(!clientRepository.existsByIdentificacion(services.getIdentificacion())) {
            throw new NotFoundException("No es posible asociar el servicio a un cliente que no existe");

        }
        return serviceRepository.save(services);
    }

    public List<Services> getServiceClient(String identificacion) {
        return serviceRepository.findByIdentificacion(identificacion);
    }
   
}

