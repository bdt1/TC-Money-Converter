package io.zipcoder;

import org.junit.Test;

public class CurrencyConverterTest {
	
	@Test
	public void givenAmount_whenConversion_thenNotNull() {
	    MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("USD")
	      .setNumber(1).create();
	 
	    CurrencyConversion conversionEUR = MonetaryConversions.getConversion("EUR");
	 
	    MonetaryAmount convertedAmountUSDtoEUR = oneDollar.with(conversionEUR);
	 
	    assertEquals("USD 1", oneDollar.toString());
	    assertNotNull(convertedAmountUSDtoEUR);
	}
		
	MonetaryAmount monetaryAmount = Money.of(100.20, usd);
	CurrencyUnit currency = monetaryAmount.getCurrency();
	NumberValue numberValue = monetaryAmount.getNumber();
	 
	int value= numberValue.intValue();
	
}

/*
	MonetaryAmount inCHF =...;
	CurrencyConversion conv = MonetaryConversions.getConversion("EUR");
	MonetaryAmount inEUR = inCHF.with(conv);
	//Also we can define the providers to be used for currency conversion by passing the provider names
	//explicitly:
	CurrencyConversion conv = MonetaryConversions.getConversion("EUR", "EZB", "IMF");
	//To cover also more complex usage scenarios we can also pass a ConversionQuery with additional
	//parameters for conversion, e.g.:
	MonetaryAmount inCHF =...;
	CurrencyConversion conv = MonetaryConversions.getConversion(ConversionQueryBuilder.of()
	.setProviders("CS", "EZB", "IMF")
	.setTermCurrency("EUR")
	.set(MonetaryAmount.class, inCHF, MonetaryAmount.class)
	.set(LocalDate.of(2008, 1, 1))
	.setRateType(RateType.HISTORIC)
	.set(StockExchange.NYSE) // custom type
	.set("contractId", "AA-1234.2")
	.build());
	MonetaryAmount inEUR = inCHF.with(conv);

*/