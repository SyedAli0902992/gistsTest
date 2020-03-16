package gists;

import java.util.ArrayList;
import java.util.List;

public class practiseCoding {
	
	
	static List<Integer> getSubsets(int[] set) 
    { 
        int n = set.length; 
        List<Integer> subset ;
        List<Integer> biggestsubset = new ArrayList<Integer>();
        // Run a loop for printing all 2^n 
        // subsets one by one 
        double greatestDiff = 0;
        for (int i = 0; i < (1<<n); i++) 
        { 
        	subset = new ArrayList<Integer>();
            // Print current subset 
            for (int j = 0; j < n; j++) {
  
                // (1<<j) is a number with jth bit 1 
                // so when we 'and' them with the 
                // subset number we get which numbers 
                // are present in the subset and which 
                // are not 
                if ((i & (1 << j)) > 0) {
                	subset.add(set[j]);
                }
            }
            System.out.println("test gits");
            double diff = findDiffMeanMedian(subset);
            if(diff>greatestDiff){
            	greatestDiff = diff;
            	biggestsubset = subset;
            }
        } 
       
       return biggestsubset;
        
        
    }
	
	
	public static void main(String[] args) 
    { 
		int[] arr = {1,2,3,4};
        List<Integer> biggestsubset = getSubsets(arr);
        System.out.println(biggestsubset.toString());
    } 
	
	
	static double findDiffMeanMedian(List<Integer> arr) {
		if(arr.size()>1) {
		return findMean(arr)-findMedian(arr);
		}
		else if(arr.size()==1) {
		return 0;
		}
		else return 0;
		
	}
	
	static double findMean(List<Integer> arr) {
		double sum = 0 ;
		double mean = 0;
		;
		for(int i = 0;i<arr.size();i++) {
			sum = sum+arr.get(i);
		}
		mean = sum/arr.size();
		return mean;
	}

	static double findMedian(List<Integer> arr) {
		int length =0;
		double median =0;
		if(arr.size()%2 != 0) {
			length = (arr.size()+1)/2;
			 median =arr.get(length-1);
			return median;
		}else {
			length = (arr.size())/2;
			median = arr.get(length-1)+arr.get(length);
			median = median/2;
			return median;
		}
	}
}
