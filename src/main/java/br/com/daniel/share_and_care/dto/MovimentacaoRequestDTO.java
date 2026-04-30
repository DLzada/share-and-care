package br.com.daniel.share_and_care.dto;

import br.com.daniel.share_and_care.domain.enums.TipoMovimentacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record MovimentacaoRequestDTO (
        @NotNull(message = "O id do item é obrigatório")
        UUID itemId,

        UUID doadorId,

        @NotNull(message = "O tipo da movimentaçao é obrigatório")
        TipoMovimentacao tipo,

        @NotNull(message = "A quantidade é obrigatória")
        @Positive(message = "A quantidade precisar ser maior que zero")
        Integer quantidade,

        String observacao
){}
