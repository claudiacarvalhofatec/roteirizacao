/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.Motorista;

/**
 * 
 * @author Samsumg
 */
public class ControllerMotorista {

	public Motorista salvarMotorista(Motorista objMotorista) {
		if (validacaoObjeto(objMotorista)) {
			ControllerManipuladorArquivo ma = new ControllerManipuladorArquivo();

			StringBuilder buffer = new StringBuilder();

			buffer.append(objMotorista.getNomeMotorista());
			buffer.append(";");
			buffer.append(objMotorista.getCnh());
			buffer.append(";");
			buffer.append(objMotorista.getValidadeCNH());
			buffer.append(";");
			buffer.append(objMotorista.getTelefone2());
			buffer.append(";");
			buffer.append(objMotorista.getPlaca());
			buffer.append(";");
			buffer.append(objMotorista.getTipoVeiculo());
			buffer.append(";");
			buffer.append(objMotorista.getCarga());
			buffer.append(";");
			buffer.append(objMotorista.getCarroceria());
			buffer.append(";");
			buffer.append(objMotorista.getAltura());
			buffer.append(";");
			buffer.append(objMotorista.getComprimento());
			buffer.append(";");
			buffer.append(objMotorista.getVolume());
			buffer.append(";");
			buffer.append(objMotorista.getLargura());
			buffer.append(";");
			buffer.append(objMotorista.getEstado());
			buffer.append(";");
			buffer.append(objMotorista.getCidade());

			ma.escritor("motoristas.csv", buffer.toString());

			return objMotorista;
		}
		return null;
	}

	private boolean validacaoObjeto(Motorista motorista) {
		return true;
	}

	public String[] getEstado() {
		String[] estados = new String[27];
		int contador = 0;
		estados[contador++] = "AC";
		estados[contador++] = "AL";
		estados[contador++] = "AP";
		estados[contador++] = "AM";
		estados[contador++] = "BA";
		estados[contador++] = "CE";
		estados[contador++] = "DF";
		estados[contador++] = "ES";
		estados[contador++] = "GO";
		estados[contador++] = "MA";
		estados[contador++] = "MT";
		estados[contador++] = "MS";
		estados[contador++] = "MG";
		estados[contador++] = "PA";
		estados[contador++] = "PB";
		estados[contador++] = "PR";
		estados[contador++] = "PE";
		estados[contador++] = "PI";
		estados[contador++] = "RJ";
		estados[contador++] = "RN";
		estados[contador++] = "RS";
		estados[contador++] = "RO";
		estados[contador++] = "RR";
		estados[contador++] = "SC";
		estados[contador++] = "SP";
		estados[contador++] = "SE";
		estados[contador] = "TO";

		return estados;
	}
}
