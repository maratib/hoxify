package com.mak.hoxify;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class HoxifyApplication {

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(HoxifyApplication.class, args);
	}

	@PreDestroy
	public void onExit() {
		System.out.println("Exiting app...");
		// mqConnection.close();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		String startedMessage = "The app started, visit: http://localhost:" + serverProperties.getPort();
		System.out.println(startedMessage);

	}

}
