package aula01.agendador;

import java.time.LocalDateTime;
import java.util.Map;

public class Agenda {

	private Medico medico;
	
	private Map<LocalDateTime, Consulta> consultas;

	public Agenda() {}
	
	public Agenda(Medico medico) {
		this.medico = medico;
	}
	
	public boolean estaAberta() {
		return false;
	}

	public boolean estaDisponivel(LocalDateTime data) {
		
		
		return false;
	}

}
