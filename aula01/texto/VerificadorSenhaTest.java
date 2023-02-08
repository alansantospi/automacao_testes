package aula01.texto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class VerificadorSenhaTest {
	
	/*
	 * Minimo 5 caracteres
	 */
	@ParameterizedTest
	@CsvSource({
			"216, true, Deveria ser true",
			"123absasas, false, Deveria ser false",
	})
	void testIsValida(String senha, boolean esperado, String msg) {
		VerificadorSenha verificador = new VerificadorSenha();
		boolean valida = verificador.isValida(senha);
		
		assertEquals(esperado, valida, msg);
	}
	
}
