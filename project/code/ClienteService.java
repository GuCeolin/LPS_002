@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obterClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = obterClientePorId(id);
        clienteExistente.setRg(cliente.getRg());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteExistente.setProfissao(cliente.getProfissao());
        clienteExistente.setEmpregador(cliente.getEmpregador());
        clienteExistente.setRenda(cliente.getRenda());
        return clienteRepository.save(clienteExistente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}