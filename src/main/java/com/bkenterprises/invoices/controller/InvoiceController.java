package com.bkenterprises.invoices.controller;

import com.bkenterprises.invoices.dao.InvoiceRepository;
import com.bkenterprises.invoices.model.Invoice;
import com.bkenterprises.invoices.service.IdentifierType;
import com.bkenterprises.invoices.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.MissingResourceException;

@RestController
public class InvoiceController {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    SecurityService securityService;

    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createNewInvoice(@RequestBody Invoice newInvoice) {
        newInvoice.setUUID(securityService.generateUUID(IdentifierType.ID));
        newInvoice.setCreatedOn(LocalDateTime.now());
        newInvoice.setModifiedOn(LocalDateTime.now());
        return invoiceRepository.save(newInvoice);
    }

    @GetMapping("/invoices/{id}")
    public Invoice findInvoice(@PathVariable String id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new MissingResourceException("missing resource", id, ""));
    }

    @PutMapping("/invoices/{id}")
    public Invoice updateEmployee(@RequestBody Invoice newInvoice, @PathVariable String id) {
        return invoiceRepository.findById(id)
                .map(invoice -> {
                    invoice.setVendorUUID(newInvoice.getVendorUUID());
                    invoice.setProductUUID(newInvoice.getProductUUID());
                    invoice.setQuantity(newInvoice.getQuantity());
                    invoice.setRate(newInvoice.getRate());
                    invoice.setTotalCost(newInvoice.getTotalCost());
                    return invoiceRepository.save(invoice);
                })
                .orElseGet(() -> {
                    newInvoice.setUUID(id);
                    return invoiceRepository.save(newInvoice);
                });
    }

    @DeleteMapping("/invoices/{id}")
    public void deleteInvoice(@PathVariable String id) {
        invoiceRepository.deleteById(id);
    }

}
