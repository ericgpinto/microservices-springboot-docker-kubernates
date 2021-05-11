package br.com.ericpinto.shopping.mapper;

import br.com.ericpinto.shopping.dto.ShopDTO;
import br.com.ericpinto.shopping.model.Shop;

import java.util.stream.Collectors;

public class ShopMapper {

    public static Shop mapToShop(ShopDTO shopDTO){
        return Shop.builder()
                .userIdentifier(shopDTO.getUserIdentifier())
                .total(shopDTO.getTotal())
                .date(shopDTO.getDate())
                .items(shopDTO.getItems()
                        .stream()
                        .map(ItemMapper::mapToItem).collect(Collectors.toList())).build();
    }
}
