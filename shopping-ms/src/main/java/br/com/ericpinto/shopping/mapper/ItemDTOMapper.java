package br.com.ericpinto.shopping.mapper;

import br.com.ericpinto.shopping.dto.ItemDTO;
import br.com.ericpinto.shopping.model.Item;

public class ItemDTOMapper {

    public static ItemDTO mapToItemDTO(Item item){
        return ItemDTO.builder()
                .productIdentifier(item.getProductIdentifier())
                .price(item.getPrice()).build();
    }
}
