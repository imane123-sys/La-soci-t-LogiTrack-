package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProduitService;

@RestController
@RequestMapping("api/produits")

public class ProduitController {
    @Autowired
    ProduitService produitService;



}
