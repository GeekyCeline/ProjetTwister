package services;

public class Operation {
	private double a;
	private double b;
	private String s;
	
	
	public Operation(double a, double b, String s){
		this.a = a ;
		this.b = b;
		this.s = s;
	}
	
	public double addition(double a, double b) {
		return a + b;
	}
	
	public double division(double a, double b) {
		return a / b;
	}
	
	public double multiplication(double a, double b) {
		return a * b;
	}
	
	public double calcul(double a, double b, String s) {
		if(s.equals("+")){
			return addition(a, b);
		} else {
			if (s.equals("*")){
				return multiplication(a, b);
			} else {
				return division(a, b);
			}
		}
	}
	
	public String toString(){
		return this.a + this.s + this.b + "=" + calcul(this.a, this.b, this.s);
	}
}
