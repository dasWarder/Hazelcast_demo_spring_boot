package by.itechart.hazelcast_demo;

import by.itechart.hazelcast_demo.model.UserAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HazelcastDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastDemoApplication.class, args);
    }


    @Bean
    public Map<String, UserAccount> accountMap() {
        return new HashMap<>();
    }

}
