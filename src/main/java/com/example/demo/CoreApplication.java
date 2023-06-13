package com.example.demo;

// import java.util.Timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// import com.example.demo.repository.DataExtractor;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.repository", "com.example.demo.service"})
@EnableJpaRepositories(basePackages = {"com.example.demo.model"})
public class CoreApplication {
	
//	private static final int INTERVAL = 24 * 60 * 60 * 1000; // 24 ore in millisecondi
	
//	@Bean(name = "entityManagerFactory")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
//	        EntityManagerFactoryBuilder builder,
//	        @Qualifier("dataSource") DataSource dataSource) {
//	    return builder
//	            .dataSource(dataSource)
//	            .packages("com.example.demo.model")
//	            .persistenceUnit("persistenceUnitName")
//	            .build();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//	    return DataSourceBuilder.create().build();
//	}

	
	public static void main(String args[]) {
		SpringApplication.run(CoreApplication.class, args);
	   /* DataExtractor d = new DataExtractor();
	    d.run();
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new DataExtractor(), 0, INTERVAL); */
	}
}