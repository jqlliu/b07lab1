class Polynomial{

	double[] coefficients;
	Polynomial(){
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	Polynomial(double[] coefficients){

		this.coefficients = coefficients;

	}
	Polynomial add(Polynomial poly){
		int more = Math.max(coefficients.length, poly.coefficients.length);
		double[] n = new double[more];
		for(int i = 0; i < poly.coefficients.length; i ++){
			n[i] += poly.coefficients[i];
		}
		for(int i = 0; i < coefficients.length; i ++) {
			n[i] += coefficients[i];
		}

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