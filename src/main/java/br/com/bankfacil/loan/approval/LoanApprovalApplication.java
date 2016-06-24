package br.com.bankfacil.loan.approval;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Loan Approval App")
public class LoanApprovalApplication extends ServletProcessApplication {
  // empty implementation
	ProcessRequestDelegate delegate = new ProcessRequestDelegate();
}