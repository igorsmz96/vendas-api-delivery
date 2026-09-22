package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.requestCreate.StockRequest;
import com.vendas.api.delivery_api.controllers.response.StockResponse;
import com.vendas.api.delivery_api.entities.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMapper {

    private final ProductVariantMapper variantMapper;

    public Stock toStock (StockRequest stockRequest) {
        Stock stock = new Stock();

        stock.setQuantity(stockRequest.quantity());

        return stock;

    }

    public StockResponse toStockResponse (Stock stock){
        return new StockResponse(stock.getId(),
                stock.getStore().getName(),
                stock.getProductVariant().getSku(),
                stock.getQuantity());
    }
}
