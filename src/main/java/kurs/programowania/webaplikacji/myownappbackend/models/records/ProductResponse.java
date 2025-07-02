package kurs.programowania.webaplikacji.myownappbackend.models.records;

import kurs.programowania.webaplikacji.myownappbackend.models.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(
    String id,
    String name,
    String description,
    BigDecimal price,
    Boolean forSale,
    LocalDateTime createdAt
) {
    public ProductResponse(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.isForSale(), product.getCreatedAt());
    }
}
