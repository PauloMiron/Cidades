package com.seniordesafio;

import com.seniordesafio.Services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;

@EnableScheduling
@SpringBootApplication
public class SeniorDesafioApplication {

	@Autowired
	private CidadeService cidadesService;

	public static void main(String[] args) throws ParseException { SpringApplication.run(SeniorDesafioApplication.class, args); }

	@Scheduled(fixedDelay = 1000000000, initialDelay = 1000)
	public void algumacoisa(){
			cidadesService.insertInicial();
		System.out.println("____________________________________________");
		}
	}




