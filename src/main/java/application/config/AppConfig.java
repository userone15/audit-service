/**
 * 
 */
package application.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author SENTHILKUMAR S
 *
 */
@Configuration
@ComponentScan(basePackages = "application.*")
@EnableTransactionManagement
public class AppConfig {
	@Bean
	@ConfigurationProperties(prefix = "audit.datasource")
	public DataSource productServiceDS() {
		return DataSourceBuilder.create().build();
	}
}
