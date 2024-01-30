package com.csc340.API.Prototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPrototypeApplication.class, args);
                
                getAnimeFact();
                System.exit(0);
	}
        
        public static void getAnimeFact() {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "https://animechan.xyz/api/random";
                ObjectMapper mapper = new ObjectMapper();

                String jSonFact = restTemplate.getForObject(url, String.class);
                JsonNode root = mapper.readTree(jSonFact);

                String anime = root.findValue("anime").asText();
                String character = root.findValue("character").asText();
                String quote = root.findValue("quote").asText();
                
                System.out.println("Anime: " + anime);
                System.out.println("Character: " + character);
                System.out.println("Quote: " + quote);
                
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ApiPrototypeApplication.class.getName()).log(
                    Level.SEVERE, 
                    null, ex);
            System.out.println("error in getCatFact");

        }
        }

}
