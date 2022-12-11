/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import java.util.Random;

/**
 *
 * 
 */
public class Fraccion {
    private int num;
    private int denom;
    
    public Fraccion(){
        this.setRandNum();
        this.setRandDenom();
    }

    public Fraccion(int n, int m){
        this.num = n;
        this.denom = m;
    }
    
    public Fraccion sumar(Fraccion f2) {
        Fraccion resultado = new Fraccion();
            resultado.setNum(this.num*f2.getDenom() + f2.getNum()*this.denom);
            resultado.setDenom(this.denom*f2.getDenom());
            return resultado;
        
    }

    public Fraccion sumar(int numSum, int denomSum) {
        Fraccion resultado = new Fraccion();
            resultado.setNum(this.num*denomSum + numSum*this.denom);
            resultado.setDenom(this.denom*denomSum);
            return resultado;
        
    }

    public Fraccion restar(int numRes, int denomRes) {
        Fraccion resultado = new Fraccion();
            resultado.setNum(this.num*denomRes - numRes*this.denom);
            resultado.setDenom(this.denom*denomRes);
            return resultado;
    }

    public Fraccion multiplicar(int numMul, int denomMul) {
        Fraccion resultado = new Fraccion();
            resultado.setNum(this.num* numMul );
            resultado.setDenom(this.denom*denomMul);
            return resultado;
    }

    public Fraccion dividir(int numDiv, int denomDiv) {
        Fraccion resultado = new Fraccion();
            resultado.setNum(this.num*denomDiv);
            resultado.setDenom(this.denom*numDiv);
            return resultado;
    }
    
    public Fraccion restar(Fraccion f2) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(this.num*f2.getDenom() - f2.getNum()*this.denom);
            resultado.setDenom(this.denom*f2.getDenom());
            return resultado;
    }
    
    public Fraccion multiplicar(Fraccion f2) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(this.num*f2.getNum());
            resultado.setDenom(this.denom*f2.getDenom());
            return resultado;
    }
    
    public Fraccion dividir(Fraccion f2) {
        Fraccion resultado = new Fraccion();
        resultado.setNum(this.num*f2.getDenom());
        resultado.setDenom(this.denom*f2.getNum());
        return resultado;
    }
    
    
    public int mcd(int m, int n){
        int r= n % m;
        while (r != 0){
            n=m;
            m=r;
            r=n % m;
        }
        
        return m;
    }
    
    public Fraccion simplificar(Fraccion f){
        Fraccion resultado = new Fraccion();
        
            System.out.println("   " );
            
            
            return resultado;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }
    
    public void setRandNum(){
        Random rand = new Random();
        this.num = rand.nextInt(10 - 1) + 1;
    }

    public void setRandDenom(){
        Random rand = new Random();
        this.denom = rand.nextInt(10 - 1) + 1;
    }

    public String toString(){
        return ("NUMERADOR: "  + getNum() + " DENOMIDAOR : " +  getDenom());
    }
}
