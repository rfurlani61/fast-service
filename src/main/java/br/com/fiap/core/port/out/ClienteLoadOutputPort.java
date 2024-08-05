package br.com.fiap.core.port.out;

import br.com.fiap.core.domain.model.response.ClienteResponse;

import java.util.List;

public interface ClienteLoadOutputPort {
    ClienteResponse loadByCpf(String cpf);
    List<ClienteResponse> loadAll();
}
