package br.com.fiap.core.port.in;

import br.com.fiap.core.domain.model.request.ClienteRegisterRequest;
import br.com.fiap.core.domain.model.response.ClienteResponse;

public interface ClienteRegisterInputPort {

    ClienteResponse register(ClienteRegisterRequest clienteRegisterRequest);
}
