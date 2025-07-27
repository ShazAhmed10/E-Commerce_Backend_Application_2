package org.ecommerce_backend.ecommerce_backend_application_2.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateFakeStoreCategoryResponseDto implements Serializable {
	private List<String> categories;
	private String message;
	private String status;
}