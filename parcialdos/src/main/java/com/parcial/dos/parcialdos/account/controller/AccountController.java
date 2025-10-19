package com.parcial.dos.parcialdos.account.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.parcial.dos.parcialdos.account.dto.AccountRequestDTO;
import com.parcial.dos.parcialdos.account.dto.AccountResponseDTO;
import com.parcial.dos.parcialdos.account.dto.AccountOwnerBalanceDTO;
import com.parcial.dos.parcialdos.account.service.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final IAccountService service;

    public AccountController(IAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> create(@RequestBody AccountRequestDTO request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getById(@PathVariable Long id) {
        AccountResponseDTO dto = service.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody AccountRequestDTO request) {
        String msg = service.update(id, request);
        if (msg.equals("Cuenta no encontrada"))
            return ResponseEntity.status(404).body(msg);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<AccountOwnerBalanceDTO> getByNumeroCuenta(@PathVariable String numeroCuenta) {
        AccountOwnerBalanceDTO dto = service.findByNumeroCuenta(numeroCuenta);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
