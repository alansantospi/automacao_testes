package aula01.agendador;

import java.time.LocalDate;
import java.util.List;

public class Paciente {
	
	private List<Mensalidade> mensalidades;

	public boolean isEmDias() {
		
		for (Mensalidade m : mensalidades) {
			if (m.getSituacao().equals("Em aberto") && m.getDataVencimento().isBefore(LocalDate.now())) {
				return false;
			}
		}
		return true;
	}
}
