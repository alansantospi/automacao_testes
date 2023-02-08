package aula01.loja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LojaVirtualTest {
	
	@Test
	public void caso1_carrinhoVazio() {
		LojaVirtual loja = new LojaVirtual();
		Produto prod = loja.criarProduto();
		Carrinho car = loja.criarCarrinho();
	
		Assertions.assertTrue(car.isVazio());
		loja.adicionarAoCarrinho(prod);
		
		Assertions.assertTrue(car.contem(prod));
		Assertions.assertEquals(1, car.getQtde());
	}
	
	@Test
	public void caso1_carrinhoCheio() {
		Produto prod = new Produto(1, "mouse", 50D);
		
		Carrinho car = new Carrinho();
		car.adicionar(prod);
		Assertions.assertTrue(car.contem(prod));
	}

}
