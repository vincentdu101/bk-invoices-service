package com.bkenterprises.invoices.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;

public interface SQSConfigService {

    AmazonSQSAsync initializeSQSAsync();

}
