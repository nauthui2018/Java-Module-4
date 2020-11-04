package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private IProductService productService = new ProductService();

    @GetMapping("/")
    public String index(Model model) {
        List products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setCode((int)(Math.random() * 10000));
        productService.add(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{code}/edit")
    public String edit(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.selectById(code));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{code}/delete")
    public String delete(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.selectById(code));
        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{code}/view")
    public String view(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.selectById(code));
        return "/view";
    }
}