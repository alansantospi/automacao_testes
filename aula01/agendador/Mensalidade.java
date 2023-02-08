package aula01.agendador;

import java.time.LocalDate;

public class Mensalidade {

	private LocalDate vencimento;
	private String situacao;
	
	public LocalDate getDataVencimento() {
		return vencimento;
	}

	public String getSituacao() {
		return this.situacao;
	}
	
	public static boolean meuMetodo() {
		return false;
	}

}
