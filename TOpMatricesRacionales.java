//----------->TOpMatricesRacionales

class TOpMatricesRacionales{
	//METODOS DIVERSOS
	//SUMA
	TMatrizRacional sumaMatricesRacionales(TMatrizRacional matriz1, TMatrizRacional matriz2){
		TMatrizRacional res;
		if((matriz1.getNumeroFilas() == matriz2.getNumeroFilas()) && 
		(matriz1.getNumeroColumnas() == matriz2.getNumeroColumnas())){
			TOperaRacionales op = new TOperaRacionales();
			TRacional ayuda = new TRacional();
			res = new TMatrizRacional(matriz1.getNumeroFilas(),matriz1.getNumeroColumnas());
			//SUMA POR COMPÓNENTES
			for(int i=0;i<matriz1.getNumeroFilas();i++){
				for(int j=0;j<matriz1.getNumeroColumnas();j++){
					ayuda = op.sumaRacional(matriz1.getComponente(i,j),matriz2.getComponente(i,j));
					//SIMPLIFICACION
					ayuda.simplificaRacional();
					res.setComponente(i,j,ayuda);
				}
			}
			return res;
		}
		else
			return null;
	}
	
	//RESTA
	TMatrizRacional restaMatricesRacionales(TMatrizRacional matriz1, TMatrizRacional matriz2){
		TMatrizRacional res;
		if((matriz1.getNumeroFilas() == matriz2.getNumeroFilas()) && 
		(matriz1.getNumeroColumnas() == matriz2.getNumeroColumnas())){
			TOperaRacionales op = new TOperaRacionales();
			TRacional ayuda = new TRacional();
			res = new TMatrizRacional(matriz1.getNumeroFilas(),matriz1.getNumeroColumnas());
			//RESTA POR COMPÓNENTES
			for(int i=0;i<matriz1.getNumeroFilas();i++){
				for(int j=0;j<matriz1.getNumeroColumnas();j++){
					ayuda = op.restaRacional(matriz1.getComponente(i,j),matriz2.getComponente(i,j));
					//SIMPLIFICACION
					ayuda.simplificaRacional();
					res.setComponente(i,j,ayuda);
				}
			}
			return res;
		}
		else
			return null;
	}
	
	//MULTIPLICACION
	TMatrizRacional multiplicaMatricesRacionales(TMatrizRacional matriz1, TMatrizRacional matriz2){
		TMatrizRacional res;
		if(matriz1.getNumeroColumnas() == matriz2.getNumeroFilas()){
			TOperaRacionales op = new TOperaRacionales();
			TRacional ayuda1 = new TRacional();
			TRacional ayuda2 = new TRacional();
			res = new TMatrizRacional(matriz1.getNumeroFilas(),matriz2.getNumeroColumnas());
			//MULTIPLICACION POR COMPÓNENTES
			for(int i=0;i<matriz1.getNumeroFilas();i++){
				for(int j=0;j<matriz1.getNumeroColumnas();j++){
					ayuda1.setNumerador(0);
					ayuda1.setDenominador(1);
					res.setComponente(i,j,ayuda1);
					for(int k=0;k<matriz1.getNumeroColumnas();k++){
						ayuda2 = op.multiplicaRacional(matriz1.getComponente(i,k),matriz2.getComponente(k,j));
						ayuda1 = op.sumaRacional(ayuda1,ayuda2);
					}
					//SIMPLIFICACION
					ayuda1.simplificaRacional();
					res.setComponente(i,j,ayuda1);
				}
			}
			return res;
		}
		else
			return null;
	}
	
	//INVERSA
	public TMatrizRacional inversaMatrizRacional(TMatrizRacional matriz){
		TMatrizRacional ma,mi;
		int n;
		if(matriz.getNumeroColumnas() == matriz.getNumeroFilas()){
			n = matriz.getNumeroFilas();
			mi = new TMatrizRacional(n,n);
			ma = new TMatrizRacional(n,2*n);
			TRacional cero = new TRacional();
			TRacional uno = new TRacional(1,1);
			TRacional menos_uno = new TRacional(-1,1);
			
			TOperaRacionales op = new TOperaRacionales();
			TRacional pivote = new TRacional();
			TRacional ayuda1 = new TRacional();
			TRacional ayuda2 = new TRacional();
	
			//CONSTRUIMOS LA SEGUNDA PARTE DE LA MATRIZ AMPLIADA
			//COPIA MATRIZ A LA MATRIZ AMPLIADA (MA)
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					ma.setComponente(i,j,matriz.getComponente(i,j));
				}
				for(int j=n;j<2*n;j++){
					ma.setComponente(i,j,cero);
				}
				ma.setComponente(i,i+n,uno);
			}
			
			//METODO DE GAUSS-JORDAN (MATRIZ ESCALONADA)
			//HACE LA MATRIZ TRIANGULAR INFERIOR DE CEROS
			for(int k=0;k<n-1;k++){
				for(int i=k+1;i<n;i++){
					if(ma.getComponente(k,k) == cero){
						return null;
					}
					else{
						ayuda1 = op.multiplicaRacional(menos_uno,ma.getComponente(i,k));
						ayuda2 = ma.getComponente(k,k);
						pivote = op.divideRacional(ayuda1,ayuda2);
						for(int j=k;j<2*n;j++){
							ayuda1 = op.multiplicaRacional(pivote,ma.getComponente(k,j));
							ayuda2 = op.sumaRacional(ayuda1,ma.getComponente(i,j));
							ma.setComponente(i,j,ayuda2);
						}
					}
				}
			}
			
			//HACE LA MATRIZ TRIANGULAR SUPERIOR DE CEROS
			for(int k=n-1;k>=0;k--){
				for(int i=k-1;i>=0;i--){
					ayuda1 = op.multiplicaRacional(menos_uno,ma.getComponente(i,k));
					ayuda2 = ma.getComponente(k,k);
					pivote = op.divideRacional(ayuda1,ayuda2);
					for(int j=k;j<2*n;j++){
						ayuda1 = op.multiplicaRacional(pivote,ma.getComponente(k,j));
						ayuda2 = op.sumaRacional(ayuda1,ma.getComponente(i,j));
						ma.setComponente(i,j,ayuda2);
					}
				}
			}
			
			//HACER UNOS EN LA DIAGONAL	
			for(int i=0;i<n;i++){
				for(int j=n; j<2*n;j++){
					ma.setComponente(i,j,op.divideRacional(ma.getComponente(i,j),ma.getComponente(i,i)));
					//SIMPLIFICACION RESULTADOS
					ayuda1= ma.getComponente(i,j);
					ayuda1.simplificaRacional();
					ma.setComponente(i,j,ayuda1);
				}
				ma.setComponente(i,i,op.divideRacional(ma.getComponente(i,i),ma.getComponente(i,i)));
				//SIMPLIFICACION RESULTADOS
				ayuda1= ma.getComponente(i,i);
				ayuda1.simplificaRacional();
				ma.setComponente(i,i,ayuda1);
			}
			
			//PASAR RESULTADO DE MATRIZ AMPLIADA A LA MATRIZ INVERSA
			for(int i=0;i<n;i++){
				for(int j=0; j<n;j++){
					mi.setComponente(i,j,ma.getComponente(i,j+n));
					
				}
			}
			//return ma;
			
			return mi;
		}
		else{
			return null;
		}
	}
}//FIN TOpMatricesRacionales
