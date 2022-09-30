package namoo.springcore.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * 
 * @author Administrator
 *
 */

@Configuration
@ComponentScan(
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

public class AppConfig2 {
	
}
