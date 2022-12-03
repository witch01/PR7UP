package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Product;
import com.example.demo.models.Shop;
import com.example.demo.models.Subcategories;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductinshopController {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/productshop")
    private String Main(Model model){
        Iterable<Shop> shops = shopRepository.findAll();
        model.addAttribute("shops", shops);
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "productshop";
    }

    @PostMapping("/productshop/add")
    public String blogPostAdd(@RequestParam Long product, @RequestParam Long shop, Model model)
    {
        Product product1 = productRepository.findById(product).orElseThrow();
        Shop shop1 = shopRepository.findById(shop).orElseThrow();
        product1.getShops().add(shop1);
        //university2.getStudents().add(student2);
        productRepository.save(product1);
        return "redirect:/productshop";
    }

    @PostMapping("univ/delProduct/{id_product}/{id_shop}")
    public String blogPostDell(@PathVariable Long id_product, @PathVariable Long id_shop, Model model)
    {
        Product product = productRepository.findById(id_product).orElseThrow();
        Shop shop = shopRepository.findById(id_shop).orElseThrow();
        product.getShops().remove(shop);
        productRepository.save(product);
        return "redirect:/productshop";
    }

    @PostMapping("/newshop")
    public String shopPostAdd(@ModelAttribute( "shop") @Valid Shop shop, BindingResult bindingResult,
                                  Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "shop-add";
        }
        shopRepository.save(shop);
        return "redirect:/shopmain";
    }
    @GetMapping("/shopmain")
    public String shopMain(Model model)
    {
        Iterable<Shop> shop = shopRepository.findAll();
        model.addAttribute("shop", shop);
        return "shop-main";
    }
    @GetMapping("/newshop")
    public String newShop(Shop shop,Model model)
    {
        return "shop-add";
    }
}
