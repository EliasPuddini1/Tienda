package com.BesysoftSA.Tienda;

import com.BesysoftSA.Tienda.Servicios.menu.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TiendaApplication.class, args);

		Menu menu = context.getBean(Menu.class);
		menu.runMenu();

	}

}
