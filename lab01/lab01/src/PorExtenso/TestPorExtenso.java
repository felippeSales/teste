package PorExtenso;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPorExtenso {

	PorExtenso transformador;

	@Before
	public void setUP(){
		transformador = new PorExtenso();
	}

	@Test
	public void test0(){
		try{
			assertEquals(transformador.transformaExtenso("0"), "zero");
		}catch(Exception e){}

	}

	@Test
	public void testAte10(){

		String[] numeros = {"zero","um", "dois","tres", "quatro","cinco","seis","sete","oito","nove", "dez"};
		try{
			for (int i = 1; i < numeros.length; i++) {
				assertEquals(transformador.transformaExtenso(i+""), numeros[i]);
				
			}
		}catch(Exception e){}


	}

	@Test
	public void testNumerosDeUmaPalavra(){

		String[] numeros = {"zero","um", "dois","tres", "quatro","cinco","seis","sete","oito"
				,"nove", "dez","onze","doze", "treze", "catorze", "quinze", "dezesseis", "dezessete"
				,"dezoito", "dezenove", "vinte","trinta","quarenta","cinquenta", "sessenta",
				"setenta", "oitenta", "noventa", "cem","duzentos", "trezentos", "quatrocentos",
				"quinhentos", "seiscentos", "setecentos","oitocentos", "novecentos", "mil" }; 

		try{
			// Testa ate 20
			for (int i = 11; i < 21; i++) {					
				assertEquals(transformador.transformaExtenso(i+""), numeros[i]);
			}

			//Testa de 30 ate 100
			int contador = 30;
			for(int n = 21; n < 29; n++){
				assertEquals(transformador.transformaExtenso(contador+""), numeros[n]);
				contador += 10;
			}

			// Testa ate 1000
			int i = 29;
			for(int n = 200; n <= 1000; n += 100){
				assertEquals(transformador.transformaExtenso(n + ""), numeros[i]);
				i += 1;
			}		

		}catch(Exception e){}
	}

	@Test
	public void testEntradaVazia(){
		try{
		transformador.transformaExtenso("");
		fail();
		}catch(Exception e){}

	}
	
	@Test
	public void testaEntradaErrada(){
		
		String[] palavras = {"Felipe", "a", "bbbb", "xpto"};
		for (String string : palavras) {
			try{
				transformador.transformaExtenso(string);
				fail();
			}catch(Exception e){
				assertEquals(e.getMessage(), "Entrada invalida");
			}
		}
	}
	
	@Test
	public void testa21a99() throws Exception{
		assertEquals("vinte e um", transformador.transformaExtenso("21"));
		
		assertEquals("vinte e um", transformador.transformaExtenso("021"));
		
		assertEquals("cinquenta e dois", transformador.transformaExtenso("52"));
		
		assertEquals("trinta e quatro", transformador.transformaExtenso("34"));
		
		assertEquals("noventa e nove",  transformador.transformaExtenso("99"));
		
		assertEquals("quarenta e quatro",  transformador.transformaExtenso("44"));
	}
	
	@Test
	public void testaEntre101a999() throws Exception{
		assertEquals("cento e um", transformador.transformaExtenso("101"));
		
		assertEquals("cento e dois", transformador.transformaExtenso("102"));
		
		assertEquals("cento e dez", transformador.transformaExtenso("110"));
		
		assertEquals("novecentos e dois", transformador.transformaExtenso("902"));
		
		assertEquals("novecentos", transformador.transformaExtenso("900"));
		
		assertEquals("setecentos e cinquenta e dois", transformador.transformaExtenso("752"));
		
		assertEquals("duzentos e quatro", transformador.transformaExtenso("204"));
		
		assertEquals("duzentos e vinte e dois", transformador.transformaExtenso("222"));
		
		assertEquals("novecentos e noventa e nove", transformador.transformaExtenso("999"));
		
		assertEquals("oitocentos e vinte e seis", transformador.transformaExtenso("826"));
		
		assertEquals("cento e setenta e seis", transformador.transformaExtenso("176"));
		
	}
	
	@Test
	public void testaEntre1001a1099() throws Exception{
		assertEquals("mil e um", transformador.transformaExtenso("1001"));
		assertEquals("mil e cinquenta e quatro", transformador.transformaExtenso("1054"));
		assertEquals("mil e noventa e nove", transformador.transformaExtenso("1099"));
	}
	
	@Test
	public void testaEntre1100a1999() throws Exception{
		assertEquals("mil e cem", transformador.transformaExtenso("1100"));
		assertEquals("mil cento e cinquenta e quatro", transformador.transformaExtenso("1154"));
		assertEquals("mil cento e cinquenta e seis", transformador.transformaExtenso("1156"));
		assertEquals("mil duzentos e um", transformador.transformaExtenso("1201"));
		assertEquals("mil e novecentos", transformador.transformaExtenso("1900"));
		assertEquals("mil trezentos e vinte", transformador.transformaExtenso("1320"));
		assertEquals("mil novecentos e noventa e nove", transformador.transformaExtenso("1999"));
		assertEquals("mil trezentos e oitenta", transformador.transformaExtenso("1380"));
		assertEquals("mil oitocentos e oitenta", transformador.transformaExtenso("1880"));
	}
	
	@Test
	public void testaEntre2000ate999999() throws Exception{
		assertEquals("oitenta mil", transformador.transformaExtenso("80000"));
		assertEquals("oitenta mil e oitocentos", transformador.transformaExtenso("80800"));
		assertEquals("oitenta mil e oitocentos e oitenta", transformador.transformaExtenso("80880"));
		assertEquals("oitocentos mil e oitenta e oito", transformador.transformaExtenso("800088"));
	}
	
	@Test
	public void testaMaisde7Casas() throws Exception{
		assertEquals("oitenta mil", transformador.transformaExtenso("80000"));
		assertEquals("oitenta mil e oitocentos", transformador.transformaExtenso("80800"));
		assertEquals("oitenta mil e oitocentos e oitenta", transformador.transformaExtenso("80880"));
		assertEquals("oitocentos mil e oitenta e oito", transformador.transformaExtenso("800088"));
	}
	
	@Test
	public void testaMaisde8Casas() throws Exception{
		assertEquals("noventa milh�es noventa mil e nove", transformador.transformaExtenso("90090009"));
		//assertEquals("oitenta mil e oitocentos", transformador.transformaExtenso("80800"));
		//assertEquals("oitenta mil e oitocentos e oitenta", transformador.transformaExtenso("80880"));
		//assertEquals("oitocentos mil e oitenta e oito", transformador.transformaExtenso("800088"));
	}
	
	
	
	
}
