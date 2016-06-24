package br.com.bankfacil.loan.approval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.task.IdentityLink;

public class AssigneeRandomCandidateTaskListener implements TaskListener{
	private final static Logger LOGGER = Logger.getLogger(AssigneeRandomCandidateTaskListener.class.toString());
	
	@Override
	public void notify(DelegateTask delegateTask) {
		List<IdentityLink> candidateGroups = new ArrayList<IdentityLink>(delegateTask.getCandidates());
		List<User> candidateUsers = new ArrayList<User>();
		
		for (IdentityLink candidate : candidateGroups) {
			candidateUsers.addAll(
					delegateTask.getProcessEngineServices()
					            .getIdentityService()
					            .createUserQuery()
					            .memberOfGroup(candidate.getGroupId())
					            .list());
		}

		User owner = candidateUsers.get(new Random().nextInt(candidateUsers.size()));	
		delegateTask.setAssignee(owner.getId());
	}
}
