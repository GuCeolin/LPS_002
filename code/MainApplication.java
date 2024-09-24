package com.example.LABS2;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private ClienteService clienteService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            Empregador empregador1 = new Empregador();
            empregador1.setNomeEmpresa("Empresa A");
            empregador1.setCargo("Engenheiro");

            Empregador empregador2 = new Empregador();
            empregador2.setNomeEmpresa("Empresa B");
            empregador2.setCargo("Advogada");

            Veiculo veiculo1 = new Veiculo();
            veiculo1.setModelo("Carro 1");
            veiculo1.setPlaca("AAA-1234");

            Veiculo veiculo2 = new Veiculo();
            veiculo2.setModelo("Carro 2");
            veiculo2.setPlaca("BBB-5678");

            Cliente cliente1 = new Cliente();
            cliente1.setNome("João Silva");
            cliente1.setRg("MG-123456");
            cliente1.setCpf("123.456.789-00");
            cliente1.setEndereco("Rua A, 123");
            cliente1.setProfissao("Engenheiro");
            cliente1.setRenda(5000.0);
            cliente1.setEmpregadores(Arrays.asList(empregador1, empregador2));
            cliente1.setVeiculos(Arrays.asList(veiculo1));

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Maria Souza");
            cliente2.setRg("MG-654321");
            cliente2.setCpf("987.654.321-00");
            cliente2.setEndereco("Rua B, 456");
            cliente2.setProfissao("Advogada");
            cliente2.setRenda(7000.0);
            cliente2.setEmpregadores(Arrays.asList(empregador2));
            cliente2.setVeiculos(Arrays.asList(veiculo2));

            clienteService.criarCliente(cliente1);
            clienteService.criarCliente(cliente2);

            System.out.println("Banco de dados populado com sucesso.");
        };
    }
}