package com.example.client.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientRequestDto {
    private String fullName;
    private String email;
}
