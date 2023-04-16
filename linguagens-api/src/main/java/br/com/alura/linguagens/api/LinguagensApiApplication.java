package br.com.alura.linguagens.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class LinguagensApiApplication {

	public static void main(String[] args) {
		var lc = new LinguagemController();
		SpringApplication.run(LinguagensApiApplication.class, args);
		Scanner call = new Scanner(System.in);
		if(Objects.equals(call.nextLine(), "4")) {
			System.out.println(lc.obterLinguagens());
		}
	}
}
