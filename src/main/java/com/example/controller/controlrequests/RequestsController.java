package com.example.controller.controlrequests;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class RequestsController{   
    
    @GetMapping("/sensor-discoverer")  // #simulando consulta na plataforma via midval
    public static String SensorValueDiscoverer(){
        RestTemplate restTemplate = new RestTemplate();
        String endpointValida = "http://localhost:8080/midval/search-validate";  // para uso: plataforma define um endpoint de validação com acesso ao midval ex: http://10.10.10.104:8000/collector/valid_resources_data
        String responseValidData = restTemplate.getForObject(endpointValida, String.class);
        return "A situação do dado é: " + responseValidData; 
    
    }

    @GetMapping("/resources-data")   
    public static String getResourceData(){  // #simulando consulta no banco da plataforma e repassando dado para midlval #roundtrip
        RestTemplate restTemplate = new RestTemplate();
        String uuid = "9cf609af-3e7d-4bde-adad-f8b6f2dbe297"; 
        String endpointInterSCity = "http://10.10.10.104:8000/collector/resources/" + uuid + "/data";  
        String responseDataResource = restTemplate.getForObject(endpointInterSCity, String.class); 
        String endpointMidval = "http://localhost:8080/midval/validate";  
        HttpHeaders headers = new HttpHeaders(); 
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(responseDataResource, headers);  // enviando dado recuperado para validação
        ResponseEntity<String> responseValidation = restTemplate.postForEntity(endpointMidval, requestEntity, String.class); 
       return "O dado validado pronto para app a é igual a:" + responseValidation; 


    }

}