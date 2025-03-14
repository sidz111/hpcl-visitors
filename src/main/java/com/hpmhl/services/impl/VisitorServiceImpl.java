package com.hpmhl.services.impl;

import com.hpmhl.entities.Visitor;
import com.hpmhl.repositories.VisitorRepository;
import com.hpmhl.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public Visitor saveVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor updateVisitor(Integer id, Visitor visitor) {
        Optional<Visitor> existingVisitor = visitorRepository.findById(id);
        if (existingVisitor.isPresent()) {
            Visitor updatedVisitor = existingVisitor.get();
            updatedVisitor.setTokenNo(visitor.getTokenNo());
            updatedVisitor.setSrno(visitor.getSrno());
            updatedVisitor.setAadharNo(visitor.getAadharNo());
            updatedVisitor.setFullName(visitor.getFullName());
            updatedVisitor.setMobileNo(visitor.getMobileNo());
            updatedVisitor.setAddress(visitor.getAddress());
            updatedVisitor.setToSeeWhom(visitor.getToSeeWhom());
            updatedVisitor.setPurposeToVisit(visitor.getPurposeToVisit());
            updatedVisitor.setIsRegular(visitor.getIsRegular());
            updatedVisitor.setDate(visitor.getDate());
            updatedVisitor.setWorkingAs(visitor.getWorkingAs());
            updatedVisitor.setPhoto(visitor.getPhoto());
            updatedVisitor.setIdPhoto(visitor.getIdPhoto());
            updatedVisitor.setQrCodeValue(visitor.getQrCodeValue());
            updatedVisitor.setQrpath(visitor.getQrpath());
            updatedVisitor.setTimeIn(visitor.getTimeIn());
            updatedVisitor.setTimeOut(visitor.getTimeOut());
            updatedVisitor.setRestricted(visitor.getRestricted());
            updatedVisitor.setAccess(visitor.getAccess());
            return visitorRepository.save(updatedVisitor);
        } else {
            throw new RuntimeException("Visitor not found with ID: " + id);
        }
    }

    @Override
    public Visitor getVisitorById(Integer id) {
        return visitorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public void deleteVisitor(Integer id) {
        visitorRepository.deleteById(id);
    }

    @Override
    public Optional<Visitor> findByTokenNo(Integer tokenNo) {
        return Optional.ofNullable(visitorRepository.findByTokenNo(tokenNo));
    }

    @Override
    public Optional<Visitor> findByAadharNo(String aadharNo) {
        return Optional.ofNullable(visitorRepository.findByAadharNo(aadharNo));
    }

    @Override
    public List<Visitor> findByFullName(String fullName) {
        return visitorRepository.findByFullNameContainingIgnoreCase(fullName);
    }

    @Override
    public List<Visitor> findByIsRegular(Boolean isRegular) {
        return visitorRepository.findByIsRegular(isRegular);
    }

    @Override
    public Optional<Visitor> findByMobileNo(String mobileNo) {
        return visitorRepository.findByMobileNo(mobileNo);
    }

    @Override
    public List<Visitor> findByPurposeToVisit(String purpose) {
        return visitorRepository.findByPurposeToVisitContainingIgnoreCase(purpose);
    }

    @Override
    public List<Visitor> findByAccess(String access) {
        return visitorRepository.findByAccess(access);
    }

    @Override
    public List<Visitor> findByDate(String date) {
        return visitorRepository.findByDate(date);
    }
}
