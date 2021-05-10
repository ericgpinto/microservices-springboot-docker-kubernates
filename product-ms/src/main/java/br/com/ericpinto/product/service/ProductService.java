package br.com.ericpinto.product.service;

import br.com.ericpinto.product.dto.ProductDTO;
import br.com.ericpinto.product.model.Mapper;
import br.com.ericpinto.product.model.Product;
import br.com.ericpinto.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll(){
        var products = productRepository.findAll();
        return products
                .stream()
                .map(Mapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(
            String productIdentifier) {
        var product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return Mapper.mapToProductDTO(product);
        }
        return null;
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId){
        var products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(Mapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO productDTO){
        var product = productRepository.save(Mapper.mapToProduct(productDTO));
        return Mapper.mapToProductDTO(product);
    }

//    public void delete(Long productId){
//        Optional<Product> product = productRepository.findById(productId).orElseThrow(() -> new );
//    }
}
