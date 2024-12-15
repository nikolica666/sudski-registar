package hr.nik.sudr.web.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.security.oauth2.client.web.client.RequestAttributeClientRegistrationIdResolver.clientRegistrationId;

@Service
public class SudRegClient {

    private final RestClient restClient;

    public SudRegClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String callOAuthService(String resource) {
        return restClient.get()
                .uri(resource)
                .attributes(clientRegistrationId("sudreg"))
                .retrieve()
                .body(String.class);
    }

}