package by.itechart.hazelcast_demo.controller;


import by.itechart.hazelcast_demo.model.UserAccount;
import by.itechart.hazelcast_demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    private Map<String, UserAccount> accountMap;

    public UserController(UserRepository userRepository, Map<String, UserAccount> accountMap) {
        this.userRepository = userRepository;
        this.accountMap = accountMap;
    }


    @GetMapping("/user/{accountNumber}")
    public ResponseEntity<UserAccount> getUserByAccountNumber(@PathVariable("accountNumber")
                                                                            String accountNumber) {

        log.info("Get request from a client to receive a user by account number = {}",
                                                                                      accountNumber);

        UserAccount userByAccountNumber = null;

        userByAccountNumber = accountMap.containsKey(accountNumber)?
                                                                    accountMap.get(accountNumber) :
                                                                    userRepository.findByAccountNumber(accountNumber);

        return new ResponseEntity<>(userByAccountNumber, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserAccount> createUser(@RequestBody
                                                              UserAccount userAccount) {

        log.info("Post request from a client to store a new user");

        accountMap.put(userAccount.getAccountNumber(), userAccount);
        UserAccount storedUser = userRepository.save(userAccount);

        return new ResponseEntity<>(storedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{accountNumber}")
    public ResponseEntity<UserAccount> deleteUserByAccountNumber(@PathVariable("accountNumber")
                                                                          String accountNumber) {

        log.info("Delete request from a client to remove a user with account number = {}",
                                                                                          accountNumber);

        accountMap.remove(accountNumber);
        UserAccount removedUser = userRepository.deleteByAccountNumber(accountNumber);

        return new ResponseEntity<>(removedUser, HttpStatus.OK);
    }

}
