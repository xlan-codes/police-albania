package com.vesa.wazeapi.controllers;

import com.vesa.wazeapi.model.JwtRequest;

import com.vesa.wazeapi.model.JwtResponse;
import com.vesa.wazeapi.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AuthController {

    public static final String BASE_BASE_CONTROLLER = "/auth";

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @RequestMapping(value = AuthController.BASE_BASE_CONTROLLER, method = RequestMethod.POST)
    public ResponseEntity auth(@RequestBody JwtRequest authenticationRequest) throws Exception {


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid email/password");
        }

        final String token = jwtUtil.generateToken(authenticationRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = AuthController.BASE_BASE_CONTROLLER + "/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<?> refreshToken(HttpServletRequest request) throws Exception {
        String t[] = request.getHeader("Authorization").split(" ");
        DefaultClaims claims = (DefaultClaims) jwtUtil.extractAllClaims(t[1]);

        Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
        String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }

}
