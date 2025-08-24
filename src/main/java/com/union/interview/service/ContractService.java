package com.union.interview.service;

import com.union.interview.domain.Status;
import com.union.interview.dto.request.CreateContractRequest;
import com.union.interview.dto.response.ContractResponse;
import com.union.interview.entity.ContractEntity;
import com.union.interview.entity.ProviderEntity;
import com.union.interview.entity.ServiceEntity;
import com.union.interview.repository.ContractRepository;
import com.union.interview.repository.ProviderRepository;
import com.union.interview.repository.ServiceRepository;
import com.union.interview.exception.NotFoundException;
import com.union.interview.mapper.ContractMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ProviderRepository providerRepo;
    private final ServiceRepository serviceRepo;
    private final ContractRepository contractRepo;

    private final ContractMapper contractMapper;

    @Transactional
    public ContractResponse createContract(CreateContractRequest req) {
        ProviderEntity provider = providerRepo.findByIco(req.providerIco())
                .orElseThrow(() -> new NotFoundException("Provider not found: " + req.providerIco()));

        ServiceEntity service = serviceRepo.findByCode(req.serviceCode())
                .orElseThrow(() -> new NotFoundException("Service not found: " + req.serviceCode()));

        BigDecimal total = service.getUnitPrice().multiply(BigDecimal.valueOf(req.quantity()));

        ContractEntity contract = new ContractEntity(provider, service, req.quantity(), total, Status.ACTIVE);
        ContractEntity saved = contractRepo.save(contract);

        ContractResponse response = contractMapper.toDto(saved);


        return response;
    }

    @Transactional
    public ContractResponse getContract(Long id) {
        ContractEntity contract = contractRepo.findById(id)
        .orElseThrow(() -> new NotFoundException("Contract not found: " + id));;
       
        ContractResponse response = contractMapper.toDto(contract);
        return response;
    }
}
