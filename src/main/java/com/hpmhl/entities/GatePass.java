package com.hpmhl.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class GatePass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gatePassNumber;
    

    @OneToOne
    @JoinColumn(name = "visitor_id", unique = true)
    private Visitor visitor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGatePassNumber() {
        return gatePassNumber;
    }

    public void setGatePassNumber(String gatePassNumber) {
        this.gatePassNumber = gatePassNumber;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

	@Override
	public String toString() {
		return "GatePass [id=" + id + ", gatePassNumber=" + gatePassNumber + ", visitor=" + visitor + "]";
	}
    
    
}
