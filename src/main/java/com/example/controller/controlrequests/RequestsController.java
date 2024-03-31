package com.example.controller.controlrequests;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RequestsController{   
    
  
    @GetMapping("/resources_data")   
    public static void getResourceData(){  //*simulando função da InterScity: http://10.10.10.104:8000/collector/resources/
    //info = resource location or resource description valida = if data from resource needs to be validated; 

    RestTemplate restTemplate = new RestTemplate();
    String uuid = "9cf609af-3e7d-4bde-adad-f8b6f2dbe297"; // *fixando uuid por enquanto
    String endpointInterSCity = "http://10.10.10.104:8000/collector/resources/" + uuid + "/data";  // Acessando dados na plataforma via http ao invés de instrumentar validador no DataCollector (resources_data)
    String responseDataResource = restTemplate.getForObject(endpointInterSCity, String.class); 
    String endpointMidval = "http://localhost:8080/midval/validate";   // *codificar url devido a caracteres especiais;
  
    HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<String> requestEntity = new HttpEntity<>(responseDataResource, headers);
	ResponseEntity<String> responseValidation = restTemplate.postForEntity(endpointMidval, requestEntity, String.class); 
    //String responseValidation = restTemplate.getForObject(endpointMidval, String.class); 





    
    //abrir conexão com midVal e passar o dado;
    //repassar dado pra app - essa informação você apresenta na tela;
    //System.out.println(responseValidation);
    //System.out.println(responseValidation);

    }

}