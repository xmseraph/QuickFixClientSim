package org.mxu.practice.clientsim.fix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fix41.MessageCracker;

public class SimApplication extends MessageCracker implements Application {

	private String name;
	public SimApplication(String name) {
		super();
		this.name = name;
	}

	private final Logger log = LoggerFactory.getLogger(SimApplication.class);
	
	public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		log.info(name+":from admin "+arg0.toString()+" sessionid="+arg1);
	}

	public void fromApp(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
		log.info(name+":from app "+arg0+" sessionid="+arg1);
	}

	public void onCreate(SessionID arg0) {
		log.info(name+":on create sessionid="+arg0);
	}

	public void onLogon(SessionID arg0) {
		log.info(name+":on logon sessionid="+arg0);
	}

	public void onLogout(SessionID arg0) {
		log.info(name+":on logout sessionid="+arg0);
	}

	public void toAdmin(Message arg0, SessionID arg1) {
		log.info(name+":to admin "+arg0+" sessionid="+arg1);
	}

	public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
		log.info(name+":to app "+arg0+" sessionid="+arg1);
	}

}
