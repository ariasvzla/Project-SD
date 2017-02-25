/*
*Arias, Elianny / Minguett, Olga
*LotteryGame.java
*28th Nov, 2016
*/

//Class Signature (Part 1 Olga Minguett)
public class LotteryGame{

    //Data member
    private int[] lotteryNumbers;
    private int[][] userArr;
    private int count;
    private int[] guessedN;
    private int i;

	//Constructor (Part 1 Olga Minguett)
	//Initilisation of the data members
    public LotteryGame(){
    	guessedN= new int[3];
    	lotteryNumbers= new int[5];
    	userArr= new int[3][5];
    	count=0;
    	i=0;
    }

    //Setters(Part 2 Olga Minguett)
    //It will get the number from the main method
	public void setMethod(int userArr[][]){
		this.userArr=userArr;
	}

	//Compute (Part 3 Elian Arias)
	public void compute(){
		//For loop to generate random numbers to be store in the array
		//Lottery Number between 1 and 40
		for (i=0; i<5; i++){
			lotteryNumbers[i]= (int) (Math.random() * 40) +1;
			for (int j=0; j<i; j++){
				// If statement to avoid repeated numbers be stored
				//in the Lottery number array
				if (lotteryNumbers[i]==lotteryNumbers[j]){
					//Go back one space and store different values
					i=i-1;
				}
			}
		}

		//For loop to check the user's numbers against the Lottery's number
		//For loop to transverse rows in the userArr variable
		for (int k=0; k<3; k++){
			//count variable to reset the counter, so can check the match
			//number in comparison with the user and lottery, for each line
			count=0;
			//For loop to transverse columns in the userArr array
			for (int l=0; l<5; l++){
				//for loop to transverse LotteryNumber array
				for (int m=0; m<5; m++){
					//If statement to count the matches between the user number
					//and the lottery number
					if (userArr[k][l]==lotteryNumbers[m]){
						count=count+1;
					}
				}
			}
			//To store how many times per line the user guess a number
			guessedN[k]=count;
		}
	}

	//getter (Part 4 Olga Minguett)
    //It will return how many times the user guess per line a number
    public int[] getMethodCounter(){
		return guessedN;
	}
	//It will show the lottery number result
	public int[] getResults(){
		return lotteryNumbers;
	}
}


































