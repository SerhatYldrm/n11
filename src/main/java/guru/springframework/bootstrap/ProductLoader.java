package guru.springframework.bootstrap;

import guru.springframework.domain.Product;

import guru.springframework.repositories.ProductRepository;
import guru.springframework.repositories.SepetRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import guru.springframework.domain.Sepet;
@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private SepetRepository sepetRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Autowired
    public void setSepetRepository(SepetRepository sepetRepository) {
        this.sepetRepository = sepetRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setTitle("n11");
        shirt.setSubtitle("Yazılım11");
        shirt.setCategory("Talent11");
        shirt.setDisprice(new BigDecimal("11"));
        shirt.setPrice(new BigDecimal("11.11"));
        shirt.setImageUrl("http://cdn1.n11.com.tr/a1/640/14/10/22/47/31/34/38/90/17/22/43/09/86661490663078673558.jpg");
        shirt.setProductId("11");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        
        
        
        Product mug = new Product();
        mug.setTitle("Noksanlar");
        mug.setSubtitle("TalentHub");
        mug.setCategory("category11");
        mug.setDisprice(new BigDecimal("11"));
        mug.setPrice(new BigDecimal("11.11"));
        mug.setImageUrl("http://www.meetingsevents.com.au/kualalumpur/wp-content/uploads/2013/11/Grand_Hyatt_logo.jpg");
        mug.setProductId("11");
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
        
        Product mugg = new Product();
        mugg.setTitle("Iphone");
        mugg.setSubtitle("6s");
        mugg.setCategory("Telefon");
        mugg.setDisprice(new BigDecimal("20"));
        mugg.setPrice(new BigDecimal("3500"));
        mugg.setImageUrl("https://www.o2.co.uk/shop/homepage/images/shop15/brand/apple/iphone-6s/apple-iphone-6s-2016-ios-ios-10-gallery-img-5-101016.jpg");
        mugg.setProductId("10");
        productRepository.save(mugg);
        
        Product muggg = new Product();
        muggg.setTitle("Asus");
        muggg.setSubtitle("N111");
        muggg.setCategory("Dizüstü");
        muggg.setDisprice(new BigDecimal("10"));
        muggg.setPrice(new BigDecimal("5600"));
        muggg.setImageUrl("http://img05-us1.uitoximg.com/A/show/AW000706/2015/1023/AM0009749/201510AM230009749_14455645594870230027903.jpg!t360x360");
        muggg.setProductId("12");
        productRepository.save(muggg);

    }
}
