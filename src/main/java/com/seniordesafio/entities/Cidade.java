package com.seniordesafio.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ibgeId;
    private String uf;
    private String name;
    private String capital;
    private String longit;
    private String lati;
    private String noAccentes;
    private String alternativeNames;
    private String microregion;
    private String mesoregion;

    public Cidade(Long ibgeId) {
    }

    public Cidade(Long ibgeId, String uf, String name, String capital, String longit, String lati, String noAccentes, String alternativeNames, String microregion, String mesoregion) {
        this.ibgeId = ibgeId;
        this.uf = uf;
        this.name = name;
        this.capital = capital;
        this.longit = longit;
        this.lati = lati;
        this.noAccentes = noAccentes;
        this.alternativeNames = alternativeNames;
        this.microregion = microregion;
        this.mesoregion = mesoregion;
    }

    public Cidade() {

    }

    public Long getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(Long ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNoAccentes() {
        return noAccentes;
    }

    public void setNoAccentes(String noAccentes) {
        this.noAccentes = noAccentes;
    }

    public String getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(String alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }

    public String getLongit() {
        return longit;
    }

    public void setLongit(String longit) {
        this.longit = longit;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }
}
