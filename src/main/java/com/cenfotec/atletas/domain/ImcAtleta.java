package com.cenfotec.atletas.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ImcAtleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Imc;

    private long idAtleta;

    private String fechaCalculo;

    public ImcAtleta(){

    }

    public ImcAtleta(String imc, long idAtleta, String fechaCalculo) {
        Imc = imc;
        this.idAtleta = idAtleta;
        this.fechaCalculo = fechaCalculo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImc() {
        return Imc;
    }

    public void setImc(String imc) {
        Imc = imc;
    }

    public long getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(long idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(String fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }
}
