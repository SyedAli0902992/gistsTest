package gists;

public class practise2 {

	
	public static void main(String[] args) 
    { 
  int[] arr = {3,2};
  String power = "pnp";
  int len = 2;

	System.out.println(calculateCharge(arr,power,len));	
    }
	
public static double calculateCharge(int[] arr,String comb,int len) {
	int sum = 0;
	
	for(int i =0;i<len;i++)
	{
		int ascii = comb.charAt(i);
	if(ascii == 112)	{
		sum = sum +arr[i];
	}
	else {
		sum = sum- arr[i];
	}
	}

	return sum*100;	
}	

}
