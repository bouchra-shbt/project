package ex;
import java.util.*;
public class cramersrule {
double A[][];
double m[][]; 
int N;
double B[];
public void input() {
Scanner s=new Scanner(System.in);
System.out.println("entez le nbr des équations de la matrice");
N=s.nextInt();
A = new double[N][]; 
for(int i=0;i<N;i++) {
    A[i]=new double[N];
    }
System.out.println("----entez les co-efficients des équations----"); 
for(int i=0;i<N;i++) {
    System.out.println("entez les co-efficients des équations" + (i+1));
    for(int j=0;j<N;j++) {
        double k=s.nextDouble();
        A[i][j]=k;
        }
        }
B = new double[N];
System.out.println("----entez la partie droite des équations----"); 
for(int i=0;i<N;i++){
    System.out.println("entrez la partie droite d'équation :" + (i+1));
    double k = s.nextDouble(); 
    B[i] = k; 
    }
}
public double determinantone(double A[][]) {
	       
        double determinant = A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1]); /*-
                            A[0][1] * (A[1][0] * A[2][2] - A[1][2] *A[2][0]) +
                            A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);*/
 
        return determinant;
    
}
public double determinanttwo(double A[][]) {
	  
    double determinant = -A[0][1] * (A[1][0] * A[2][2] - A[1][2] *A[2][0]);
                       
    return determinant;

}
public double determinanttrois(double A[][]) {
	   
    double determinant = A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
                        

    return determinant;

}
public double determinant(double A[][],int N) {
double det=0; 
double res;
if(N == 1)
    res = A[0][0];
else if(N == 2) {
    res = (A[0][0]*A[1][1]) - (A[1][0]*A[0][1]);
    }
else{
    res=0; 
    for(int j1=0;j1<N;j1++) { 
        m = new double[N-1][]; 
        for(int k=0;k<(N-1);k++)
            m[k] = new double[N-1];
        for(int i=1;i<N;i++) {
            int j2=0; 
            for(int j=0;j<N;j++) { 
                if(j == j1)
                    continue; 
                m[i-1][j2] = A[i][j]; 
                j2++;
                } 
                } 
        res += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m,N-1);
             }
        }
        return res;
    }

public double[] cramers(double A[][],double B[]) {
    double temp[][] = new double[N][N];
    double x[] = new double[N]; 
    for(int i=0;i<N;i++) {
        for(int j=0;j<N;j++){ 
            for(int k=0;k<N;k++){
                if(k == i) 
                    temp[j][k] = B[j];
                else temp[j][k] = A[j][k];
}
}
x[i]=determinant(temp,N)/determinant(A,N);
}
for(int i=0;i<N;i++){ 
   System.out.println(x[i]);
    } 
    return x;
}
public static void main(String args[]){
    double res;
cramersrule d = new cramersrule();
d.input(); 
d.cramers(d.A,d.B);
}
}

