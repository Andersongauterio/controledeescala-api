package br.com.anderson.controledeescala;

import br.com.anderson.controledeescala.controller.EscalaController;
import br.com.anderson.controledeescala.modelo.EscalaMes;
import br.com.anderson.controledeescala.modelo.Mes;

public class Teste {

	public static void main(String[] args) {
		EscalaController controller = new EscalaController();
		EscalaMes escala = new EscalaMes();
		
		escala = controller.montaEscala(Mes.ABRIL, 2022);

	}

}
