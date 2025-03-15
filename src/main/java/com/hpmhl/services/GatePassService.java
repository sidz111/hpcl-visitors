package com.hpmhl.services;


import com.hpmhl.entities.GatePass;
import java.util.List;
import java.util.Optional;

public interface GatePassService {
    
    GatePass createGatePass(GatePass gatePass);
    
    GatePass updateGatePass(Integer id, GatePass gatePass);
    
    void deleteGatePass(Integer id);
    
    Optional<GatePass> getGatePassById(Integer id);
    
    Optional<GatePass> getGatePassByVisitorId(Integer visitorId);
    
    GatePass getGatePassByVisitorFullName(String fullName);
    
    List<GatePass> getAllGatePasses();
}
