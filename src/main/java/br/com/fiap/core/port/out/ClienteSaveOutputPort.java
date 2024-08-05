package br.com.fiap.core.port.out;

import br.com.fiap.core.domain.model.Cliente;
import br.com.fiap.core.domain.model.response.ClienteResponse;

public interface ClienteSaveOutputPort {

    ClienteResponse save(Cliente cliente);
}
