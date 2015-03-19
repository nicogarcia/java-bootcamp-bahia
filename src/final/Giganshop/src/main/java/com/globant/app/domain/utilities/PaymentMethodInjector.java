package com.globant.app.domain.utilities;

import com.globant.app.domain.paymentMethods.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PaymentMethodInjector {

	private static Map<String, Class<? extends IPaymentMethod>> methodMap = new HashMap<String, Class<? extends IPaymentMethod>>();
	private static Map<String, PaymentInfo> infoMap = new HashMap<String, PaymentInfo>();

	static {
		methodMap.put(CashPayment.CLASS_NAME, CashPayment.class);
		methodMap.put(PaypalPayment.CLASS_NAME, PaypalPayment.class);
		methodMap.put(CreditCardPayment.CLASS_NAME, CreditCardPayment.class);

		PaymentInfo cashInfo = new PaymentInfo(
				Arrays.asList(new PayInfoField("name", "Nombre"))
		);

		PaymentInfo paypalInfo = new PaymentInfo(
				Arrays.asList(
						new PayInfoField("username", "Nombre de usuario"),
						new PayInfoField("password", "Contraseña")
				)
		);

		PaymentInfo creditCardInfo = new PaymentInfo(
				Arrays.asList(
						new PayInfoField("cardnumber", "Número de tarjeta"),
						new PayInfoField("cvc", "CVC")
				)
		);

		infoMap.put(CashPayment.CLASS_NAME, cashInfo);
		infoMap.put(CreditCardPayment.CLASS_NAME, creditCardInfo);
		infoMap.put(PaypalPayment.CLASS_NAME, paypalInfo);
	}

	public static IPaymentMethod getPaymentMethod(String name) {
		try {
			return methodMap.get(name).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PaymentInfo getPaymentInfo(String name) {
		try {
			return PaymentInfo.class.getConstructor(PaymentInfo.class).newInstance(infoMap.get(name));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
