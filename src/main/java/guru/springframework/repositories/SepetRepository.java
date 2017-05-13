package guru.springframework.repositories;

import guru.springframework.domain.Sepet;
import org.springframework.data.repository.CrudRepository;

public interface SepetRepository extends CrudRepository<Sepet, Integer>{
	
}
