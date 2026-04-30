package br.com.daniel.share_and_care.dto;

import br.com.daniel.share_and_care.domain.enums.UnidadeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemRequestDTO(
   @NotBlank(message = "O nome é obrigatório")
   String nome,

   @NotNull(message = "A unidade de medida é obrigatória")
   UnidadeMedida unidadeMedida,

   @NotNull(message = "O id da categoria é obrigatório")
   Long categoriaId
) {}
