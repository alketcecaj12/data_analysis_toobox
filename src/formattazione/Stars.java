package formattazione;

public class Stars{
	
public static void main(String args[]){ 

	int c=1;
for(int i=1; i<=5; i++){ // questo ciclo serve per stampare le righe della piramide.

for(int j=i; j<=5; j++){  // questo ciclo per stampare i spazi(punti) in ogni riga prima della stampa di un'asterisco
System.out.print("."); // dopo aver stampato i 5 punti il ciclo finisce
			}
     for(int k=1; k<=c; k++){// nella prima iterazione k%2 è diverso da zero quindi viene stampato l'asterisco
			if(k%2==0)
				System.out.print(".");
			else System.out.print("*");
			}
		System.out.println();// si inizia con una nuova riga 
		   c+=1;  // incremento c che dopo la prima iterazione vale 3
           }
     }
}
