package rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
class CalculadoraRestTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testSomar_numerosPositivos() throws Exception {
		
		String n1 = "1";
		String n2 = "2";
		String retorno = "3.0";
		
		String path = "/calculadora/somar";
		mockMvc.perform(MockMvcRequestBuilders.get(path)
                .contentType(MediaType.APPLICATION_JSON)
                .param("n1", n1)
                .param("n2", n2)
		).andDo(print())
 		.andExpect(content().contentType("application/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.primeiroNumero").value(n1))
        .andExpect(jsonPath("$.segundoNumero").value(n2))
        .andExpect(jsonPath("$.resultados[0]").value("3.0"))
        .andExpect(jsonPath("$.resultados[1]").value("5.0"))
        .andExpect(jsonPath("$.resultados[2]").value("67.0"))
        ;
		
	}
	
	@Test
	void testSomar_whenAnyNegativeNumber_thenShouldReturn_error() throws Exception {
		
		String n1 = "-1";
		String n2 = "2";
		
		String path = "/calculadora/somar";
		mockMvc.perform(MockMvcRequestBuilders.get(path)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("n1", n1)
                .param("n2", n2)
		).andDo(print())
 		.andExpect(content().contentType("text/plain;charset=UTF-8"))
        .andExpect(status().is(400))
        .andExpect(content().string("número inválido"))
        ;
		
	}

}
