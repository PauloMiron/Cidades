package com.seniordesafio.repository;

import com.seniordesafio.Haversien;
import com.seniordesafio.entities.Cidade;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CidadeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cidade> findCidadesByFilter(String coluna, String valor) {
        coluna = coluna.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Cidade c where c.").append(coluna).append(" LIKE '%").append(valor).append("%'");
        String query = sb.toString();
        List<Cidade> listCidade = entityManager.createQuery(query, Cidade.class).getResultList();
        return listCidade;
    }

    public String findRegistrosSemDuplicar(String coluna) {
        coluna = coluna.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(distinct c.").append(coluna).append(")").append("from Cidade c");
        String query = sb.toString();
        String quantidadeRegistros = entityManager.createQuery(query).getResultList().toString();
        return quantidadeRegistros;
    }

    public String findDistance(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Cidade c");
        String query = sb.toString();
        List<Cidade> listCidade = entityManager.createQuery(query, Cidade.class).getResultList();
        Double distanciaMaior = 0.0;
        String localDistanciaMaior = "";
        for(Cidade c : listCidade){
            Long codIbge = c.getIbgeId();
            for (Cidade ce : listCidade){
                if(codIbge != ce.getIbgeId()){
                    Haversien haversien = new Haversien();
                    double distanceHaversien = haversien.distance(Double.parseDouble(ce.getLati()),Double.parseDouble(ce.getLongit())
                            ,Double.parseDouble(c.getLati()),Double.parseDouble(c.getLongit()));

                    if(distanceHaversien > distanciaMaior){
                        distanciaMaior = distanceHaversien;
                        localDistanciaMaior = "A distancia maior é entre: "+ ce.getName()+ " e " +c.getName();
                    }
                }
            }
        }
        return localDistanciaMaior;

    }

}
