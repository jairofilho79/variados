/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author 201604940016
 */
public class Time {
    private int timeA; 
    private int timeB;
    private char[] gol;
    private char[] gol2;
    private char aux;
    private char[][] gol22;

    public Time(int timeA, int timeB) {
        this.timeA = timeA;
        this.timeB = timeB;
        gol = new char[timeA+timeB];
        gol2 = new char[timeA+timeB];
        gol22 = new char[(int)(combinacao(timeA,timeB))][timeA+timeB];
    }
    
    private void vetor(){
        for (int i = 0; i < timeA; i++) {
            gol[i] = 'A';
            gol2[i] = 'B';
        }
        for (int i = timeA; i < timeA+timeB; i++) {
            gol[i] = 'B';
            gol2[i] = 'A';
        }
    }
    private int combinacao(int x, int y){
        int c = fat(x)/(fat(y)*fat(x-y));        
        return c;
    }
    private int fat(int x){
        int fatorial = 1;
        for (int i = 1; i <=x; i++) {
            fatorial *=i;            
        }
        return fatorial;
    }
    
    public void faz(){
        vetor();
        int t = timeA-1;
        int u = -1;
        int l=0,l1;
        for (int i = 0; i < timeB; i++) {
            t++;u++;
            for (int j = t; j>u ; j--) {
                aux = gol[j-1];
                gol[j-1] = gol[j];
                gol[j] = aux;
            }
            for (int j = t; j>u ; j--) {
                aux = gol[j-1];
                gol[j-1] = gol[j];
                gol[j] = aux;
            }
            l1 = l;
            for (int j = 0; j < l1; j++) {
                for (int k = 0; k < timeA+timeB; k++) {
                    if(gol[k]!=gol22[j][k]){
                     gol22[j] = gol;
                     l++;
                 }
                    if(gol[k]!=gol22[j][k]){
                        if(l1!=l){
                           gol22[j+1][k] = gol[k];
                           l++; 
                        }
                        else{
                           gol22[j][k] = gol[k];
                           l++;
                        }
                    }                    
                }
                 
            }
        }
        for (int i = 0; i < (int)(combinacao(timeA,timeB)); i++) {
            for (int j = 0; j < timeA+timeB; j++) {
                System.out.println(gol22[i][j]);                
            }
            System.out.println(gol22[0][0]);
            
        }
    }
    
    
    public static void main(String[] args) {
        Time remo = new Time(2,2);
        
        remo.faz();
    }
    
}
