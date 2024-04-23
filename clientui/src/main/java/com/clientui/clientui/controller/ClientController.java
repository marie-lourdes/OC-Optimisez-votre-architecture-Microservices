package com.clientui.clientui.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxies.MicroserviceProduitsProxy;

@Controller
public class ClientController {
   private final MicroserviceProduitsProxy produitsProxy;

   public ClientController(MicroserviceProduitsProxy produitsProxy){
       this.produitsProxy = produitsProxy;
   }

   @RequestMapping("/")
   public String accueil(Model model){
       List<ProductBean> produits =  produitsProxy.listeDesProduits();
       model.addAttribute("produits", produits);
       return "Accueil";
   }
}