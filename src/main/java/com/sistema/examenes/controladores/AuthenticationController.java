package com.sistema.examenes.controladores;

import com.sistema.examenes.configuraciones.JwtUtils;
import com.sistema.examenes.entidades.JwtRequest;
import com.sistema.examenes.entidades.JwtResponse;
import com.sistema.examenes.servicios.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
            System.out.println("Authentication successful for user: " + jwtRequest.getUsername());

        } catch (Exception exception) {
            System.out.println("Authentication failed: " + exception.getMessage());

            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        System.out.println("User details loaded for: " + userDetails.getUsername());

        String token = this.jwtUtils.generateToken(userDetails);
        System.out.println("Token generated successfully");

        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void autenticar (String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw new Exception("Usuario Deshabilitado" + disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("Credenciales invalidas" + badCredentialsException.getMessage());
        }
    }

}
