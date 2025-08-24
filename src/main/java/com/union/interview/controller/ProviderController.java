package com.union.interview.controller;

import com.union.interview.dto.request.UpdateStatusRequest;
import com.union.interview.service.ProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/providers")
@Validated
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PutMapping("/{ico}/status")
    public ResponseEntity<String> updateStatus(@PathVariable String ico, @Valid @RequestBody UpdateStatusRequest req) 
    {
        providerService.updateProviderStatus(ico, req.status());
        return ResponseEntity.ok("Provider status updated");
    }
}
