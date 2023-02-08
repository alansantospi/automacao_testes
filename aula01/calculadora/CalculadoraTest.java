package aula01.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	public void testeSoma_quandoXeYpositivos_entaoResultadoPositivo() {
		int x = 4;
		int y = 17;
		int soma = Calculadora.soma(x, y);
		
		assertEquals(5, soma);
	}
	
	@Test
	public void testeSoma_quandoXNegativoEMaiorQueY_entaoResultadoNegativo() {
		int x = -3;
		int y = 2;
		int soma = Calculadora.soma(x, y);
		
		assertEquals(-1, soma);
	}
	
	@Test
	public void testeSoma_quandoXNegativoEMenorQueY_entaoResultadoPositivo() {
		int x = -3;
		int y = 4;
		int soma = Calculadora.soma(x, y);
		
		assertEquals(1, soma);
	}
	
	@Test
	public void testeSoma_quandoXeYNegativos_entaoResultadoNegativo() {
		int x = -3;
		int y = -2;
		int soma = Calculadora.soma(x, y);
		
		assertEquals(-5, soma);
	}

	@Test
	public void testeSoma_quandoXNegativoIguaisAZero_entaoResultadoZero() {
		int x = 0;
		int y = 0;
		int soma = Calculadora.soma(x, y);
		
		assertEquals(0, soma);
	}
	
	@Test
	public void testeDivide_quandoDivisorEhZero() {
		int a = 3;
		int b = 0;
		
		Exception e = assertThrows(ArithmeticException.class, () -> {
			Calculadora.divide(a, b);
	    });
		String msgEsperada = "/ by zero";
		assertEquals(msgEsperada, e.getMessage());
	}
}
