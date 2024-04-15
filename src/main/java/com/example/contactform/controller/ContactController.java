package com.example.contactform.controller;

import com.example.contactform.model.Contact;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class ContactController {

    @GetMapping("/form")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "ContactForm";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("contact") @Valid Contact contact, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ContactForm";
        }
        model.addAttribute("contact", contact);
            return "ConfirmationPage";

    }
}
