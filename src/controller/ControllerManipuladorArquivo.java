/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Samsumg
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerManipuladorArquivo {

    public ControllerManipuladorArquivo() {

    }

    static final String PATH = "D:/Projetos/roteirizacao/arquivos/src/arquivos/";

    public String[] leitor(String file) throws FileNotFoundException, IOException {
        String[] linhasArquivo = new String[this.linhas(PATH + file)];
        File arquivo = new File(PATH + file);
        if (arquivo.exists() && arquivo.isFile()) {
            FileInputStream abreArquivo;

            abreArquivo = new FileInputStream(arquivo);

            InputStreamReader leFluxo = new InputStreamReader(abreArquivo);
            BufferedReader bufferLeitura = new BufferedReader(leFluxo);
            String linha = bufferLeitura.readLine();
            int i = 0;
            while (linha != null) {
                if (arquivo.getName().contains("csv")) {
                    linhasArquivo[i] = linha;
                }
                linha = bufferLeitura.readLine();
                i++;
            }
            bufferLeitura.close();
            leFluxo.close();
            abreArquivo.close();

        } else {
            throw new IOException("Arquivo inválido.");
        }
        return linhasArquivo;
    }

    public void escritor(String file, String linha) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH
                + file, true));
        buffWrite.append(linha);
        buffWrite.newLine();
        buffWrite.close();

    }

    private int linhas(String file) throws FileNotFoundException {
        LineNumberReader lineCounter = new LineNumberReader(new FileReader(
                PATH + file));
        return lineCounter.getLineNumber();
    }

}
