package br.com.fiap.adapter.repository;

import br.com.fiap.adapter.repository.jpa.ClienteJpaRepository;
import br.com.fiap.adapter.repository.mapper.ClienteMapper;
import br.com.fiap.core.domain.exception.ClienteNotFoundException;
import br.com.fiap.core.domain.exception.PersistenceException;
import br.com.fiap.core.domain.model.Cliente;
import br.com.fiap.core.domain.model.response.ClienteResponse;
import br.com.fiap.core.port.out.ClienteLoadOutputPort;
import br.com.fiap.core.port.out.ClienteSaveOutputPort;

import java.util.List;

public class ClienteRepository implements ClienteSaveOutputPort, ClienteLoadOutputPort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper clienteMapper;

    public ClienteRepository(ClienteJpaRepository clienteJpaRepository,
                             ClienteMapper clienteMapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteResponse save(Cliente cliente) {
        try {
            var clienteJpa = clienteMapper.toClienteJpa(cliente);
            var clienteSaved = clienteJpaRepository.save(clienteJpa);
            return clienteMapper.toClienteResponse(clienteSaved);
        } catch(RuntimeException ex) {
            throw new PersistenceException("Ocorreu um erro ao tentar processar o cadastro do cliente", ex);
        }
    }

    @Override
    public ClienteResponse loadByCpf(String cpf) {
        var cliente = clienteJpaRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado (CPF: " + cpf + ")"));
        return clienteMapper.toClienteResponse(cliente);
    }

    @Override
    public List<ClienteResponse> loadAll() {
        return clienteJpaRepository.findAll()
                .stream()
                .map(clienteMapper::toClienteResponse)
                .toList();
    }
}
