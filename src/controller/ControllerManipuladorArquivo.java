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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class ControllerManipuladorArquivo {

    public ControllerManipuladorArquivo() {

    }

    static final String PATH = "C:/Projetos/roteirizacao/arquivos/src/arquivos/";

    public String[] leitor(String file) {
        String[] vmLinhas;
        try {
            vmLinhas = new String[linhas(file)];

            BufferedReader buffRead;
            buffRead = new BufferedReader(new FileReader(PATH + file));
            String linha = "";
            int contador = 0;
            while (true) {
                if (linha != null) {
                    linha = buffRead.readLine();
                    vmLinhas[contador] = linha;

                } else {
                    break;
                }
                contador++;
            }
            buffRead.close();
            return vmLinhas;
        } catch (FileNotFoundException ex) {
            System.out.println("1");
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("2");
            ex.getStackTrace();
        }
        return null;
    }

    public void escritor(String file, String linha) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH
                    + file, true));
            buffWrite.append(linha);
            buffWrite.newLine();
            buffWrite.close();

        } catch (IOException ex) {
            System.out.println("3");
            ex.getStackTrace();
        }
    }

    private int linhas(String file) {
        try {
            LineNumberReader lineCounter = new LineNumberReader(new FileReader(
                    PATH + file));
            return lineCounter.getLineNumber();
        } catch (FileNotFoundException ex) {
            System.out.println("4");
            ex.getStackTrace();
        }
        return 0;
    }

}
