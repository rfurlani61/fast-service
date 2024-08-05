package br.com.fiap.core.domain.model;

public enum PedidoStatus {

    AGUARDANDO_PAGAMENTO("Aguardando Pagamento") {
        @Override
        public boolean isAguardandoPagamento() {
            return true;
        }
    },
    PAGO("Pago") {
        @Override
        public boolean isPago() {
            return true;
        }
    },
    FALHA_NO_PAGAMENTO("Falha no Pagamento") {
        @Override
        public boolean isFalhaNoPagamento() {
            return true;
        }
    },
    RECEBIDO("Recebido") {
        @Override
        public boolean isRecebido() {
            return true;
        }
    },
    EM_PREPARACAO("Em Preparação") {
        @Override
        public boolean isEmPreparacao() {
            return true;
        }
    },
    PRONTO("Pronto") {
        @Override
        public boolean isPronto() {
            return true;
        }
    },
    FINALIZADO("Finalizado") {
        @Override
        public boolean isFinalizado() {
            return true;
        }
    };

    private String descricao;

    PedidoStatus(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAguardandoPagamento() {
        return false;
    }

    public boolean isPago() {
        return false;
    }

    public boolean isFalhaNoPagamento() {
        return false;
    }

    public boolean isRecebido() {
        return false;
    }

    public boolean isEmPreparacao() {
        return false;
    }

    public boolean isPronto() {
        return false;
    }

    public boolean isFinalizado() {
        return false;
    }

    public String getDescricao() {
        return descricao;
    }

}
