class Polynomial{

	double[] coefficients;
	int[] powers;
	Polynomial(){
		coefficients = new double[1];
		coefficients[0] = 0;
		power = new int[1];
		power[0] = 0;
	}
	Polynomial(double[] coefficients, int[] powers){
		this.coefficients = coefficients;
		this.powers = powers;
	}
	Polynomial add(Polynomial poly){
		
		
		return new Polynomial(n);
	}

	double evaluate(double num){
		double r = 0;
		for(int i = 0; i < coefficients.length; i ++){
			r += coefficients[i] * Math.pow(num, i);
		}
		return r;
	}
	boolean hasRoot(double num){
		return evaluate(num) == 0;
	}
	

}
