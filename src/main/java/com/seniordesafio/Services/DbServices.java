package com.seniordesafio.Services;

import com.seniordesafio.entities.Cidade;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DbServices {

    @Autowired
    CidadeService cidadesService;


    public ArrayList<Cidade> retornaCidades(){

            String path = "D:\\Senior Sistemas\\BaseDados\\cidades.csv";

            List<Cidade> list = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String line = br.readLine();
                line = br.readLine();
                while (line != null) {

                    String[] vect = line.split(",");
                    Long id = Long.parseLong(vect[0]);
                    String uf =vect[1];
                    String name = vect[2];
                    String capital = vect[3];
                    String longit = vect[4];
                    String latit = vect[5];
                    String noAccentes = vect[6];
                    String alternativeNames = vect[7];
                    String microregion = vect[8];
                    String mesoregion = vect[9];

                    Cidade cidades = new Cidade(id,uf,name,capital,longit,latit,noAccentes,alternativeNames,microregion,mesoregion);
                    list.add(cidades);
                    line = br.readLine();
                }

            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            return (ArrayList<Cidade>) list;




    }
}
