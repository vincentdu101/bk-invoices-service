package com.bkenterprises.invoices.service;

import com.bkenterprises.invoices.model.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MessagingService {

    void publishInvoice(Invoice invoice) throws JsonProcessingException;

}
