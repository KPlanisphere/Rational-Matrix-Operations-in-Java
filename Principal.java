// --------------------> Principal

import java.util.Scanner;

class Principal{
	public static void main(String[] args){
		TMatrizRacional A,B,C;
		
		TMatrizRacional D;
		
		int n,m,num,den;
		TRacional ayuda = new TRacional();
		
		Scanner sc = new Scanner(System.in);
		TOpMatricesRacionales op = new TOpMatricesRacionales();
		
		System.out.println("Programa que suma matrices racionales\n");
		System.out.print("Dame el numero de filas de la matrices: ");
		n = sc.nextInt();
		System.out.print("Dame el numero de columnas de la matrices: ");
		m = sc.nextInt();
		
		A = new TMatrizRacional(n,m);
		B = new TMatrizRacional(n,m);
		C = new TMatrizRacional(n,m);
		
		//ENTRADA DE DATOS MATRIZ A
		System.out.println("\nIngresa los componentes racinales de la matriz A");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("Dame el numerador de la matriz[%d][%d]: ",(i+1),(j+1));
				num = sc.nextInt();
				System.out.printf("Dame el demominador de la matriz[%d][%d]: ",(i+1),(j+1));
				den = sc.nextInt();
				ayuda.setNumerador(num);
				ayuda.setDenominador(den);
				A.setComponente(i,j,ayuda);
			}
			System.out.println();
		}
		
		//ENTRADA DE DATOS MATRIZ B
		System.out.println("\nIngresa los componentes racinales de la matriz B");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("Dame el numerador de la matriz[%d][%d]: ",(i+1),(j+1));
				num = sc.nextInt();
				System.out.printf("Dame el demominador de la matriz[%d][%d]: ",(i+1),(j+1));
				den = sc.nextInt();
				ayuda.setNumerador(num);
				ayuda.setDenominador(den);
				B.setComponente(i,j,ayuda);
			}
			System.out.println();
		}
		
		//SALIDA SUMA MATRIZ A B
		C = op.sumaMatricesRacionales(A,B);
		System.out.println("\nLa suma de matrices es: \n");
		System.out.println(C.toString());
		
		//SALIDA RESTA MATRIZ A B
		C = op.restaMatricesRacionales(A,B);
		System.out.println("\nLa resta de matrices es: \n");
		System.out.println(C.toString());
		
		//SALIDA MULTIPLICACION MATRIZ A B
		C = op.multiplicaMatricesRacionales(A,B);
		System.out.println("\nLa multiplicacion de matrices es: \n");
		System.out.println(C.toString());
		
		B = op.inversaMatrizRacional(B);
		C = op.multiplicaMatricesRacionales(A,B);
		System.out.println("\nLa multiplicacion de matrices de A*Inv(B) es: \n");
		System.out.println(C.toString());
		
	}//FIN MAIN
}//FIN CALSE PRINCIPAL
