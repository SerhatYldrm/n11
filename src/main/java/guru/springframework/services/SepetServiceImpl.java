package guru.springframework.services;

import guru.springframework.domain.Sepet;
import guru.springframework.repositories.SepetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SepetServiceImpl implements SepetService {
    private SepetRepository sepetRepository;

    @Autowired
    public void setSepetRepository(SepetRepository sepetRepository) {
        this.sepetRepository = sepetRepository;
    }

    @Override
    public Iterable<Sepet> listAllSepet() {
        return sepetRepository.findAll();
    }

    @Override
    public Sepet getSepetById(Integer id) {
        return sepetRepository.findOne(id);
    }

    @Override
    public Sepet saveSepet(Sepet sepet) {
        return sepetRepository.save(sepet);
    }
    
    @Override
	public void deleteCart(Integer id) {
		sepetRepository.delete(id);
	}
    
    
}
