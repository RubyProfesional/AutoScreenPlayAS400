package co.proyectobase.myextra.interactions;

import static co.proyectobase.myextra.util.UtilidadTiempo.condicionExitosa;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Esperar implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			Awaitility.await().forever().pollInterval(5000, TimeUnit.MILLISECONDS).until(condicionExitosa());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static Esperar aMoment() {

		return instrumented(Esperar.class);
	}

}
