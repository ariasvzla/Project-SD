
import javax.swing.JOptionPane;

public class LoteryGameApp{

  public static void main(String[] args){

  int[][] UserNumbers= new int[3][5];
  int[] MacthedNumbers=new int[3];
  int[][] NumbersG=new int[3][5];
  int [][] UserNumber=new int [3][5];
  int [] results=new int[5];

  LoteryGame myLoteryGame= new LoteryGame();



JOptionPane.showMessageDialog(null,"Welcome to the # "+((int) (Math.random() * 66) +1)+ " Lotery of the year please prees OK to continue" );


		for (int i=0; i<3; i++){
			for(int j=0; j<5 ; j++){

			UserNumber[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 5 Numbers between 1 and 40 for line # " + (i+1) ));

           if ((UserNumber[i][j]<1) || (UserNumber[i][j]>40)){
			   JOptionPane.showMessageDialog(null,"The number "+UserNumber[i][j]+" is not permited please enter a valid number BETWEEN 1 and 40 ");
		    		j=j-1;

			 }

		   }
		}

		myLoteryGame.setMethod(UserNumber);
		myLoteryGame.compute();

		MacthedNumbers=myLoteryGame.GetMethodCounter();



		results=myLoteryGame.results();




		System.out.println(" The Lotery results are");

		for (int h=0; h<5; h++){

			 System.out.print(" "+ results[h]);
		 }


		 System.out.println(" ");

		 System.out.println(" ");

		 System.out.println(" Your numbers: ");

				for (int d=0;d<3; d++){
					for(int e=0; e<5 ; e++){

			               System.out.print(" "+ UserNumber[d][e]);
					   }

		 System.out.println(" ");

				   }


	    System.out.println(" ");

		 for (int l=0; l<3; l++){

		 		    System.out.println("You have Guessed " + MacthedNumbers[l] + " numbers on the line # "+(l+1));
		}

		 System.out.println(" ");




	}

}









