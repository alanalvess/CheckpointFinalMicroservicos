package com.alanalves.apigateway.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class TestController {

    @GetMapping
    public Mono<Map<String, Object>> info(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
            @AuthenticationPrincipal OAuth2User oauth2User
    ) {

        Map<String, Object> response = new HashMap<>();
        response.put("clientName", authorizedClient.getClientRegistration().getClientName());
        response.put("accessToken", authorizedClient.getAccessToken().getTokenValue());
        response.put("userName", oauth2User.getName());
        response.put("attributes", oauth2User.getAttributes());

        return Mono.just(response);
    }
}

