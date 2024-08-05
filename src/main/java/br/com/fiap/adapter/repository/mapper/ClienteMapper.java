package br.com.fiap.adapter.repository.mapper;

import br.com.fiap.adapter.repository.model.ClienteJpa;
import br.com.fiap.core.domain.model.Cliente;
import br.com.fiap.core.domain.model.response.ClienteResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteJpa toClienteJpa(Cliente cliente) {
        return new ClienteJpa(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        );
    }

    public Cliente toCliente(ClienteJpa clienteJpa) {
        return new Cliente(
                clienteJpa.getNome(),
                clienteJpa.getCpf(),
                clienteJpa.getEmail()
        );
    }

    public ClienteResponse toClienteResponse(ClienteJpa clienteJpa) {
        return new ClienteResponse(
                clienteJpa.getId(),
                clienteJpa.getNome(),
                clienteJpa.getCpf(),
                clienteJpa.getEmail(),
                Strings.EMPTY
        );
    }
}
