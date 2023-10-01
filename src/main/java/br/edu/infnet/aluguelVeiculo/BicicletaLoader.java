package br.edu.infnet.aluguelVeiculo;

import br.edu.infnet.aluguelVeiculo.categoria.Categoria;
import br.edu.infnet.aluguelVeiculo.model.Bicicleta;
import br.edu.infnet.aluguelVeiculo.model.Carro;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class BicicletaLoader implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("src/main/resources/static/bicicleta.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        System.out.println("##########################");
        while (linha != null) {
            campos = linha.split(",");
            Bicicleta bike = new Bicicleta(campos[0],
                    Double.parseDouble(campos[1]),
                    Categoria.valueOf(campos[2]),
                    campos[3],
                    Boolean.getBoolean(campos[4]),
                    campos[5]);
            System.out.println("linha: " + linha);
            System.out.println(bike);
            linha = leitura.readLine();
        }
        System.out.println("##########################");
    }
}
