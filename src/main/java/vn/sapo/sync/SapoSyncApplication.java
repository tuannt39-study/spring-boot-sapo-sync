package vn.sapo.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import vn.sapo.sync.config.SapoProperties;

@SpringBootApplication
@EnableConfigurationProperties({SapoProperties.class})
public class SapoSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapoSyncApplication.class, args);
    }

}
