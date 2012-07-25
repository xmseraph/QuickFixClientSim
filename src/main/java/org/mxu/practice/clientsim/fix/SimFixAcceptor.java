package org.mxu.practice.clientsim.fix;

import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

public class SimFixAcceptor {
	private static final String configAcceptorFileName = "acceptor.config";
	
	Application application;
	Acceptor acceptor;
	
	public SimFixAcceptor(Application app) throws ConfigError {
		application = app;
	    SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream(configAcceptorFileName));
	    MessageStoreFactory storeFactory = new FileStoreFactory(settings);
	    LogFactory logFactory = new FileLogFactory(settings);
	    MessageFactory messageFactory = new DefaultMessageFactory();
	    acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
	}
	
	public void start() throws RuntimeError, ConfigError{
		acceptor.start();
	}
	
	public void stop(){
		acceptor.stop();
	}
	
}
