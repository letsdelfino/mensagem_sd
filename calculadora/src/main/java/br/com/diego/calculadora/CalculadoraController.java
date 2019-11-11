package br.com.diego.calculadora;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
	@RequestMapping("/")
	public String ola() {
		return "Ola, Bem vindo ao sistema de calculadora";
	}

	@RequestMapping("/adicao")
	public int adicao(int n1, int n2) {
		return n1 + n2;
	}
	@RequestMapping("/subtracao")
	public int subtracao(int n1, int n2) {
		return n1 - n2;
	}
	@RequestMapping("/divisao")
	public int divisao(int n1, int n2) {
		return n1 / n2;
	}
	@RequestMapping("/multiplicacao")
	public int multiplicacao(int n1, int n2) {
		return n1 * n2;
	}
}