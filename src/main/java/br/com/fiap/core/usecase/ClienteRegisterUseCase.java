package br.com.fiap.core.usecase;

import br.com.fiap.core.domain.model.Cliente;
import br.com.fiap.core.domain.model.request.ClienteRegisterRequest;
import br.com.fiap.core.domain.model.response.ClienteResponse;
import br.com.fiap.core.port.in.ClienteRegisterInputPort;
import br.com.fiap.core.port.out.ClienteSaveOutputPort;

public class ClienteRegisterUseCase implements ClienteRegisterInputPort {

    private final ClienteSaveOutputPort clienteSaveOutputPort;


    public ClienteRegisterUseCase(ClienteSaveOutputPort clienteSaveOutputPort) {
        this.clienteSaveOutputPort = clienteSaveOutputPort;
    }

    @Override
    public ClienteResponse register(ClienteRegisterRequest clienteRegisterRequest) {

        var cliente = new Cliente(
                clienteRegisterRequest.nome(),
                clienteRegisterRequest.cpf(),
                clienteRegisterRequest.email()
        );

        return clienteSaveOutputPort.save(cliente);
    }
}
