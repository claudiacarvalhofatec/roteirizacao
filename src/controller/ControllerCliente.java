/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;

/**
 *
 * @author Samsumg
 */
public class ControllerCliente {

    /**
     * Ordem da string.
     * CNPJ;CLiente;Cep;Bairro;Logradouro;Numero;Domingo;Segunda
     * ;Terça;Quarta;Quinta;Sexta;Sabado\n
     *
     * @param objCliente
     * @return
     */
    public Cliente salvarCliente(Cliente objCliente) {
        if (validacaoObjeto(objCliente)) {
            ControllerManipuladorArquivo ma = new ControllerManipuladorArquivo();

            StringBuilder buffer = new StringBuilder();

            buffer.append(objCliente.getCnpj());
            buffer.append(";");
            buffer.append(objCliente.getCliente());
            buffer.append(";");
            buffer.append(objCliente.getCep());
            buffer.append(";");
            buffer.append(objCliente.getBairro());
            buffer.append(";");
            buffer.append(objCliente.getLogradouro());
            buffer.append(";");
            buffer.append(objCliente.getNumero());
            buffer.append(";");
            buffer.append(objCliente.getDomingo());
            buffer.append(";");
            buffer.append(objCliente.getSegunda());
            buffer.append(";");
            buffer.append(objCliente.getTerca());
            buffer.append(";");
            buffer.append(objCliente.getQuarta());
            buffer.append(";");
            buffer.append(objCliente.getQuinta());
            buffer.append(";");
            buffer.append(objCliente.getSexta());
            buffer.append(";");
            buffer.append(objCliente.getSabado());

            ma.escritor("clientes.csv", buffer.toString());

            return objCliente;
        }
        return null;
    }

    private boolean validacaoObjeto(Cliente cliente) {
        return true;
    }

    public void buscaCliente(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
