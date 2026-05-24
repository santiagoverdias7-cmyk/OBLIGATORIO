package ort.da.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ort.da.mvp.Obligatorio.datosPrueba.DatosPrueba;


@SpringBootApplication
public class MvpApplication {

	public static void main(String[] args) {
             DatosPrueba datosPrueba = new DatosPrueba();
             datosPrueba.cargarDatosDePrueba();
            SpringApplication.run(MvpApplication.class, args);
	}

}
