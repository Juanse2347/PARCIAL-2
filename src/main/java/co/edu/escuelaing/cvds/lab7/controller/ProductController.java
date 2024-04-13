package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import co.edu.escuelaing.cvds.lab7.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("api/product")
    @ResponseBody
    public List<Product> productsApi(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return productList;
    }
    @GetMapping("api/products/{ID}")
    @ResponseBody
    public Product getProductById(@PathVariable Long ID) {
        return productService.getProductById(ID);
    }
    @GetMapping("api/products/main")
    public String products(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "products";
    }
    @PostMapping("api/products")
    @ResponseBody
    public List<Product> createProduct(@RequestBody Product request){
        ProductService.createProduct(request.getID(), request.getNAME(),
                request.getDESCRIPTION(), request.getCATEGORY(), request.getRATING(), request.getPRICE(), request.getQUANTITY());
        return productService.getAll();
    }

    @PutMapping("api/products/{ID}")
    @ResponseBody
    public List<Product> updateProduct(@PathVariable Long ID,@RequestBody Product request){
        productService.updateProduct(ID, request.getNAME(),
                request.getDESCRIPTION(), request.getCATEGORY(), request.getRATING(), request.getPRICE(), request.getQUANTITY());
        return productService.getAll();
    }

    @DeleteMapping("/api/products/{ID}")
    @ResponseBody
    public List<Product> deleteProduct(@PathVariable Long ID) {
        productService.deleteProduct(ID);
        return productService.getAll();
    }


}
