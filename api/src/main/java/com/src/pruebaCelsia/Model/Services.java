package com.src.pruebaCelsia.Model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.IdClass;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "servicios")
@IdClass(ServiceIdClass.class)

public class Services {
    @Id
    @Size(max = 20)
    @Column(name = "identificacion", length = 20)
    private String identificacion;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Column(name = "ultimaFacturacion")
    private Date ultimaFacturacion;
    @Column(name = "ultimoPago")
    private Date ultimoPago;

    public String getIdentificacion() {
        return identificacion;
    }

    public String getServicio() {
        return servicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getUltimaFacturacion() {
        return ultimaFacturacion;
    }

    public Date getUltimoPago() {
        return ultimoPago;
    }

    // setters
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setUltimaFacturacion(Date ultimaFacturacion) {
        this.ultimaFacturacion = ultimaFacturacion;
    }

    public void setUltimoPago(Date ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    @ManyToOne
    @JoinColumn(name = "identificacion", insertable = false, updatable = false)
    @JsonIgnore
    private Client client;
}
