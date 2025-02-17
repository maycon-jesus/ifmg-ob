package ui;

import Atendimento.Ficha;
import Atendimento.FichaStatus;
import Usuarios.Medico;
import db.DBGlobal;

import java.util.ArrayList;
import java.util.Collections;

public class FilaOperations {
	public static Ficha getNextFichaTriagem() {
		ArrayList<Ficha> filaRecepcao = DBGlobal.fichas.getFichasByStatus(FichaStatus.RECEPCAO);
		if (filaRecepcao.size() == 0) {
			return null;
		}

		Collections.sort(filaRecepcao);
		return filaRecepcao.get(0);
	}

	public static Ficha getNextFichaAtendimentoMedico(Medico medico) {
		ArrayList<Ficha> filaEspecialidade = DBGlobal.fichas.getFichasByStatusAndEspecialidade(FichaStatus.TRIAGEM_FINALIZADA, medico.getEspecialidade());
		if (filaEspecialidade.size() == 0) {
			return null;
		}

		Collections.sort(filaEspecialidade);
		return filaEspecialidade.get(0);
	}
}
