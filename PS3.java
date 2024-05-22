/* Student Name: Brandon Evans
* Date: July 20, 2023
* Class: CS 3113 - AI
* Filename: PS3
* Description: Implementation of Gradient Descent
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PS3 {

	int count = 0;
	double sum = 0;
	double mean = 0;
	double sD = 0;
	
	private static final double TOLERANCE = 1E-11;
	
	ArrayList<Double> z = new ArrayList<Double>();
	
	public void readData() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/encry/OneDrive/Desktop/ps3data.csv"));
		String line;
		
		
		
		while ((line = br.readLine()) != null) {
			String[] value = line.split(",");
			for(int i = 0; i<value.length; i++) {
				try {
				sum += Double.valueOf(value[i]);
				}
				catch (NumberFormatException e) {
					System.out.println("Change file encoding to UTF-8.");
				}
				count++;
			}
				
		}
			
		br.close();
		
	}
	
	public void calcStandardDeviation() throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/encry/OneDrive/Desktop/ps3data.csv"));
		String line;
		mean = sum / count;
		double devSum = 0; 
		
		while ((line = br.readLine()) != null) {
			String[] value = line.split(",");
			for(int i = 0; i<value.length; i++) {
				devSum += Math.pow(Double.valueOf(value[i]) - mean, 2);
			}
			
		}
			
			sD = Math.sqrt(devSum/count);	
		
			br.close();
	}
	
	public void normalizeData() throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/encry/OneDrive/Desktop/ps3data.csv"));
		String line;
		
		
		
		while ((line = br.readLine()) != null) {
			
			z.add(1.0);
			String[] value = line.split(",");
			Double[] num = new Double[17]; 
			for(int i = 0; i<value.length; i++) {
				double zScore = (Double.valueOf(value[i]) - mean) / sD;
				z.add(zScore);
			}
			
			
			br.close();
			
		}
		
		FileWriter writerNormalized = new FileWriter("C:/Users/encry/OneDrive/Desktop/ps3dataNormalized.csv");
		
		int initial = 0;
		int iterator = 17;
		
		while(iterator <= z.size()) {
		for(int i = initial; i<iterator; i++) {
			
				writerNormalized.write(z.get(i)+",");
			
		}
		writerNormalized.write("\n");
		initial = iterator;
		iterator = iterator + 17;
	}
		writerNormalized.close();
		
		System.out.println("Files are done writing.");
		
	}
	
	public void calcLoss(double [] y, double[] yHat) {
		double loss = 0;
		for(int i = 0; i<y.length; i++) {
			loss+= Math.pow((y[i] - yHat[i]), 2); 
		}
	}
	
	public void calcYHat(double [] x, double [] w) {
		double yHat = 0;
		for(int i = 0; i<w.length; i++) {
			yHat += x[i] * w[i];
		}
	}
	public void train(double learningRate, double[][] trainingData) {
		double[] w = new double[17];
		int i = 0;
		
		while((Math.abs(0.0) + Math.abs(0.0)) > TOLERANCE);
	}
	
	public void differenceCost() {
		
	}
	
	public static void main(String[] args) throws IOException {
		PS3 a = new PS3();
		a.readData();
		a.calcStandardDeviation();
		a.normalizeData();
	    System.out.println("Count: " + a.count);
	    System.out.println("Sum: " + a.sum);
	    System.out.println("Mean: " + a.mean);
	    System.out.println("SD: " + a.sD);
	    System.out.println();
	    System.out.println(a.z);
	    
	}
}
