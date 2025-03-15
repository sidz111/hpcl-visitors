package com.hpmhl.services.impl;

import com.hpmhl.entities.GatePass;
import com.hpmhl.repositories.GatePassRepository;
import com.hpmhl.services.GatePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatePassServiceImpl implements GatePassService {

    @Autowired
    private GatePassRepository gatePassRepository;

    @Override
    public GatePass createGatePass(GatePass gatePass) {
        return gatePassRepository.save(gatePass);
    }

    @Override
    public GatePass updateGatePass(Integer id, GatePass updatedGatePass) {
        Optional<GatePass> existingGatePass = gatePassRepository.findById(id);
        if (existingGatePass.isPresent()) {
            GatePass gatePass = existingGatePass.get();
            gatePass.setGatePassNumber(updatedGatePass.getGatePassNumber());
            gatePass.setVisitor(updatedGatePass.getVisitor());
            return gatePassRepository.save(gatePass);
        }
        return null;
    }

    @Override
    public void deleteGatePass(Integer id) {
        gatePassRepository.deleteById(id);
    }

    @Override
    public Optional<GatePass> getGatePassById(Integer id) {
        return gatePassRepository.findById(id);
    }

    @Override
    public Optional<GatePass> getGatePassByVisitorId(Integer visitorId) {
        return gatePassRepository.findById(visitorId);
    }

    @Override
    public GatePass getGatePassByVisitorFullName(String fullName) {
        return gatePassRepository.findByVisitor_FullName(fullName);
    }

    @Override
    public List<GatePass> getAllGatePasses() {
        return gatePassRepository.findAll();
    }
}
