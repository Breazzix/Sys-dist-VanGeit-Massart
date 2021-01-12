package io.HEPL.dossierFinalSysDist.controllers;

import io.HEPL.dossierFinalSysDist.models.Article;
import io.HEPL.dossierFinalSysDist.services.ArticleService;
import io.HEPL.dossierFinalSysDist.services.TvaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    private ArticleService productService;
    private TvaService tvaService;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public ArticleController(ArticleService productService, TvaService tvaService) {
        this.productService = productService;
        this.tvaService = tvaService;
    }

    @RequestMapping("/home")
    public String getAll(Model model) {

        List<Article> products = productService.getAll();
        model.addAttribute("products", products);

        return "home";

    }

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, Model model, HttpSession session) {

        Article p = productService.findById(id);

        if (session.getAttribute("prodsess") == null) {
            LinkedList<Article> cart = new LinkedList<Article>();
            int tva = tvaService.getTva(p.getCategory());
            float prixFinal = tvaService.round(p.getPrix()+(p.getPrix()*tva/100),2);
            Article article = new Article(p.getName(),prixFinal,tva);
            cart.add(article);
            session.setAttribute("prodsess", cart);
            model.addAttribute("cart", cart);
            Float sum = Float.valueOf(0);
            for (int i=0;i<cart.size();i++) {
                sum += cart.get(i).getPrix();
            }
            sum = tvaService.round(sum,2);
            model.addAttribute("sum", sum);
        } else {
            LinkedList<Article> cart = (LinkedList<Article>) session.getAttribute("prodsess");
            int tva = tvaService.getTva(p.getCategory());
            float prixFinal = tvaService.round(p.getPrix()+(p.getPrix()*tva/100),2);
            Article article = new Article(p.getName(),prixFinal,tva);
            cart.add(article);
            session.setAttribute("prodsess", cart);
            model.addAttribute("cart", cart);
            Float sum = Float.valueOf(0);
            for (int i=0;i<cart.size();i++) {
                sum += cart.get(i).getPrix();
            }
            sum = tvaService.round(sum,2);
            model.addAttribute("sum", sum);

        }
        return "cart";
    }

    @RequestMapping("/cart")
    public String cart(HttpSession session, Model model) {

        LinkedList<Article> cart = (LinkedList<Article>) session.getAttribute("prodsess");
        model.addAttribute("cart", cart);
        Float sum = Float.valueOf(0);
        for (int i=0;i<cart.size();i++) {
            sum += cart.get(i).getPrix();
        }
        model.addAttribute("sum", sum);
        return "cart";
    }

    @RequestMapping("/delete")
    public String deleteFromCart(@RequestParam("key") String key, HttpSession session, Model model) {

        LinkedList<Article> cart = (LinkedList<Article>) session.getAttribute("prodsess");
        for (int i=0;i<cart.size();i++)
        {
            if (cart.get(i).getName().equals(key))
                cart.remove(i);
        }
        Float sum = Float.valueOf(0);

        for (int i=0;i<cart.size();i++) {
            sum += cart.get(i).getPrix();
        }

        session.setAttribute("prodsess", cart);
        model.addAttribute("cart", cart);
        model.addAttribute("sum", sum);
        return "redirect:/cart";
    }


    @RequestMapping("/searchProduct")
    public String search(@RequestParam("name") String name,Model model){


        Article product = productService.findByName(name);

        model.addAttribute("product",product);

        return "product-info";
    }
}
