package kurs.programowania.webaplikacji.myownappbackend.repositories;

import kurs.programowania.webaplikacji.myownappbackend.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByOwnerId(String userId);
    List<Product> findAllByForSale(boolean isForSale);
}
