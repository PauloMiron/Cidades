package com.seniordesafio.Resource;

import com.seniordesafio.Dto.CidadeDto;
import com.seniordesafio.Services.CidadeService;
import com.seniordesafio.entities.Cidade;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {

    @Autowired
    CidadeService cidadeService;

    @GetMapping(value="{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Cidade obj = cidadeService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CidadeDto>> fildAll(){
        List<Cidade> list = cidadeService.findAll();
        List<CidadeDto> listDto = list.stream().map(obj -> new CidadeDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value="/capitais")
    public ResponseEntity<List<Cidade>> findByCapital() throws ObjectNotFoundException {
        List<Cidade> obj = cidadeService.findByCapital();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/cidadesPorUf")
    public ResponseEntity<List<Cidade>> find(@RequestParam(value="value") String uf) throws ObjectNotFoundException {
        List<Cidade> obj = cidadeService.findByUf(uf);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/buscaTotal")
    public ResponseEntity<String> buscaTotal() throws ObjectNotFoundException {
        String obj = cidadeService.buscaTotal();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/MaxAndMin")
    public ResponseEntity<List<String>> findByMaxAndMin() throws ObjectNotFoundException {
        List<String> obj = cidadeService.findByMaxAndMin();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/CidadesPorEstado")
    public ResponseEntity<List<String>> findCidadesByEstado() throws ObjectNotFoundException {
        List<String> obj = cidadeService.findCidadesByEstado();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/CidadesPorFiltro")
    public ResponseEntity<List<Cidade>> findByFilter(@RequestParam(value="coluna") String coluna,@RequestParam(value="value") String valor) throws ObjectNotFoundException {
        List<Cidade> obj = cidadeService.findByFilter(coluna, valor);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/RegistrosSemDuplicar")
    public ResponseEntity<String> quantidadeRegistro(@RequestParam(value="coluna") String coluna) throws ObjectNotFoundException {
        String obj = cidadeService.quantidadeRegistro(coluna);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/distancia")
    public ResponseEntity<String> distanciaMaior() throws ObjectNotFoundException {
        String obj = cidadeService.distanciaMaior();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Cidade> insert(@RequestBody Cidade cidade) {
        Cidade response = cidadeService.insert(cidade);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
