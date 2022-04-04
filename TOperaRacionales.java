// --------------------> OperaRacionales

class TOperaRacionales{

	//METODOS DIVERSOS
	//SUMA
	public TRacional sumaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador() + num1.getDenominador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//RESTA
	public TRacional restaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador() - num1.getDenominador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//PRODUCTIO
	public TRacional multiplicaRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getNumerador();
		denominador = num1.getDenominador()*num2.getDenominador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		return res;
	}
	
	//DIVISION
	public TRacional divideRacional(TRacional num1, TRacional num2){
		TRacional res = new TRacional();
		int numerador, denominador;
		
		numerador = num1.getNumerador()*num2.getDenominador();
		denominador = num1.getDenominador()*num2.getNumerador();
		
		res.setNumerador(numerador);
		res.setDenominador(denominador);
		
		return res;	
	}
}//FIN CLASE TOperaRacionales
