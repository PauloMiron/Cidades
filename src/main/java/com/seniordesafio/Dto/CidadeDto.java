package com.seniordesafio.Dto;

import com.seniordesafio.entities.Cidade;

import java.io.Serializable;

public class CidadeDto implements Serializable {

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

    public CidadeDto(Cidade cidade) {
        this.ibgeId = cidade.getIbgeId();
        this.uf = cidade.getUf();
        this.name = cidade.getName();
        this.capital = cidade.getCapital();
        this.longit = cidade.getLongit();
        this.lati = cidade.getLati();
        this.noAccentes = cidade.getNoAccentes();
        this.alternativeNames = cidade.getAlternativeNames();
        this.microregion = cidade.getMicroregion();
        this.mesoregion = cidade.getMesoregion();


    }
}
