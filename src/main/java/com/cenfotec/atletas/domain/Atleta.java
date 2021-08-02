package com.cenfotec.atletas.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombreCompleto;

    private String primerApellido;

    private String segundoApellido;

    private String fechaNacimiento;

    private String deporte;

    private double estatura;

    private double peso;

    private String ramaCompetitiva;

    private double imc;

    private String provincia;

    private String canton;

    private String distrito;

    private String telefono;

    private String correo;

    private String direccion;

    public Atleta() {
    }

    public Atleta(long id, String nombreCompleto, String primerApellido, String segundoApellido, String fechaNacimiento, String deporte, double estatura, double peso, String ramaCompetitiva, double imc, String provincia, String canton, String distrito, String telefono, String correo, String direccion) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.deporte = deporte;
        this.estatura = estatura;
        this.peso = peso;
        this.ramaCompetitiva = ramaCompetitiva;
        this.imc = imc;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        if(primerApellido == null){
            return  nombreCompleto;
        }else{
            return nombreCompleto+" "+primerApellido+" "+segundoApellido;
        }

    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRamaCompetitiva() {
        return ramaCompetitiva;
    }

    public void setRamaCompetitiva(String ramaCompetitiva) {
        this.ramaCompetitiva = ramaCompetitiva;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
