package br.com.ericpinto.product.mapper;

import br.com.ericpinto.product.dto.CategoryDTO;
import br.com.ericpinto.product.dto.ProductDTO;
import br.com.ericpinto.product.model.Category;
import br.com.ericpinto.product.model.Product;

public class Mapper {

    public static Category mapToCategory(CategoryDTO categoryDTO){
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    public static CategoryDTO mapToCategoryDTO(Category category){
       return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setAmount(productDTO.getAmount());
        product.setDescription(productDTO.getDescription());
        product.setProductIdentifier(
                productDTO.getProductIdentifier());
        if (productDTO.getCategory() != null) {
            product.setCategory(
                    mapToCategory(productDTO.getCategory()));
        }
        return product;
    }
    public static ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setAmount(product.getAmount());
        productDTO.setProductIdentifier(
                product.getProductIdentifier());
        productDTO.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            productDTO.setCategory(
                    mapToCategoryDTO(product.getCategory()));
        }
        return productDTO;
    }
}
