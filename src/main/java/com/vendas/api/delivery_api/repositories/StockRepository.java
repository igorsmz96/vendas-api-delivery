package com.vendas.api.delivery_api.repositories;

import com.vendas.api.delivery_api.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    boolean existsByStoreIdAndProductVariantId(Long storeId, Long productVariantId);

    List<Stock> findByProductVariantId(Long variantId);

    List<Stock> findByStoreId(Long storeId);

    @Query("""
            SELECT COALESCE(SUM(s.quantity), 0L)
            FROM Stock s
            WHERE s.productVariant.id = :variantId
            """)
    Long sumQuantityByVariantId(@Param("variantId") Long variantId);


    //UTILIZAR NO SERVICE DE PEDIDO PARA DAR BAIXA NO ESTOQUE
    @Modifying(clearAutomatically = true)
    @Query("""
            UPDATE Stock s
            SET s.quantity = s.quantity - :quantity
            WHERE s.store.id = :storeId
            AND s.productVariant.id = :variantId
            AND s.quantity >= :quantity
            """)
    int decrease(@Param("quantity") Long quantity,
                 @Param("variantId") Long variantId,
                 @Param("storeId") Long storeId);


    // UTILIZAR NO SERVICE DE PEDIDO QUANDO CANCELADO, OU REPOSIÇÃO DE ESTOQUE
    @Modifying(clearAutomatically = true)
    @Query("""
            UPDATE Stock s
            SET s.quantity = s.quantity + :quantity
            WHERE s.store.id = :storeId
            AND s.productVariant.id = :variantId
            """)
    int increase(@Param("storeId") Long storeId,
                 @Param("variantId") Long variantId,
                 @Param("quantity")Long quantity);
}



