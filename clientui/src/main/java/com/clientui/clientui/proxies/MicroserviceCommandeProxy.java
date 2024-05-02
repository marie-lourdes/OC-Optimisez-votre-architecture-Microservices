package com.clientui.clientui.proxies;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.beans.CommandeBean;

@FeignClient(name = "zuul-server",qualifiers="MicroserviceCommandeProxy")
@RibbonClient(name = "microservice-commandes")
public interface MicroserviceCommandeProxy {

	@PostMapping(value = "/microservice-commandes/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
    
	@GetMapping(value = "/microservice-commandes/commandes")
    String recupererHomePage();
}
