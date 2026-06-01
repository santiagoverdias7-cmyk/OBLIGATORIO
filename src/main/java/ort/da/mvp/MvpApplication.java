package ort.da.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ort.da.mvp.Obligatorio.datosPrueba.DatosPrueba;
import ort.da.mvp.Obligatorio.fachada.Fachada;


@SpringBootApplication
public class MvpApplication {

	public static void main(String[] args) {
            ConfigurableApplicationContext context = SpringApplication.run(MvpApplication.class, args);
        Fachada fachada = context.getBean(Fachada.class);
        DatosPrueba.cargarDatosDePrueba(fachada);
	}

}
