package com.seniordesafio.Services;

import com.seniordesafio.Dto.CidadeDto;
import com.seniordesafio.entities.Cidade;
import com.seniordesafio.repository.CidadeRepository;
import com.seniordesafio.repository.CidadeCustomRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    @Autowired
    private CidadeCustomRepository repoCustom;


    public Cidade find(Long id) throws ObjectNotFoundException {
        Optional<Cidade> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
    }

    public List<Cidade> findByCapital() throws ObjectNotFoundException {
        List<Cidade> obj = repo.findAllCapital();
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado!"+ Cidade.class.getName());
        }
        return obj;
    }

    public List<Cidade> findByUf(String uf) throws ObjectNotFoundException {
        List<Cidade> obj = repo.findByuf(uf);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + ", Tipo: " + Cidade.class.getName());
        }
        return obj;
    }

    public List<String> findByMaxAndMin() throws ObjectNotFoundException {
        List<String> obj = repo.findMaxAndMin();
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado!"+ Cidade.class.getName());
        }
        return obj;
    }

    public List<String> findCidadesByEstado() throws ObjectNotFoundException {
        List<String> obj = repo.findCidadesByEstado();
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado!"+ Cidade.class.getName());
        }
        return obj;
    }

    public List<Cidade> findAll(){
        return repo.findAll();
    }

    public List<Cidade> findByFilter(String coluna, String valor)  throws ObjectNotFoundException {
        List<Cidade> obj = repoCustom.findCidadesByFilter(coluna, valor);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + ", Tipo: " + Cidade.class.getName());
        }
        return obj;
    }

    public String quantidadeRegistro(String coluna)  throws ObjectNotFoundException {
        String obj = repoCustom.findRegistrosSemDuplicar(coluna);
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + ", Tipo: " + Cidade.class.getName());
        }
        return obj;
    }

    public String distanciaMaior()  throws ObjectNotFoundException {
        String obj = repoCustom.findDistance();
        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + ", Tipo: " + Cidade.class.getName());
        }
        return obj;
    }

    public String buscaTotal(){
        String obj =
        repo.buscaTotal();

        return obj;
    }

    public void insertInicial(){
        DbServices dbServices = new DbServices();
        for (Cidade c: dbServices.retornaCidades()) {
            repo.save(c);
        }
    }

    public Cidade insert(Cidade objeto){
        repo.save(objeto);
        return objeto;
    }

    public void delete(Long id) throws ObjectNotFoundException {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName());
        }
    }

    public Cidade fromDTO(CidadeDto objDto){
        return new Cidade(objDto.getIbgeId(),objDto.getUf(),objDto.getName(),objDto.getCapital(),objDto.getLongit(),objDto.getLati(),objDto.getNoAccentes(),objDto.getAlternativeNames(),objDto.getMicroregion(),objDto.getMesoregion());
    }

}
