package guru.springframework.services;


import guru.springframework.domain.Sepet;

public interface SepetService {
    Iterable<Sepet> listAllSepet();

    Sepet getSepetById(Integer id);

    Sepet saveSepet(Sepet product);
    
    void deleteCart(Integer id);
}
