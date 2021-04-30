package br.com.ericpinto.product.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String name;
    @NotNull
    private Float amount;
    @NotBlank
    private String description;
    @NotNull
    private CategoryDTO category;
}
