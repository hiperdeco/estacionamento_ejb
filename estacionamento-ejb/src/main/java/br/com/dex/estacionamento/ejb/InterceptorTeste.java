package br.com.dex.estacionamento.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorTeste {
	
	
	@AroundInvoke
	public Object teste(InvocationContext ctx) throws Exception{
		System.out.println("Ater Completion interceptor");
		return ctx.proceed();
	}

}
