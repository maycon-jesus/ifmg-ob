package Usuarios;

import Atendimento.Ficha;

public interface Atender {
	void atender(Ficha ficha);

	void finalizarAtendimento(Ficha ficha);
}
