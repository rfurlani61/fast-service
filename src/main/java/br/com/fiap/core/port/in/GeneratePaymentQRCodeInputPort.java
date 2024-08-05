package br.com.fiap.core.port.in;

import br.com.fiap.core.domain.model.PaymentQRCodeRequest;

public interface GeneratePaymentQRCodeInputPort {

    String generatePaymentQrCode(PaymentQRCodeRequest paymentQRCodeRequest);
}
