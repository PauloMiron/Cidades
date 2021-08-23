package com.seniordesafio.repository;

import com.seniordesafio.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {


    @Query(value = "SELECT * FROM CIDADE WHERE CIDADE.CAPITAL = 'true' ORDER BY NAME", nativeQuery = true)
    List<Cidade> findAllCapital();

    @Query(value = "SELECT A.UF, A.QUANTIDADE FROM \n" +
            "  (SELECT UF,COUNT(NAME) AS QUANTIDADE FROM CIDADE GROUP BY UF) A \n" +
            "WHERE(( A.QUANTIDADE = \n" +
            "  (SELECT MAX(QUANTIDADE) FROM (SELECT UF,COUNT(NAME) AS QUANTIDADE FROM CIDADE GROUP BY UF)))\n" +
            "OR ( A.QUANTIDADE = \n" +
            "  (SELECT MIN(QUANTIDADE) FROM (SELECT UF,COUNT(NAME) AS QUANTIDADE FROM CIDADE GROUP BY UF))))",nativeQuery = true)
     List<String> findMaxAndMin();

    @Query(value = "SELECT A.UF, A.QUANTIDADE FROM \n" +
            "  (SELECT UF,COUNT(NAME) AS QUANTIDADE FROM CIDADE GROUP BY UF) A",nativeQuery = true)
    List<String> findCidadesByEstado();

    List<Cidade> findByuf(String uf);

    @Query(value = "SELECT * FROM CIDADE WHERE :coluna LIKE %:valor%",nativeQuery = true)
    List<Cidade> findPorFiltro(@Param("coluna") String coluna, @Param("valor") String valor);

    @Query(value = "SELECT COUNT(*) FROM CIDADE",nativeQuery = true)
    String buscaTotal();

}
