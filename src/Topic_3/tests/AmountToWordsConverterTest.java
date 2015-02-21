package Topic_3.tests;

import Topic_3.main.AmountToWordsConverter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AmountToWordsConverterTest {

	@Test
	public void GetInWords_With_Zero_Integer_Returns_Ok() {

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(0));

		assertEquals("00/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Zero_Double_Returns_Ok() {

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal("0.3"));

		assertEquals("30/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Tens_Integer_Returns_Ok() {

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(10));

		assertEquals("Ten with 00/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Tens_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(10.4));

		assertEquals("Ten with 40/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Hundreds_Integer_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(200));

		assertEquals("Two hundred with 00/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Hundreds_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal("300.2"));

		assertEquals("Three hundred with 20/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Thousands_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(1300.20));

		assertEquals("One thousand three hundred with 20/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Thousands_Double_Irregular_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(1311.20));

		assertEquals("One thousand three hundred eleven with 20/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Thousands_Double_Tens_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(1331.20));

		assertEquals("One thousand three hundred thirty-one with 20/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Millions_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal(30405371.35));

		assertEquals("Thirty million four hundred five thousand three hundred seventy-one with 35/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Billions_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal("32934578490.67"));

		assertEquals("Thirty-two billion nine hundred thirty-four million five hundred seventy-eight thousand four hundred ninety with 67/100 dollars", converted);
	}

	@Test
	public void GetInWords_With_Trillions_Double_Returns_Ok(){

		String converted = new AmountToWordsConverter().getInWords(new BigDecimal("7032934578490.67"));

		assertEquals("Seven trillion thirty-two billion nine hundred thirty-four million five hundred seventy-eight thousand four hundred ninety with 67/100 dollars", converted);
	}
}