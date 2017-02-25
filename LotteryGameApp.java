/*
*Arias, Elianny / Minguett, Olga
*LotteryGame.java
*28th Nov, 2016
*/

//Import util package (Part 1 Olga Minguett)
import javax.swing.JOptionPane;

//Class Signature (Part 1 Olga Minguett)
public class LotteryGameApp{

	//Main method (Part 1 Olga Minguett)
	public static void main(String[] args){

		//Data members (Part 1 Olga Minguett)
		int[] MatchedNumbers=new int[3];
		int [][] UserNum=new int [3][5];
		String UserNumber="";
		int [] results=new int[5];
		boolean play=true;
		//This data member is created to evaluate against the user number entered (Part 1.1 Elian Arias)
		String []Verify={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"};
  		int j=0;
  		boolean match=false;
  		int reply = JOptionPane.YES_NO_OPTION;

  		//While loop to repeate the lottery game as many time the user want it to play
  		while(play==true){
			//Create object (Part 1 Olga Minguett)
			LotteryGame myLotteryGame= new LotteryGame();

			//Message showed everytime the user runs the app to welcome him (Part 1 Olga Minguett)
			JOptionPane.showMessageDialog(null,"Welcome to the # "+((int) (Math.random() * 66) +1)+ " Lottery of the year, Please press OK to continue..." );

			//Nested For loop to insert the evaluate the number that the user entered against the verify array previuous filled with numbers from 1 to 40 (Part 2 Olga Minguett)
			for ( int i=0; i<3; i++){
				JOptionPane.showMessageDialog(null,"Enter a Number BETWEEN 1 and 40");
				for(j=0; j<5 ; j++){
					//reset the match variable to false to evaluate every number otherwise it will be true
					match=false;
					//the data that the user will entered is assign as a String to evaluate against the array previous filled called Verify[](Part 2.1 Olga Minguett)
					UserNumber=JOptionPane.showInputDialog(null, "Line N° "+(i+1));
					for (int k=0; k<40; k++){
						if (UserNumber.equals(Verify[k])){
							//when a number is found match value change to true.
							match=true;
							//this line parse to Integer from String entered by the user to be evaluate againt the lotery numbers.
							UserNum[i][j]=Integer.parseInt(UserNumber);
						}
					}
					if (match==false){
						//Message to tell the user that t]he number is not permitted because it's not between the range (Part 2 Olga Minguett)
						JOptionPane.showMessageDialog(null,"Incorrect value!!! Please enter a valid number BETWEEN 1 and 40" );
						//this line sends back the for loop one space to ask for a valid number.
						j=j-1;
					}// this for loop evaluate the user number entered when a number is repeated in one single line.
					for (int g=0; g<j; g++){
						if (UserNum[i][j]==UserNum[i][g]){
							JOptionPane.showMessageDialog(null,"The number "+UserNum[i][j]+" has been picked, Please enter a different one!!!");
							j=j-1;
						}
					}
				}
			}

			//Mutator (Set) method (Part 2 Olga Minguett)
			myLotteryGame.setMethod(UserNum);

			//Compute method to execute the instantiable class (Part 2 Olga Minguett)
			myLotteryGame.compute();

			//Accesor (Get) method (Part 2 Olga Minguett)
			MatchedNumbers=myLotteryGame.getMethodCounter();
			results=myLotteryGame.getResults();

			//Prints the Lottery results (Part 2 Olga Minguett)
			System.out.println("The Lottery results are... ");
			for (int h=0; h<5; h++){
				System.out.print(" "+ results[h]);
			}

			//Space lines between text
			System.out.println();
			System.out.println();

			//Prints the number selected for the user
			System.out.println(" Your numbers are: ");

			//For loop to print the numbers that the user has entered
			for (int d=0;d<3; d++){
				for(int e=0; e<5 ; e++){
					System.out.print(" "+ UserNum[d][e]);
				}
				//Space line
				System.out.println();
			}
			//Space line
			System.out.println();

			//For loop to print how many numbers the user has guessed per line (Part 3 Elian Arias)
			for (int l=0; l<3; l++){
				System.out.println("You have Guessed " + MatchedNumbers[l] + " numbers on the line # "+(l+1));
				//if statement to print a comment if the user matched the 5 numbers
				//in the lottery game
				if (MatchedNumbers[l]==5){
					System.out.print("Congratulations you have won the lottery");
					break;
				}
			}
			//Space line
			System.out.println();


             //Show a box asking if the user wants to play again the lotery (Part 3 Elian Arias)
			JOptionPane.showConfirmDialog(null, "Would you like to buy another ticket?","LotteryGame", reply);
			//evaluate user answer
			if (reply==JOptionPane.NO_OPTION){
				//set play variable to false when the user press the No button
				play=false;
				System.out.println("Thank you for playing the lottery ");
				System.exit(0);
				//evaluate user answer when the user press YES
				}else if (reply==JOptionPane.YES_OPTION){
                    //create new data members to set a cost for each ticket
					double ticketPrice=10.00;
					double dif=0.0;
					double count=0.0;
					double money=0.0;

					money=Double.parseDouble(JOptionPane.showInputDialog(null,"Please pay " +ticketPrice+ " euros to buy a ticket"));
					//compute the difference between the ticket price and the amount of money inserted from the user
					dif=ticketPrice-money;
					count=money+count;

					//set play to false to evaluate the data entered
					play=false;

					while(play==false){
                     //this evaluate if the user has entered a value less than the ticket cost (Part 3 Elian Arias)
                    if (dif>0.0){
                   //system ask user to enter the difference between the money entered and the ticket price
				    money=Double.parseDouble(JOptionPane.showInputDialog(null,"Please add " + dif +" euros to complete the transacction"));
                   // this will store the amoun of money that the user enter
	         	    count=money+count;
	         	   //this calculate how much is the difference between the ticket price and the money that the user has entered.
	         	    dif=ticketPrice-count;
				}

			        //Evaluate when the user finally enter the correct amount (Part 4 Elian Arias)
			   		else if (count==ticketPrice){

				  		JOptionPane.showMessageDialog(null,"Thank you for your payment. Good luck!!!");

				  		//set play to true to enable user to play again
				  		 play=true;
					 }

                     //this will show a message with the change when a user enter an amount grater than the ticket value
			   		else{
				   		JOptionPane.showMessageDialog(null,"Your change is "+(count - ticketPrice)+" euros. Thank you for your payment. Good luck!!!1");
				   		//set play to true to enable user to play again
				   		play=true;
					}
			   }
		   }
	   }
   }
}






