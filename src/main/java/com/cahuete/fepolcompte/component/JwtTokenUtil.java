package com.cahuete.fepolcompte.component;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.cahuete.fepolcompte.entities.Participant;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

    //Le jeton est signé à l’aide d’une clé secrète, spécifiée dans le fichier application.properties
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    /**
     * génère un jeton d’accès basé sur un objet Participant donné
     * @param participant
     * @return
     */
    public String generateAccessToken(Participant participant) {
        return Jwts.builder()
                // L’objet est une combinaison de l’ID de l’utilisateur et de l’e-mail, séparés par une virgule.
                .setSubject(String.format("%s, %s", participant.getId(), participant.getEmail()))
                // Le nom de l'emetteur est Cahuete
                .setIssuer("Cahuete")
                .setIssuedAt(new Date())
                // Le jeton est émis à la date et à l’heure actuelles + Le jeton doit expirer après 24 heures
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                // La clé secrète est spécifiée dans le fichier application.properties
                // grâce à la variable d'environnement "SECRET_KEY"
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }
}
