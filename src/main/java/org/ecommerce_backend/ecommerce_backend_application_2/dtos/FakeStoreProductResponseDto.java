package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductResponseDto{
	private String status;
	private String message;
	private ProductDto product;
}
