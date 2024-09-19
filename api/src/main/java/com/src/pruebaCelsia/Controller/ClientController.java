package com.src.pruebaCelsia.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.src.pruebaCelsia.Exception.DuplicateException;
import com.src.pruebaCelsia.Model.*;
import com.src.pruebaCelsia.Service.*;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService ClientService;

    @PostMapping("/create")
    public ResponseEntity<String> createClient(@Valid @RequestBody Client client) {
        try {
            ClientService.createClient(client);
            return ResponseEntity.ok("Cliente registrado correctamente");
        } catch (DuplicateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/consult/{identificacion}")
    public ResponseEntity<Client> getClient(@PathVariable String identificacion) {
       
            Client client = ClientService.getClient(identificacion);
            return ResponseEntity.ok(client);
    }
   

   /*  @PutMapping("/update/{identificacion}")
    public ResponseEntity<Client> updateClient(@PathVariable String identificacion, @RequestBody Client client) {
        try {
            ClientService.updateClient(identificacion, client);
            return ResponseEntity.ok("Cliente Actualizado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }*/

    @DeleteMapping("/delete/{identificacion}")
    public void deleteClient(@PathVariable String identificacion) {
       
            ClientService.deleteClient(identificacion);
            
       
    }
}