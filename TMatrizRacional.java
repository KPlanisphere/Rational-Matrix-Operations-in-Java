class TMatrizRacional{
	//ATRIBUTOS
	private int n,m;
	private TRacional matriz[][];
	
	//************METODOS************
	//CONTRUCTOR
	TMatrizRacional(int n, int m){
		this.n = n;
		this.m = m;
		matriz = new TRacional[n][m];
		
		//INSTANCIACION DE LOS COMPONENTES DE LA MATRIZ
		for(int i=0; i<n; i++){
			for(int j=0;j<m;j++){
				matriz[i][j] = new TRacional();
			}
		}
	}
	
	//SET
	public void setComponente(int i, int j, TRacional valor){
		matriz[i][j].setNumerador(valor.getNumerador());
		matriz[i][j].setDenominador(valor.getDenominador());
		
	}

	//GET
	public int getNumeroFilas(){
		return n;
	}
	
	public int getNumeroColumnas(){
		return m;
	}
	
	public TRacional getComponente(int i, int j){
		return matriz[i][j];
	}
	
	//DIVERSOS
	@Override
	public String toString(){
		String cadena = "";
		int i, j;
		
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				cadena = cadena +  matriz[i][j].toString() + "\t";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}

}//FIN TMatrizRacional
