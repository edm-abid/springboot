package com.example.client.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClientResponseDto {
    private Long id;
    private String fullName;
    private String email;
}
