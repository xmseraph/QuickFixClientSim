package org.mxu.practice.clientsim.fix;


import org.apache.log4j.Logger;

import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

public class SimApplication implements Application {

	private final Logger log = Logger.getLogger(SimApplication.class);
	
	public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		log.info("from admin "+arg0.toString()+" sessionid="+arg1);
	}

	public void fromApp(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
		log.info("from app "+arg0+" sessionid="+arg1);
	}

	public void onCreate(SessionID arg0) {
		log.info("on create sessionid="+arg0);
	}

	public void onLogon(SessionID arg0) {
		log.info("on logon sessionid="+arg0);
	}

	public void onLogout(SessionID arg0) {
		log.info("on logout sessionid="+arg0);
	}

	public void toAdmin(Message arg0, SessionID arg1) {
		log.info("to admin "+arg0+" sessionid="+arg1);
	}

	public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
		log.info("to app "+arg0+" sessionid="+arg1);
	}

}
