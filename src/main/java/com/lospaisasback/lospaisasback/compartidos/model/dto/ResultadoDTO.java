package com.lospaisasback.lospaisasback.compartidos.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoDTO {

    private String mensaje;
    private List<String> listaMessages;
    private Boolean exitoso;
}
