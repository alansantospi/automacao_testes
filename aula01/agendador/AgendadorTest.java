package aula01.agendador;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AgendadorTest {
	
	List<String> lista = new ArrayList<>();
	Agenda agenda;
	Paciente paciente;
	
	private MockedStatic<Mensalidade> mensalidadeMock;
	
	@BeforeEach
	public void init() {
		
		mensalidadeMock = mockStatic(Mensalidade.class);
		
		mensalidadeMock.when(() -> Mensalidade.meuMetodo())
			.thenAnswer(
				a -> { return true; }
		);
		
		agenda = mock(Agenda.class);
		paciente = mock(Paciente.class);
		when(agenda.estaAberta()).thenReturn(true);
	}
	
	@Test
	public void dadoQueAgendaDoMedicoDisponivel_quandoTentarAgendarParaOMedico_entaoMarcarConsulta() throws PacienteEmAtrasoException {
		
//		 List<String> list = spy(new ArrayList<>());
		 List<String> list = mock(ArrayList.class);
//		 Mockito.when(list.size()).thenReturn(10);
		 doReturn(10).when(list).size();
		 
		 list.add("um");
		 list.add("dois");
		 list.add("três");

		 int size = list.size();
		
		
//		spy(lista);
//		when(lista.size()).thenReturn(10);
		
//		int size = lista.size();
		
		Medico medico = new Medico();
		LocalDateTime data = LocalDateTime.of(2023, 2, 10, 14, 30);
		
		when(agenda.estaDisponivel(data)).thenReturn(true);
		medico.setAgenda(agenda);
		
		when(paciente.isEmDias()).thenReturn(true);
		
		Agendador agendador = new Agendador();
		Consulta consulta = agendador.marcarConsulta(paciente, medico, data);
		Assertions.assertNotNull(consulta);
		verify(agenda).estaAberta();
		verify(agenda, times(1)).estaDisponivel(data);
	}
	
	@Test
	public void dadoQueAgendaDoMedicoDisponivel_ePacienteEmAtraso_quandoTentarAgendarParaOMedico_entaoLancarExcecao() throws PacienteEmAtrasoException {
		Medico medico = new Medico();
		LocalDateTime data = LocalDateTime.of(2023, 2, 10, 14, 30);
		
		when(agenda.estaDisponivel(data)).thenReturn(true);
		medico.setAgenda(agenda);
		
		
		when(paciente.isEmDias()).thenReturn(false);
		Agendador agendador = new Agendador();
		
		assertThrows(PacienteEmAtrasoException.class, () -> agendador.marcarConsulta(paciente, medico, data));
	}
	
}
