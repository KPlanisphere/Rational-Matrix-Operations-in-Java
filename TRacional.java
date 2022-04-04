// --------------------> TRacional

class TRacional{
	//****ATRIBUTOS****
	private int num,den;
	
	//****METODOS****
	//CONSTRUCTORES
	TRacional(){
		num = 0;
		den = 1;
	}
	
	TRacional(int num, int den){
		this.num = num;
		if(den!=0)
			this.den = den;
		else
			this.den = Integer.MIN_VALUE;
		
	}

	//METODOS SET
	public void setNumerador(int num){
		this.num = num;
	}
	
	public void setDenominador(int den){
		this.den = den;
	}
	
	//METODOS GET
	public int getNumerador(){
		return num;
	}
	
	public int getDenominador(){
		return den;
	}
	
	//METODOS DIVERSOS
	
	private int mcd(int a, int b){
		if(b == 0)
			return a;
		else
			return mcd(b, a%b);
		
	}
	
	public void simplificaRacional(){
		int MCD;
		
		if(num>den)
			MCD = mcd(num,den);
		else
			MCD = mcd(den,num);
		num = num/MCD;
		den = den/MCD;
	}
	
	public String toString(){
		String cadena;
		
		//SOLUCION DENOMINADOR NEGATIVO
		if(den<0){
			den = den*-1;
			num = num*-1;
		}
		
		if(den == 1){
			cadena = Integer.toString(num);
		}
		else if(num == 0){
			cadena = "0";
		}
		else{
			cadena = Integer.toString(num) + "/" + Integer.toString(den);
		}
		return cadena;
	}

}//FIN CLASE RACIONAL
