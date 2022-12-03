package com.example.demo.controllers;

import com.example.demo.models.Categories;
import com.example.demo.models.Shop;
import com.example.demo.models.Subcategories;
import com.example.demo.repo.CategoriesRepository;
import com.example.demo.repo.SubcategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'PRODAVEC')")
public class CatyandsubcatyController {
    @Autowired
    public CategoriesRepository categoriesRepository;
    @Autowired
    public SubcategoriesRepository subcategoriesRepository;

    @GetMapping("/categories")
    public String Main(Model model){
        Iterable<Categories> categories = categoriesRepository.findAll();
        model.addAttribute("categories",categories);
        return "categories-add";
    }

    @PostMapping("/categories/add")
    public String blogPostAdd(@RequestParam String names, @RequestParam String name, Model model)
    {
        Categories categories = categoriesRepository.findByName(name);
        Subcategories subcategories = new Subcategories(names, categories);
        subcategoriesRepository.save(subcategories);
        return "redirect:/";
    }

    @GetMapping("/newcategories")
    public String newShop(Categories categories, Model model)
    {
        return "subcategories-add";
    }

    @PostMapping("/newcategories")
    public String shopPostAdd(@ModelAttribute("categories") @Valid Categories categories, BindingResult bindingResult,
                              Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "categories-add";
        }
        categoriesRepository.save(categories);
        return "redirect:/categoriesmain";
    }
    @GetMapping("/categoriesmain")
    public String shopMain(Model model)
    {
        Iterable<Categories> categories = categoriesRepository.findAll();
        model.addAttribute("categories", categories);
        return "subcategories-main";
    }
}
