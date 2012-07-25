package org.mxu.practice.clientsim;

import org.mxu.practice.clientsim.fix.SimApplication;
import org.mxu.practice.clientsim.fix.SimFixAcceptor;
import org.mxu.practice.clientsim.fix.SimFixInitiator;

import quickfix.Application;
import quickfix.ConfigError;
import quickfix.RuntimeError;

public class SimService {
	SimFixAcceptor acc;
	SimFixInitiator ini;

	public SimService() throws ConfigError {
		Application appServer = new SimApplication("server");
		Application appClient = new SimApplication("client");
		acc = new SimFixAcceptor(appServer);
		ini = new SimFixInitiator(appClient);
	}

	public void start() throws RuntimeError, ConfigError {
		if (acc != null) {
			acc.start();
		}
		if (ini != null) {
			ini.start();
		}
	}

	public void stop() {
		if (acc != null) {
			acc.stop();
		}
		if (ini != null) {
			ini.stop();
		}
	}

	public static void main(String... args) throws ConfigError {
		final SimService ss = new SimService();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Stopping simservice");
				ss.stop();
				System.out.println("Shutdown hook completed...");
			}
		});
		ss.start();
	}

}
