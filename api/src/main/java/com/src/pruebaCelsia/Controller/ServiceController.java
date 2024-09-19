package com.src.pruebaCelsia.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.src.pruebaCelsia.Service.*;
import com.src.pruebaCelsia.Model.*;


@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private serviceServer serviceServe;

    @PostMapping("/create")
    public ResponseEntity<String> crearServicio(@Valid @RequestBody Services services) {
        serviceServe.saveService(services);
        return ResponseEntity.ok("El servicio fue registrado satisfactoriamente");
    }

    @GetMapping("/getclient/{identificacion}")
    public ResponseEntity<List<Services>> getServiceClient(@PathVariable String identificacion) {
        List<Services> servicios = serviceServe.getServiceClient(identificacion);
        return ResponseEntity.ok(servicios);
    }
    
}
