package by.itechart.hazelcast_demo.repository;

import by.itechart.hazelcast_demo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByAccountNumber(String accountNumber);

    @Transactional
    UserAccount deleteByAccountNumber(String accountNumber);
}
