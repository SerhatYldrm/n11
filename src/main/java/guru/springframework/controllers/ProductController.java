package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

import guru.springframework.domain.Sepet;
import guru.springframework.services.SepetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;
    private SepetService sepetService;
    
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setSepetService(SepetService sepetService) {
        this.sepetService = sepetService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning rpoducts:");
        return "products";
    }
    
    @RequestMapping(value = "/consumerProducts", method = RequestMethod.GET)
    public String listProductToConsumer(Model model){
    	
       
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning rpoducts:");
        return "consumer";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }
    

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }
    
    @RequestMapping("consumerProducts/sepeteEkle/{id}")
    public String addCart(@PathVariable Integer id,Model model,Model model1){
    	
    	Sepet cart = new Sepet();
    	Product product = new Product();
    	
    	product = productService.getProductById(id);
    	
    	cart.setTitle(product.getTitle());
    	cart.setSubtitle(product.getSubtitle());
    	cart.setDisprice(product.getDisprice());
    	cart.setCategory(product.getCategory());
    	cart.setPrice(product.getPrice());
    	
    	
    	
    	
    	sepetService.saveSepet(cart);
    	model.addAttribute("sepetElements", sepetService.listAllSepet());
        model.addAttribute("products", productService.listAllProducts());
    	
        return "consumer";
    }
    
    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public String viewChart(Model model){
    	
    	model.addAttribute("sepetElements", sepetService.listAllSepet());
    	
        return "cart";
    }

    
    
    @RequestMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }
    
    @RequestMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model){
    	
    	productService.deleteProduct(id);
    	model.addAttribute("products", productService.listAllProducts());
    	return "products";
    }
    
    @RequestMapping("product/search/{name}")
    public String searchProduct(@PathVariable String name, Model model){
    	
    	model.addAttribute("products", productService.listAllProducts());
    	return "products";
    }
    

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){

        productService.saveProduct(product);

        return "redirect:/product/" + product.getId();
    }

}
