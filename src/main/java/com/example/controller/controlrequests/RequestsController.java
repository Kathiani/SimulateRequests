package com.example.controller.controlrequests;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestsController{   //*simulando método chamado pela plataforma para acesso a dados dos recursos
    
  
    @GetMapping("/resources_data")   
    public static void getResourceData(){
    //info = resource location or resource description valida = if data from resource needs to be validated; 
    String uuid = "9cf609af-3e7d-4bde-adad-f8b6f2dbe297"; //fixando uuid por enquanto
    String endpointInterSCity = "http://10.10.10.104:8000/catalog/resources/";  // Acessando dados da plataforma via http ao invés de instrumentar validador no DataCollector (resources_data)
    RestTemplate restTemplate = new RestTemplate();
    String responseDataResource = restTemplate.getForObject(endpointInterSCity, String.class); 

    String endpointValidation = "http://localhost:8080/midval/validate" + responseDataResource ; 
    String responseValidation = restTemplate.getForObject(endpointValidation, String.class); 
    //abrir conexão com midVal e passar o dado;
    //repassar dado pra app - essa informação você apresenta na tela;
    System.out.println(responseValidation);
    //System.out.println(endpointValidation);

    }

}