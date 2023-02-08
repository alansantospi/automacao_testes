package aula01.texto;

public class VerificadorSenha {

	public boolean isValida(String senha){
		
		return senha.length() >= 5;
	}
}
