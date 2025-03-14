package com.hpmhl.repositories;

import com.hpmhl.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    // Find by Token Number
    Visitor findByTokenNo(Integer tokenNo);

    // Find by Aadhar Number
    Visitor findByAadharNo(String aadharNo);

    // Find all visitors by full name (case-insensitive)
    List<Visitor> findByFullNameContainingIgnoreCase(String fullName);

    // Find all regular visitors
    List<Visitor> findByIsRegular(Boolean isRegular);

    // Find visitors by mobile number
    Optional<Visitor> findByMobileNo(String mobileNo);

    // Find visitors by purpose of visit
    List<Visitor> findByPurposeToVisitContainingIgnoreCase(String purpose);

    // Find visitors by access type
    List<Visitor> findByAccess(String access);

    // Find visitors by date
    List<Visitor> findByDate(String date);
}
