package com.bkenterprises.invoices.dao;

import com.bkenterprises.invoices.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}
