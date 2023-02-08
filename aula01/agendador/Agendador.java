package aula01.agendador;

import java.time.LocalDateTime;

public class Agendador {

	public Consulta marcarConsulta(Paciente paciente, Medico medico, LocalDateTime data) throws PacienteEmAtrasoException {
		
		boolean emDias = paciente.isEmDias();
		
		if (!emDias) {
			throw new PacienteEmAtrasoException("Paga as contas primeiro, caloteiro!");
		}
		
		Agenda agenda = medico.getAgenda();
		boolean estaAberta = agenda.estaAberta();
		boolean estaDisponivel = agenda.estaDisponivel(data);
		if (estaAberta && estaDisponivel) {
			return new Consulta();
		}
		
		return null;
	}

}
