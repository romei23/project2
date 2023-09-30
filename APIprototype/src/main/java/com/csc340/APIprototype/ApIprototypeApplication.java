package com.csc340.APIprototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApIprototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApIprototypeApplication.class, args);
                inspirationQuote();
                System.exit(0);
	}
        
         public static void inspirationQuote() {
        try {
            String url = "https://api.quotable.io/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);

            //gets coin name
            String content = root.findValue("content").asText();
            String author = root.findValue("author").asText();

            //gets coin value in USD
            //double coinPrice = root.findValue("price_usd").asDouble();
            //print vals
            System.out.println("Content: " + content);
            System.out.println("Author: " + author);

        } catch (JsonProcessingException ex) {
            System.out.println("error in inspirationQuote");
        }
    }

}
