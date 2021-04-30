package br.com.ericpinto.product.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class CategoryDTO {

    @NotNull
    private Long id;
    private String name;
}
