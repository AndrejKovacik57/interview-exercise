package com.union.interview.controller;

import com.union.interview.dto.request.CreateContractRequest;
import com.union.interview.dto.response.ContractResponse;
import com.union.interview.service.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/providers/contracts")
@Validated
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    public ResponseEntity<ContractResponse> create(@Valid @RequestBody CreateContractRequest req) {
        ContractResponse created = contractService.createContract(req);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponse> get(@PathVariable Long id) {
        ContractResponse out = contractService.getContract(id);
        return ResponseEntity.ok(out);
    }
}
