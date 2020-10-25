package com.smashtik.patterns.proxypattern.protectionproxy;

import java.rmi.Naming;

import com.smashtik.patterns.proxypattern.remoteproxy.ReportGenerator;

public class ReportGeneratorProtectionProxy implements ReportGeneratorProxy{

	ReportGenerator reportGenerator;
	Staff staff;
	
	public ReportGeneratorProtectionProxy(Staff staff){
		this.staff = staff;
	}

	@Override
	public String generateDailyReport() {
		if(staff.isOwner()){
			ReportGenerator reportGenerator = null;
			try {
				reportGenerator = (ReportGenerator)Naming.lookup("rmi://localhost:5000/PizzaCoRemoteGenerator");
				return reportGenerator.generateDailyReport();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
		else{
			return "Not Authorized to view report.";
		}
	}
}
