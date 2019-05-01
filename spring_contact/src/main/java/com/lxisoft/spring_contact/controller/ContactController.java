package com.lxisoft.spring_contact.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lxisoft.spring_contact.model.Contact;
import com.lxisoft.spring_contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "save";
	}
	
	@GetMapping("/index/create")
    public String showPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }
	
	@PostMapping("/index/create")
	public String create(@ModelAttribute("contact") Contact contact) {
		contactService.create(contact);
		return "home";
	}

	@RequestMapping("/index/delete/{id}")
	public String remove(@PathVariable int id) {

		contactService.remove(id);
		return "home";
	}

	@GetMapping("index/contacts")
	public String read(Model model) {

		model.addAttribute("contact", contactService.read());
		return "home";

	}

	@GetMapping("index/contacts/{id}")
	public String getContact(@PathVariable int id,Model model) {
		
		model.addAttribute("contact", contactService.getContact(id));
		return "home";
	}
	@GetMapping("index/error")
	public String error() {

		return "error";
	}

}
