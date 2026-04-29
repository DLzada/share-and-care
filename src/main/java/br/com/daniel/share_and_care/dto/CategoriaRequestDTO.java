package br.com.daniel.share_and_care.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(
        @NotBlank(message = "O nome da categoria é obrigatório")
        String nome,

        String descricao
) {}
