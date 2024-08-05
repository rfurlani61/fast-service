package br.com.fiap.core.domain.model;

public enum ProdutoCategoria {

    LANCHE("Lanche") {
        @Override
        public boolean isLanche() {
            return true;
        }
    },
    ACOMPANHAMENTO("Acompanhamento") {
        @Override
        public boolean isAcompanhamento() {
            return true;
        }
    },
    BEBIDA("Bebida") {
        @Override
        public boolean isBebida() {
            return true;
        }
    },
    SOBREMESA("Sobremesa") {
        @Override
        public boolean isSobremesa() {
            return true;
        }
    };

    private String descricao;

    ProdutoCategoria(String descricao) {
        this.descricao = descricao;
    }

    public boolean isLanche() {
        return false;
    }

    public boolean isAcompanhamento() {
        return false;
    }

    public boolean isBebida() {
        return false;
    }

    public boolean isSobremesa() {
        return false;
    }

    public String getDescricao() {
        return descricao;
    }

}
