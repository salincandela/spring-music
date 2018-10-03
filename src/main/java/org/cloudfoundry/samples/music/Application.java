package org.cloudfoundry.samples.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableOAuth2Sso
public class Application {

    public static void main(String[] args) {
        SSLValidationDisabler.disableSSLValidation();
        SpringApplication.run(Application.class, args);
    }
}
