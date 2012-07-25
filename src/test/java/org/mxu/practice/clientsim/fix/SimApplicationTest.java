package org.mxu.practice.clientsim.fix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

import org.junit.Test;

import quickfix.Acceptor;
import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.SocketInitiator;

public class SimApplicationTest extends TestCase {
	private static final String configAcceptorFileName = "sampleAcceptor.config";
	private static final String configInitiatorFileName = "sampleInitiator.config";
	public SimApplicationTest(String name) {
		super(name);
	}
	
	@Test
	public void testStartSimApplicationAsAcceptor() throws FileNotFoundException, ConfigError{
	    Application application = new SimApplication();

	    SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream(configAcceptorFileName));
	    MessageStoreFactory storeFactory = new FileStoreFactory(settings);
	    LogFactory logFactory = new FileLogFactory(settings);
	    MessageFactory messageFactory = new DefaultMessageFactory();
	    Acceptor acceptor = new SocketAcceptor(application, storeFactory, settings, logFactory, messageFactory);
	    acceptor.start();
	    // while( condition == true ) { do something; }
	    acceptor.stop();
	}
	
	@Test
	public void testStartSimApplicationAsInitiator() throws FileNotFoundException, ConfigError{
	    Application application = new SimApplication();

	    SessionSettings settings = new SessionSettings(this.getClass().getClassLoader().getResourceAsStream(configInitiatorFileName));
	    MessageStoreFactory storeFactory = new FileStoreFactory(settings);
	    LogFactory logFactory = new FileLogFactory(settings);
	    MessageFactory messageFactory = new DefaultMessageFactory();
	    Initiator initiator = new SocketInitiator(application, storeFactory, settings, logFactory, messageFactory);
	    initiator.start();
	    initiator.stop();
	}
}
