package br.com.fiap.adapter.integration;

import br.com.fiap.core.port.out.FetchPaymentQRCodeOutputPort;

public class MercadoPagoServiceMock implements FetchPaymentQRCodeOutputPort {

    @Override
    public String getQRCode() {
        return "QR Code para pagamento do pedido";
    }
}
