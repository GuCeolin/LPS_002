package com.example.LABS2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public ClienteService() {
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        // Se o cliente tiver um empregador, vamos tratar essa relação primeiro
        if (cliente.getEmpregador() != null) {
            Empregador empregador = cliente.getEmpregador();
            
            // Se o empregador já existir, o merge vai "reattachá-lo" ao contexto de persistência
            if (empregador.getId() != null) {
                empregador = entityManager.merge(empregador);
            } else {
                // Caso contrário, persistimos o novo empregador
                entityManager.persist(empregador);
            }
            cliente.setEmpregador(empregador);
        }

        return clienteRepository.save(cliente); // Persistimos o cliente com o empregador atualizado
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        if (buscarClientePorId(id).isPresent()) {
            excluirCliente(id);
        } else {
            throw new NoSuchElementException("Cliente com ID " + id + " não encontrado.");
        }
    }

    @Transactional
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteExistenteOpt = clienteRepository.findById(id);
        if (clienteExistenteOpt.isPresent()) {
            Cliente clienteExistente = clienteExistenteOpt.get();

            // Atualizar os campos do cliente
            clienteExistente.setNome(clienteAtualizado.getNome());

            // Se o cliente tiver um empregador, tratamos a atualização ou adição do empregador
            if (clienteAtualizado.getEmpregador() != null) {
                Empregador empregador = clienteAtualizado.getEmpregador();
                
                if (empregador.getId() != null) {
                    empregador = entityManager.merge(empregador);
                } else {
                    entityManager.persist(empregador);
                }
                clienteExistente.setEmpregador(empregador);
            }

            return clienteRepository.save(clienteExistente);
        } else {
            throw new NoSuchElementException("Cliente com ID " + id + " não encontrado.");
        }
    }
}
