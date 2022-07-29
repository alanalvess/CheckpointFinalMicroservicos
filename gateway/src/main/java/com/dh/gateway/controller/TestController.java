package com.dh.gateway.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class TestController {

    @GetMapping
    public Map<String, Object> info(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, Authentication auth) {
        Map<String, Object> response = new HashMap<>();
        response.put("clientName", authorizedClient.getClientRegistration().getClientName());
        response.put("accessToken", authorizedClient.getAccessToken());
        response.put("authName", auth.getDetails());
        return response;
    }
}
