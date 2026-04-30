package br.com.daniel.share_and_care.dto;

import br.com.daniel.share_and_care.domain.enums.TipoDoador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoadorRequestDTO(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        String contato,

        @NotNull(message = "É necessário informar o tipo do doador")
        TipoDoador tipoDoador
) {}
