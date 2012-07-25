package org.mxu.practice.clientsim.fix;

import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.SocketInitiator;

public class SimFixInitiator {
	private static final String configAcceptorFileName = "initiator.config";
	
	Application application;
	Initiator acceptor;
	
	public SimFixInitiator(Application app) throws ConfigError {
		application = app;
	    SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream(configAcceptorFileName));
	    MessageStoreFactory storeFactory = new FileStoreFactory(settings);
	    LogFactory logFactory = new FileLogFactory(settings);
	    MessageFactory messageFactory = new DefaultMessageFactory();
	    acceptor = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
	}
	
	public void start() throws RuntimeError, ConfigError{
		acceptor.start();
	}
	
	public void stop(){
		acceptor.stop();
	}
	
}
