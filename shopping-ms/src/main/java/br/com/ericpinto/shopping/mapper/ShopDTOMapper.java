package br.com.ericpinto.shopping.mapper;

import br.com.ericpinto.shopping.dto.ShopDTO;
import br.com.ericpinto.shopping.model.Shop;

public class ShopDTOMapper {

    public static ShopDTO mapToShopDTO(Shop shop){
        return ShopDTO.builder()
                .userIdentifier(shop.getUserIdentifier())
                .total(shop.getTotal()).build();
    }
}
