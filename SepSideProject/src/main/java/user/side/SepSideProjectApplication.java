package user.side;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class SepSideProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SepSideProjectApplication.class, args);
	}
	
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() { //PUT 어노테이션 사용 할 수 있게 해주는거
		return new HiddenHttpMethodFilter();
	}

}
