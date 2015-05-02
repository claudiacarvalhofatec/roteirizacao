package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ControllerMap {

    public ControllerMap() {
        Map<Integer, String> mapaNomes = new HashMap<Integer, String>();
        mapaNomes.put(1, "João Delfino");
        mapaNomes.put(2, "Maria do Carmo");
        mapaNomes.put(3, "Claudinei Silva");

        //Collection<Integer> conjNomes = mapaNomes.keySet();
        Set<Entry<Integer, String>> set = mapaNomes.entrySet();
        Iterator it = set.iterator();

        System.out.println("Código\t\tValor");

        //getKey() - recupera a chave do mapa
        //getValue() - recupera o valor do mapa
        while (it.hasNext()) {
            Entry<Integer, String> entry = (Entry) it.next();
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }
}
