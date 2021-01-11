package io.HEPL.dossierFinalSysDist;

import io.HEPL.dossierFinalSysDist.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DossierFinalSysDistApplication {

	public static void main(String[] args) {
		SpringApplication.run(DossierFinalSysDistApplication.class, args);
	}

}
