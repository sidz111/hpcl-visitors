package com.hpmhl.services;

import com.hpmhl.entities.Visitor;

import java.util.List;
import java.util.Optional;

public interface VisitorService {

    // Save a visitor
    Visitor saveVisitor(Visitor visitor);

    // Update a visitor
    Visitor updateVisitor(Integer id, Visitor visitor);

    // Get visitor by ID
    Visitor getVisitorById(Integer id);

    // Get all visitors
    List<Visitor> getAllVisitors();

    // Delete visitor by ID
    void deleteVisitor(Integer id);

    // Find by Token Number
    Optional<Visitor> findByTokenNo(Integer tokenNo);

    // Find by Aadhar Number
    Optional<Visitor> findByAadharNo(String aadharNo);

    // Find by full name
    List<Visitor> findByFullName(String fullName);

    // Find regular visitors
    List<Visitor> findByIsRegular(Boolean isRegular);

    // Find by mobile number
    Optional<Visitor> findByMobileNo(String mobileNo);

    // Find by purpose to visit
    List<Visitor> findByPurposeToVisit(String purpose);

    // Find by access type
    List<Visitor> findByAccess(String access);

    // Find by date
    List<Visitor> findByDate(String date);
}
