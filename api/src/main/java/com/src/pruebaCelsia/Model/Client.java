package com.src.pruebaCelsia.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import java.util.*;

@Entity
@Table(name = "clientes")
public class Client {
    @Id
    @Column(name = "identificacion", length = 20)
    private String identificacion;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name = "numeroCelular")
    private String numeroCelular;
    @Column(name = "correoElectronico")
    private String correoElectronico;

   public String getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    // setters
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

     @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Services> servicios;
}
