package br.com.bankfacil.loan_approval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

class ProcessRequestDelegate implements JavaDelegate {
	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
	}
}
