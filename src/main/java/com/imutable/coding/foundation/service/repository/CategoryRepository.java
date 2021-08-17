package com.imutable.coding.foundation.service.repository;



import com.imutable.coding.foundation.service.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category,Long> {
}
