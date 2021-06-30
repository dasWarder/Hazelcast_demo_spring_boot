package by.itechart.hazelcast_demo;

import by.itechart.hazelcast_demo.model.UserAccount;
import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class HazelcastDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastDemoApplication.class, args);
    }


    @Bean
    public Config hazelCastConfig() {
        return new Config().setManagementCenterConfig(
                                            new ManagementCenterConfig());
    }

    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
        return Hazelcast.newHazelcastInstance(hazelCastConfig);
    }

    @Bean
    public Map<String, UserAccount> accountMap(HazelcastInstance instance) {
        return instance.getMap("accountMap");
    }

}
