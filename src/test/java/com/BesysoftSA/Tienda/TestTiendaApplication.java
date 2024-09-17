package com.BesysoftSA.Tienda;

import org.springframework.boot.SpringApplication;

public class TestTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.from(TiendaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
