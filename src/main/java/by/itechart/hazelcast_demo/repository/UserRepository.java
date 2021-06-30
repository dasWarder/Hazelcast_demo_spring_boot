package by.itechart.hazelcast_demo.repository;

import by.itechart.hazelcast_demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByAccountNumber(String accountNumber);

    UserAccount deleteByAccountNumber(String accountNumber);
}
