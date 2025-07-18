package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreCategoryResponseDto {
    private String status;
    private String message;
    private List<String> categories;
}
