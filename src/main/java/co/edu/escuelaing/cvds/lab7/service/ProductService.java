package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void createProduct(Long ID, String NAME, String DESCRIPTION, String CATEGORY, String RATING, String PRICE, String QUANTITY){
        Product product = new Product(ID, NAME,DESCRIPTION,CATEGORY,RATING,PRICE,QUANTITY);
        //productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void updateProduct(Long ID, String NAME,String DESCRIPTION,String CATEGORY,String RATING,String PRICE, String QUANTITY) {
        Product product = productRepository.findById(ID).orElse(null);
        if (product != null) {
            product.setNAME(!NAME.isEmpty() ? NAME : product.getNAME());
            product.setDESCRIPTION(!DESCRIPTION.isEmpty() ? DESCRIPTION : product.getDESCRIPTION());
            product.setCATEGORY(!CATEGORY.isEmpty() ? CATEGORY : product.getCATEGORY());
            product.setRATING(!RATING.isEmpty() ? RATING : product.getRATING());
            product.setPRICE(!PRICE.isEmpty() ? PRICE : product.getPRICE());
            product.setQUANTITY(!QUANTITY.isEmpty() ? QUANTITY : product.getQUANTITY());

            productRepository.save(product);
        }
    }
    public Product getProductById(Long ID) {
        return productRepository.findById(ID).orElse(null);
    }


    public void deleteProduct(Long ID) {
        productRepository.deleteById(ID);
    }




}
