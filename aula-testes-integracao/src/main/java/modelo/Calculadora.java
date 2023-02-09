package modelo;

import org.springframework.stereotype.Component;

import aulajunit.exceptions.DivisaoPorZeroException;

@Component
public class Calculadora {
	// atributo
	private int resultado = 0;
	
	public void setResultado(int i) {
		this.resultado = i;
	}

	// método somar
	public double somar(int n1, int n2) {
		resultado = n1 + n2;
		return Double.valueOf(resultado);
	}

	// método subtrair
	public double subtrair(int n1, int n2) {
		resultado = n1 - n2;
		return resultado;
	}

	// método multiplicar
	public double multiplicar(int n1, int n2) {
		resultado = n1 * n2;
		return resultado;
	}

	// método dividir
	public double dividir(int n1, int n2) {
		resultado = n1 / n2;
		return resultado;
	}
}
