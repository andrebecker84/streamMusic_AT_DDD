package com.streaming.musica.domain.transaction.fraud;

public enum FraudViolation {

    CARTAO_NAO_ATIVO("cartão-não-ativo"),
    ALTA_FREQUENCIA_PEQUENO_INTERVALO("alta-frequência-pequeno-intervalo"),
    TRANSACAO_DUPLICADA("transação-duplicada"),
    PLANO_ATIVO_INVALIDO("plano-ativo-inválido"),
    CARTAO_CREDITO_INVALIDO("cartão-de-crédito-inválido");

    private final String codigo;

    FraudViolation(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
}
