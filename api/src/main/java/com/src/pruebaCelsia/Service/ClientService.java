package com.src.pruebaCelsia.Service;

import com.src.pruebaCelsia.Model.*;
import com.src.pruebaCelsia.Exception.NotFoundException;
import com.src.pruebaCelsia.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClient(String identificacion) {
        return clientRepository.findById(identificacion).orElseThrow();
    }

    public Client updateClient(String identificacion, Client client) {
        Client clientCurrent = getClient(identificacion);
        clientCurrent.setNombres(client.getNombres());
        clientCurrent.setApellidos(client.getApellidos());
        clientCurrent.setTipoIdentificacion(client.getTipoIdentificacion());
        clientCurrent.setFechaNacimiento(client.getFechaNacimiento());
        clientCurrent.setNumeroCelular(client.getNumeroCelular());
        clientCurrent.setCorreoElectronico(client.getCorreoElectronico());
        return clientRepository.save(clientCurrent);
    }

    public void deleteClient(String identificacion) {
        Client clientDelete =  clientRepository.findById(identificacion)
          .orElseThrow(() -> new NotFoundException("El cliente no se encuentra registrado"));
          clientRepository.delete(clientDelete);
    }
}