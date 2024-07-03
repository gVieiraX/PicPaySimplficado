package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AuthorizationService authService;

    @Autowired
    private NotificationServices notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User payer = this.userService.findUserById(transaction.payerID());
        User payee = this.userService.findUserById(transaction.payeeID());

        userService.validateTransaction(payer, transaction.value());

        boolean isAuthorized = this.authService.authorizeTransaction(payer, transaction.value());
        if(!isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setPayer(payer);
        newTransaction.setPayee(payee);
        newTransaction.setTimestamp(LocalDateTime.now());

        payer.setBalance(payer.getBalance().subtract(transaction.value()));
        payee.setBalance(payee.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.saveUser(payer);
        this.userService.saveUser(payee);

        this.notificationService.sendNotification(payer, "Transação realizada com sucesso");
        this.notificationService.sendNotification(payee, "Transação recebida com sucesso");

        return newTransaction;
    }
}