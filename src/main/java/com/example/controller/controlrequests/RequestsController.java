package com.example.controller.controlrequests;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestsController{
  
    @GetMapping("/resources_data")
    //simulando método chamado pela plataforma para acesso a dados dos recursos
    public static void getResourceData(){
    //info = resource location or resource description valida = if data from resource needs to be validated; 
    //repassa dados validação e retorna requisição com dados validados;
    //pode criar um espaço na base com dados já validados;
    String endpointUrl = "http://10.10.10.104:8000/catalog/resources/";  // Acessando dados da plataforma via http ao invés de instrumentar validador no DataCollector (resources_data)
    RestTemplate restTemplate = new RestTemplate();
    String responseErrorInjection = restTemplate.getForObject(endpointUrl, String.class); //Obter resposta com dados injetados	
    System.out.println(responseErrorInjection.toString());
    //abrir conexão com midVal e passar o dado;
    //repassar dado pra app - essa informação você apresenta na tela;


    }

}