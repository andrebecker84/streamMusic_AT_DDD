package com.streaming.musica.domain.transaction.fraud;

/**
 * Anticorruption Layer do contexto de Antifraude.
 *
 * Traduz os modelos dos contextos Conta, Assinatura e Transação para a
 * linguagem própria das regras — tipos primitivos que expressam apenas o
 * que a fraude precisa saber, sem expor os agregados crus de outros contextos.
 */
public record FraudValidationContext(
        boolean cartaoCadastrado,
        boolean cartaoAtivo,
        boolean assinaturaAtiva,
        int quantidadeTransacoesRecentes,
        int quantidadeTransacoesSemelhantes
) {}
