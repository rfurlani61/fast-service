package br.com.fiap.adapter.web;

import br.com.fiap.core.domain.exception.ClienteNotFoundException;
import br.com.fiap.core.domain.exception.PersistenceException;
import br.com.fiap.core.domain.model.request.ClienteRegisterRequest;
import br.com.fiap.core.domain.model.response.AppResponse;
import br.com.fiap.core.domain.model.response.ClienteResponse;
import br.com.fiap.core.domain.model.response.ResponseUtil;
import br.com.fiap.core.port.in.ClienteLoadInputPort;
import br.com.fiap.core.port.in.ClienteRegisterInputPort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/clientes")
@Tag(name = "API Clientes v1.0", description = "Endpoints para cadastro e identificação de clientes")
public class ClientesController {

    private final ClienteRegisterInputPort clienteRegisterInputPort;
    private final ClienteLoadInputPort clienteLoadInputPort;

    public ClientesController(ClienteRegisterInputPort clienteRegisterInputPort,
                              ClienteLoadInputPort clienteLoadInputPort) {
        this.clienteRegisterInputPort = clienteRegisterInputPort;
        this.clienteLoadInputPort = clienteLoadInputPort;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto contendo as informações do cliente cadastrado"),
            @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao processar o cadastro do cliente"),
    })
    public ResponseEntity<AppResponse<ClienteResponse>> registerCustomer(HttpServletRequest request,
                                                                         @RequestBody ClienteRegisterRequest clienteRegisterRequest) {
        try {
            var clienteResponse = clienteRegisterInputPort.register(clienteRegisterRequest);
            clienteResponse.setPath(String.format("%s/%s", request.getRequestURL().toString(),
                    clienteResponse.getCpf()));

            AppResponse<ClienteResponse> response = ResponseUtil.success(clienteResponse,
                    "Cliente cadastrado com sucesso",
                    clienteResponse.getPath());

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (PersistenceException ex) {
            AppResponse<ClienteResponse> response = ResponseUtil.error(ex.getCause().getLocalizedMessage(),
                    ex.getLocalizedMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    request.getRequestURL().toString());

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{cpf}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto contendo as informações do cliente"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
    })
    public ResponseEntity<AppResponse<ClienteResponse>> getCustomerByCpf(HttpServletRequest request,
                                                                         @PathVariable String cpf) {
        try {
            var clienteResponse = clienteLoadInputPort.loadByCpf(cpf);
            clienteResponse.setPath(request.getRequestURL().toString());

            AppResponse<ClienteResponse> response = ResponseUtil.success(clienteResponse,
                    "Cliente encontrado na base de dados",
                    clienteResponse.getPath());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ClienteNotFoundException ex) {

            AppResponse<ClienteResponse> response = ResponseUtil.error(ex.getLocalizedMessage(),
                    "Não foi possível processar a requisição",
                    HttpStatus.NOT_FOUND.value(),
                    request.getRequestURL().toString());

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista contendo as informações dos clientes"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado na base de dados"),
    })
    public ResponseEntity<AppResponse<List<ClienteResponse>>> getCustomerList(HttpServletRequest request) {
        var clienteResponse = clienteLoadInputPort.loadAll();

        if (clienteResponse.isEmpty()) {
            AppResponse<List<ClienteResponse>> response = ResponseUtil.error("Nenhum cliente encontrado na base de dados",
                    "Não foi possível processar a requisição",
                    HttpStatus.NOT_FOUND.value(),
                    request.getRequestURL().toString());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        clienteResponse.forEach(cliente -> cliente.setPath(String.format("%s/%s", request.getRequestURL().toString(), cliente.getCpf())));

        AppResponse<List<ClienteResponse>> response = ResponseUtil.success(clienteResponse,
                "Lista de clientes encontrados na base de dados",
                request.getRequestURL().toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
