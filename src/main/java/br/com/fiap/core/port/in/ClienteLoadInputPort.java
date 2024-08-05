package br.com.fiap.core.port.in;

import br.com.fiap.core.domain.model.response.ClienteResponse;

import java.util.List;

public interface ClienteLoadInputPort {
    ClienteResponse loadByCpf(String cpf);
    List<ClienteResponse> loadAll();
}
