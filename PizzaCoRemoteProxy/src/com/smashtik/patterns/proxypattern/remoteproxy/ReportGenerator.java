package com.smashtik.patterns.proxypattern.remoteproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReportGenerator extends Remote{
	
	public String generateDailyReport() throws RemoteException;

}
