package com.cahuete.fepolcompte.controller;

import javax.validation.Valid;

import com.cahuete.fepolcompte.auth.AuthRequest;
import com.cahuete.fepolcompte.auth.AuthResponse;
import com.cahuete.fepolcompte.component.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.cahuete.fepolcompte.entities.Participant;

@RestController
public class AuthApi {
    @Autowired JwtTokenUtil jwtUtil;
    @Autowired AuthenticationManager authManager;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            Participant participant = (Participant) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(participant);
            AuthResponse response = new AuthResponse(participant.getEmail(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
