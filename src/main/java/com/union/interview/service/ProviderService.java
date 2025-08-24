package com.union.interview.service;

import com.union.interview.domain.Status;
import com.union.interview.entity.ProviderEntity;
import com.union.interview.exception.NotFoundException;
import com.union.interview.repository.ProviderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepo;

    @Transactional
    public void updateProviderStatus(String ico, Status newStatus) {
        ProviderEntity provider = providerRepo.findByIco(ico)
            .orElseThrow(() -> new NotFoundException("Provider not found: " + ico));

        provider.setStatus(newStatus);
        providerRepo.save(provider);
    }
}
