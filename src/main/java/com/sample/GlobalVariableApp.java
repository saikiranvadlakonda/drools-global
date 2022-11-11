package com.sample;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import com.ruleengine.dto.LoanRequest;

public class GlobalVariableApp {
	
	private final KieServices kieServices = KieServices.Factory.get();
	private final Path root = Paths.get("uploads");

	public static void main(String[] args) {
		KieSession kieSession = null;
		try {
			LoanRequest loan = new LoanRequest();
			loan.setAge(30);
			loan.setIncome(50000);
			loan.setLoanAmount(5000000);
			loan.setName("Loan");
			loan.setRoi(50);
//			 loan.setScore(10);
//			loan.setScore(100);
			String filename = "Global.xlsx";
			GlobalVariableApp gv = new GlobalVariableApp();
			kieSession = gv.getKieSession(filename);
			kieSession.insert(loan);
			
			
			kieSession.setGlobal("minScore", new Integer(0));
			kieSession.getAgenda().getAgendaGroup("init").setFocus();
			
			int rulesCount = kieSession.fireAllRules();
			System.out.println("Rules fired : " + rulesCount);
			kieSession.dispose();
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private KieSession getKieSession(String fileName) {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		Path filePath = root.resolve(fileName);
		String absPath = filePath.toAbsolutePath().toString();
		kieFileSystem.write(ResourceFactory.newFileResource(absPath));
		KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId()).newKieSession();
	}
}
