package com.comet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

public class HelloWorld implements ServletContextListener {
	private static final String CHANNEL = "hello";

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-----------------");
		CometContext cc = CometContext.getInstance();
		cc.getEngine().addConnectListener(new JoinListener());
		cc.registChannel(CHANNEL);// 注册应用的channel
		Thread helloAppModule = new Thread(new HelloAppModule(),
				"Sender App Module");
		helloAppModule.setDaemon(true);
		helloAppModule.start();

	}

	class HelloAppModule implements Runnable {
		public void run() {
			while (true) {
				System.out.println("==============");
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				CometEngine engine = CometContext.getInstance().getEngine();
				
				for (CometConnection cc : engine.getConnections()) {
					HttpServletRequest  req = cc.getRequest();
					System.out.println(req.getHeader("Content-Type"));
				}
				
				engine.sendToAll(CHANNEL,
						Runtime.getRuntime().freeMemory() / 1024);
			}
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}