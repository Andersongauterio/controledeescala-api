package br.com.anderson.controledeescala;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Teste {

	public static void main(String[] args) {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.MONTH, 0);
		instance.set(Calendar.DAY_OF_MONTH, instance.getActualMaximum(Calendar.DAY_OF_MONTH));

		System.out.println( new SimpleDateFormat("dd/MM/yyyy").format(instance.getTime()));

	}

}
