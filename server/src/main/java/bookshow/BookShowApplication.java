package bookshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import bookshow.domain.users.User;
import bookshow.service.UserService;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class BookShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShowApplication.class, args);
		
    }
}
