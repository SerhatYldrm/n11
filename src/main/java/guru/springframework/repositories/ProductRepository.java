package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	Product findByTitle(String title);
	
	//List<Product> findByTitle(String title);
	
	List<Product> findBySubtitle(String subtitle);
	
	Product findByCategory(String category);
}
