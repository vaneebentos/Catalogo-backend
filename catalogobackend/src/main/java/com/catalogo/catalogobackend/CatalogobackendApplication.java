package com.catalogo.catalogobackend;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class CatalogobackendApplication {

        public static void main(String[] args) {
                SpringApplication.run(CatalogobackendApplication.class, args);

        }

       /**
        * Esta función crea un Corsfilter en Java que permite solicitudes de origen cruzado de
        * http: // localhost: 4200 y establece los encabezados permitidos, encabezados expuestos y métodos permitidos.
        *
        * @return El código está devolviendo un objeto Corsfilter.
        */
        @Bean

        public CorsFilter corsFilter() {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.setAllowCredentials(true);

                corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
                corsConfiguration.setAllowedHeaders(
                                Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                                                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                                                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
                corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
                                "Access-Control-Allow-Credentials"));
                corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
                urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
                return new CorsFilter(urlBasedCorsConfigurationSource);

        }

}
