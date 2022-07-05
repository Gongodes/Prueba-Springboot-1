package cl.gonzalo.app.service.impl;

import cl.gonzalo.app.model.Results;
import cl.gonzalo.app.service.IApiService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ApiServiceImpl implements IApiService {


    @Override
    public Results getCharacters() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .exchange("https://rickandmortyapi.com/api/character", HttpMethod.GET, entity, Results.class)
                .getBody();
    }
}
