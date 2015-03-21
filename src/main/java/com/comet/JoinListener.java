package com.comet;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.event.ConnectEvent;
import org.comet4j.core.listener.ConnectListener;

class JoinListener extends ConnectListener {
	@Override
	public boolean handleEvent(ConnectEvent anEvent) {
		CometConnection conn = anEvent.getConn();
		CometContext.getInstance().getEngine().sendTo("hello", conn, "欢迎上线");
		return true;
	}
}