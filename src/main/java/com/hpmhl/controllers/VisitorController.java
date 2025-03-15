package com.hpmhl.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hpmhl.entities.Visitor;
import com.hpmhl.repositories.VisitorRepository;
import com.hpmhl.services.VisitorService;

@Controller
public class VisitorController {

	@Autowired
	VisitorService visitorService;

	@Autowired
	VisitorRepository visitorRepository;

	@Autowired
	JavaMailSender javaMailSender;

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("visitors", visitorService.getAllVisitors());
		return "index";
	}

	@PostMapping("/add-visitors")
	public String addUsers(@RequestParam("addtoken") Integer addtoken) {
	    List<Visitor> visitorsList = new ArrayList<>();

	    for (int i = 0; i < addtoken; i++) {
	        Visitor visitor = new Visitor();
	        visitorsList.add(visitor);
	    }

	    // Save initial visitors
	    List<Visitor> savedVisitors = visitorRepository.saveAll(visitorsList);

	    // Set tokenNo as the ID and update them in the database
	    for (Visitor visitor : savedVisitors) {
	        visitor.setTokenNo(visitor.getId());
	    }
	    visitorRepository.saveAll(savedVisitors); // Persist changes

	    return "redirect:/";
	}


	@GetMapping("/edit")
	public String editVisitor(@RequestParam("id") Integer id, Model model) {
		visitorService.getVisitorById(id).setTokenNo(id);
		model.addAttribute("visitor", visitorService.getVisitorById(id));
		return "edit-visitor";
	}

	// Controller
	@PostMapping("/update")
	public String updateVisitor(
	    @RequestParam("id") Integer id,
	    @RequestParam("aadharNo") String aadharNo,
	    @RequestParam("fullName") String fullName,
	    @RequestParam("mobileNo") String mobileNo,
	    @RequestParam("address") String address,
	    @RequestParam("toSeeWhom") String toSeeWhom,
	    @RequestParam("purposeToVisit") String purposeToVisit,
	    @RequestParam(value = "photo", required = false) String photoBase64,  // Changed from MultipartFile
	    @RequestParam(value = "idPhoto", required = false) String idPhotoBase64,  // Changed from MultipartFile
	    @RequestParam("isRegular") Boolean isRegular,
	    Model model) throws IOException {
	    
	    Visitor v = visitorService.getVisitorById(id);
	    v.setAadharNo(aadharNo);
	    v.setFullName(fullName);
	    v.setMobileNo(mobileNo);
	    v.setAddress(address);
	    v.setToSeeWhom(toSeeWhom);
	    v.setPurposeToVisit(purposeToVisit);
	    v.setIsRegular(isRegular);
	    v.setDate(new Date().toString());
	    v.setQrCodeValue("V/HPMHL/" + id);
	    v.setRestricted(false);

	    String visitorImage = v.getPhoto() != null ? v.getPhoto() : "default_visitor.jpg";
	    Path uploadDir = Paths.get("src/main/resources/static/visitors");
	    
	    // Handle visitor photo
	    if (photoBase64 != null && !photoBase64.isEmpty() && photoBase64.contains("base64,")) {
	        String base64Data = photoBase64.split(",")[1];
	        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
	        visitorImage = System.currentTimeMillis() + "_visitor.jpg";
	        
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }
	        
	        Path filePath = uploadDir.resolve(visitorImage);
	        Files.write(filePath, decodedBytes);
	    }

	    String visitorImage2 = v.getIdPhoto() != null ? v.getIdPhoto() : "default_visitor2.jpg";
	    
	    // Handle ID photo
	    if (idPhotoBase64 != null && !idPhotoBase64.isEmpty() && idPhotoBase64.contains("base64,")) {
	        String base64Data = idPhotoBase64.split(",")[1];
	        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
	        visitorImage2 = fullName + "_" + id + "_id.jpg";
	        
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }
	        
	        Path filePath2 = uploadDir.resolve(visitorImage2);
	        Files.write(filePath2, decodedBytes);
	    }

	    v.setPhoto(visitorImage);
	    v.setIdPhoto(visitorImage2);
	    visitorService.saveVisitor(v);
	    
	    return "redirect:/";
	}

}
