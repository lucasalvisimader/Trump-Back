package br.senai.sc.trunfo.security.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSecurityDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
