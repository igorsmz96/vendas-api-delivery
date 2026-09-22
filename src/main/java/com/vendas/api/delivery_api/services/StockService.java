package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.requestCreate.StockRequest;
import com.vendas.api.delivery_api.controllers.response.StockResponse;
import com.vendas.api.delivery_api.controllers.response.StockTotalResponse;
import com.vendas.api.delivery_api.entities.ProductVariant;
import com.vendas.api.delivery_api.entities.Stock;
import com.vendas.api.delivery_api.entities.Store;
import com.vendas.api.delivery_api.exception.DuplicateDataException;
import com.vendas.api.delivery_api.exception.ProductVariantNotFoundException;
import com.vendas.api.delivery_api.exception.StockNotFoundException;
import com.vendas.api.delivery_api.exception.StoreNotFoundException;
import com.vendas.api.delivery_api.mapper.StockMapper;
import com.vendas.api.delivery_api.repositories.ProductVariantRepository;
import com.vendas.api.delivery_api.repositories.StockRepository;
import com.vendas.api.delivery_api.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StoreRepository storeRepository;
    private final ProductVariantRepository variantRepository;
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    //criar stock com variant e store
    @Transactional
    public StockResponse create(StockRequest stockRequest) {
        Store store = storeRepository.findById(stockRequest.store_id())
                .orElseThrow(StoreNotFoundException::new);

        ProductVariant variant = variantRepository.findById(stockRequest.product_variant_id())
                .orElseThrow(ProductVariantNotFoundException::new);

        if (stockRepository.existsByStoreIdAndProductVariantId(stockRequest.store_id(), stockRequest.product_variant_id())) {
            throw new DuplicateDataException("Variante já cadastrada no estoque");
        }

        Stock stock = stockMapper.toStock(stockRequest);
        stock.setProductVariant(variant);
        stock.setStore(store);
        stockRepository.save(stock);

        return stockMapper.toStockResponse(stock);

    }
    // pesquisar por stock id
    @Transactional(readOnly = true)
    public StockResponse findById (Long id){
        Stock stock = stockRepository.findById(id)
                .orElseThrow(StockNotFoundException::new);
        return stockMapper.toStockResponse(stock);
    }
    // pesquisar stock where variant ID
    @Transactional(readOnly = true)
    public List<StockResponse> findAllVariant(Long variantId){
        if(!variantRepository.existsById(variantId)){
            throw new ProductVariantNotFoundException();
        }
        List <Stock> stock = stockRepository.findByProductVariantId(variantId);

        return stock.stream().map(stockMapper::toStockResponse).toList();
    }
    // pesquisar stock where store ID
    @Transactional(readOnly = true)
    public List<StockResponse> findAllByStore(Long storeId){
        if(!storeRepository.existsById(storeId)){
            throw new StoreNotFoundException();
        }
        List <Stock> stock = stockRepository.findByStoreId(storeId);
        return stock.stream().map(stockMapper::toStockResponse).toList();
    }

    // pesquisar qnt total variant
    @Transactional(readOnly = true)
    public StockTotalResponse findTotalByVariant(Long variantId){
        if(!variantRepository.existsById(variantId)){
            throw new ProductVariantNotFoundException();
        }
        Long totalResponse = stockRepository.sumQuantityByVariantId(variantId);
        return new StockTotalResponse(variantId, totalResponse);
    }

}
