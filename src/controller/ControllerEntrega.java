/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.Entrega;

/**
 * 
 * @author Samsumg
 */
public class ControllerEntrega {

	public Entrega salvarEntrega(Entrega objEntrega) {

		if (validacaoObjeto(objEntrega)) {
			ControllerManipuladorArquivo ma = new ControllerManipuladorArquivo();

			StringBuilder buffer = new StringBuilder();

			buffer.append(objEntrega.getClienteId());
			buffer.append(";");
			buffer.append(objEntrega.getPeso());
			buffer.append(";");
			buffer.append(objEntrega.getQtdePaletes());
			buffer.append(";");
			buffer.append(objEntrega.getVolume());
			buffer.append(";");
			buffer.append(objEntrega.getDataEntrega());

			ma.escritor("entregas.csv", buffer.toString());

			return objEntrega;
		}
		return null;
	}

	private boolean validacaoObjeto(Entrega objEntrega) {
		return true;
	}
}
