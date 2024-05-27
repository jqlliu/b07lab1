class Polynomial{

	double[] coefficients;
	int[] powers;
	Polynomial(){
		coefficients = new double[1];
		coefficients[0] = 0;
		powers = new int[1];
		powers[0] = 0;
	}
	Polynomial(double[] coefficients, int[] powers){
		this.coefficients = coefficients;
		this.powers = powers;
	}
	Polynomial add(Polynomial poly){
		int max = 0;
		for(int i: poly.powers){
			max = Math.max(max, i);
		}
		for(int i: powers){
			max = Math.max(max, i);
		}
		
		double[] arr = new double[max + 1];
		for(int i = 0; i < poly.coefficients.length; i ++){
			arr[poly.powers[i]] += poly.coefficients[i];
		}
		for(int i = 0; i < coefficients.length; i ++){
			arr[powers[i]] += coefficients[i];
		}
		
		int count = 0;
		for(int i = 0; i < arr.length; i ++){
			if(arr[i] != 0){
				count ++;
			}
		}
		
		double[] coeffs = new double[count];
		int[] pow = new int[count];
		int d = 0;
		for(int i = 0; i < arr.length; i ++){
			if(arr[i] != 0){
				coeffs[d] = arr[i];
				pow[d] = i;
				d ++;method
			}
		}
		
		return new Polynomial(coeffs, pow);
	}
	Polynomial multiply(Polynomial poly){
		int max1 = 0;
		int max2 = 0;
		for(int i: poly.powers){
			max1 = Math.max(max1, i);
		}
		for(int i: powers){
			max2 = Math.max(max2, i);
		}
		int max = max1 + max2; 
		
		for(int i = 0; i < poly.length; i ++){
		
		}
	]

	double evaluate(double num){
		double r = 0;
		for(int i = 0; i < coefficients.length; i ++){
			r += coefficients[i] * Math.pow(num, powers[i]);
		}
		return r;
	}
	boolean hasRoot(double num){
		return evaluate(num) == 0;
	}
	

}
