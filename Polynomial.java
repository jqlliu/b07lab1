import java.util.*;
import java.io.*;
class Polynomial {

	double[] coefficients;
	int[] powers;

	Polynomial() {
		coefficients = new double[1];
		coefficients[0] = 0;
		powers = new int[1];
		powers[0] = 0;
	}

	Polynomial(double[] coefficients, int[] powers) {
		this.coefficients = coefficients;
		this.powers = powers;
	}

	Polynomial(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		String ln = in.nextLine();
		ln = ln.replaceAll("-", "\\+-");

		if(ln.charAt(0) == '+'){
			ln = ln.substring(1);
		}

		String[] lst = ln.split("\\+");


		int max = 0;
		HashMap<Integer, Double> map = new HashMap<>();
		for(String v:lst){
			String[] s = v.split("x");
			double n = Double.parseDouble(s[0]);
			if(n != 0) {
				int p = 0;
				if (s.length > 1) {
					p = Integer.parseInt(s[1]);
				}
				if (map.containsKey(p)) {
					map.put(p, map.get(p) + n);
				} else {
					map.put(p, n);
				}
			}
		}


		powers = new int[map.size()];
		coefficients = new double[map.size()];
		int i = 0;
		for(HashMap.Entry<Integer, Double> v: map.entrySet()){

			coefficients[i] = v.getValue();
			powers[i] = v.getKey();
			i ++;
		}




	}

	void saveToFile(String f) throws IOException{
		File file = new File(f);
		FileWriter out = new FileWriter(file);
		String a = "";

		for(int i = 0; i < coefficients.length; i ++){
			String cof =  Double.toString(coefficients[i]);
			a = a + ((cof.charAt(cof.length() - 1) == '0' && cof.charAt(cof.length() - 2) == '.')?(int)coefficients[i]:cof)  +  (powers[i] == 0?"":("x" + powers[i])) + ((i + 1 >= coefficients.length || coefficients[i + 1] < 0)?"":"+");
		}
		System.out.println(a);
		out.write(a);
		out.close();
	}
	Polynomial add(Polynomial poly) {
		int max = 0;
		for (int i : poly.powers) {
			max = Math.max(max, i);
		}
		for (int i : powers) {
			max = Math.max(max, i);
		}

		double[] arr = new double[max + 1];
		for (int i = 0; i < poly.coefficients.length; i++) {
			arr[poly.powers[i]] += poly.coefficients[i];
		}
		for (int i = 0; i < coefficients.length; i++) {
			arr[powers[i]] += coefficients[i];
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				count++;
			}
		}

		double[] coeffs = new double[count];
		int[] pow = new int[count];
		int d = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				coeffs[d] = arr[i];
				pow[d] = i;
				d++;
			}
		}

		return new Polynomial(coeffs, pow);
	}
	
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

	Polynomial multiply(Polynomial poly) {
		int max1 = 0;
		int max2 = 0;
		for (int i : poly.powers) {
			max1 = Math.max(max1, i);
		}
		for (int i : powers) {
			max2 = Math.max(max2, i);
		}
		int max = max1 + max2;
		double[] arr = new double[max];
		for (int i = 0; i < poly.powers.length; i++) {
			for (int j = 0; j < powers.length; j++) {
				arr[poly.powers[i] + powers[j]] += poly.coefficients[i] * coefficients[j];
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				count++;
			}
		}

		double[] coeffs = new double[count];
		int[] pow = new int[count];
		int d = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				coeffs[d] = arr[i];
				pow[d] = i;
				d++;
			}
		}
		return new Polynomial(coeffs, pow);
	}


}