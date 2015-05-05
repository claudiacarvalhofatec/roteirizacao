/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            try {
                ma.escritor("motoristas.csv", buffer.toString());
            } catch (IOException ex) {
                ex.getStackTrace();
            }

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

    private Motorista[] carregaArquivo() {
        String[] linhasMotoristas = null;
        Motorista[] motoristas = null;
        ControllerManipuladorArquivo ma = new ControllerManipuladorArquivo();
        try {
            linhasMotoristas = ma.leitor("motoristas.csv");
        } catch (IOException ex) {
            ex.getStackTrace();
        }

        if (linhasMotoristas != null) {
            int i = 0;
            for (String linha : linhasMotoristas) {
                String[] vmColunas = linha.split(";");

                motoristas[i++] = this.preencheObjeto(vmColunas);
            }
        }

        return motoristas;

    }

    private Motorista preencheObjeto(String[] colunas) {
        Motorista objMotorista = new Motorista();

        int i = 0;
        objMotorista.setNomeMotorista(colunas[i++]);
        objMotorista.setCnh(colunas[i++]);
        objMotorista.setValidadeCNH(colunas[i++]);
        objMotorista.setTelefone1(colunas[i++]);
        objMotorista.setTelefone2(colunas[i++]);
        objMotorista.setPlaca(colunas[i++]);
        objMotorista.setCarga(colunas[i++]);
        objMotorista.setAltura(colunas[i++]);
        objMotorista.setComprimento(colunas[i++]);
        objMotorista.setVolume(colunas[i++]);
        objMotorista.setLargura(colunas[i++]);
        objMotorista.setCarroceria(colunas[i++]);
        objMotorista.setEstado(colunas[i++]);
        objMotorista.setTipoVeiculo(colunas[i++]);
        objMotorista.setCidade(colunas[i++]);

        return objMotorista;
    }
}
