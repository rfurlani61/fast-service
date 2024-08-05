package br.com.fiap.core.usecase;

import br.com.fiap.core.domain.model.response.ClienteResponse;
import br.com.fiap.core.port.in.ClienteLoadInputPort;
import br.com.fiap.core.port.out.ClienteLoadOutputPort;

import java.util.List;

public class ClienteLoadUseCase implements ClienteLoadInputPort {

    private final ClienteLoadOutputPort clienteLoadOutputPort;

    public ClienteLoadUseCase(ClienteLoadOutputPort clienteLoadOutputPort) {
        this.clienteLoadOutputPort = clienteLoadOutputPort;
    }

    @Override
    public ClienteResponse loadByCpf(String cpf) {
        return clienteLoadOutputPort.loadByCpf(cpf);
    }

    @Override
    public List<ClienteResponse> loadAll() {
        return clienteLoadOutputPort.loadAll();
    }
}
