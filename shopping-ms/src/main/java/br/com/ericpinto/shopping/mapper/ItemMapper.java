package br.com.ericpinto.shopping.mapper;

import br.com.ericpinto.shopping.dto.ItemDTO;
import br.com.ericpinto.shopping.model.Item;

public class ItemMapper {

    public static Item mapToItem(ItemDTO itemDTO){
        return Item.builder()
                .productIdentifier(itemDTO.getProductIdentifier())
                .price(itemDTO.getPrice()).build();
    }
}
