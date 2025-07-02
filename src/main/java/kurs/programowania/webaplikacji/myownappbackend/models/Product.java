package kurs.programowania.webaplikacji.myownappbackend.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean forSale;
    private String ownerId;
    @Field("creationTime")
    private LocalDateTime createdAt;

    public Product(String name, String description, BigDecimal price, boolean forSale, String ownerId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.forSale = forSale;
        this.ownerId = ownerId;
        this.createdAt = LocalDateTime.now();
    }

}
