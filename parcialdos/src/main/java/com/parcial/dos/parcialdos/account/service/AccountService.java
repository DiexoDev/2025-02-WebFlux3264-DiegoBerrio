package com.parcial.dos.parcialdos.account.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.parcial.dos.parcialdos.account.dto.AccountOwnerBalanceDTO;
import com.parcial.dos.parcialdos.account.dto.AccountRequestDTO;
import com.parcial.dos.parcialdos.account.dto.AccountResponseDTO;
import com.parcial.dos.parcialdos.account.entity.Account;
import com.parcial.dos.parcialdos.account.repository.AccountRepository;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountResponseDTO create(AccountRequestDTO request) {
        Account account = Account.builder()
                .accountNumber(request.getNumeroCuenta())
                .ownerName(request.getDuenoCuenta())
                .balance(request.getBalanceActual())
                .active(true)
                .build();
        Account cuentaGuardada = repository.save(account);
        return toResponseDTO(cuentaGuardada);
    }

    @Override
    public List<AccountResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public AccountResponseDTO getById(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    @Override
    public String update(Long id, AccountRequestDTO request) {
        return repository.findById(id).map(account -> {
            BigDecimal balanceAnterior = account.getBalance();
            account.setBalance(request.getBalanceActual());
            repository.save(account);
            return "La cuenta " + account.getAccountNumber() + " fue actualizada: balanceAnterior=" + balanceAnterior
                    + ", balanceActual=" + request.getBalanceActual();
        }).orElse("Cuenta no encontrada");
    }

    @Override
    public void delete(Long id) {
       repository.deleteById(id);
    }

    @Override
    public AccountOwnerBalanceDTO findByNumeroCuenta(String numeroCuenta) {
        return repository.findByNumeroCuenta(numeroCuenta)
                .map(acc -> new AccountOwnerBalanceDTO(acc.getOwnerName(), acc.getBalance()))
                .orElse(null);
    }

    private AccountResponseDTO toResponseDTO(Account acc) {
        return AccountResponseDTO.builder()
                .id(acc.getId())
                .numeroCuenta(acc.getAccountNumber())
                .dueno(acc.getOwnerName())
                .balanceActual(acc.getBalance())
                .active(acc.getActive())
                .build();
    }

}
