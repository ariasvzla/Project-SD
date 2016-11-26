public class LoteryGame{

    private int[] LoteryNumbers;
    private int[][] UserArr;
    private int count;
    private int[] GuessedN;




    public LoteryGame(){
    	LoteryNumbers= new int[5];
    	UserArr= new int[3][5];
    	GuessedN= new int[3];
    	count=0;
    }



	public void setMethod(int UserArr[][]){
		this.UserArr=UserArr;
	}

	public void compute(){

			  for (int i=0; i<5; i++){
					LoteryNumbers[i]= (int) (Math.random() * 40) +1;


		      }



		for (int i=0; i<3; i++){

                count=0;

			for (int j=0; j<5; j++){

                   for (int h=0; h<5; h++){
				      if (UserArr[i][j]==LoteryNumbers[h]){
					   count++;
         				}
			       }

			}

			GuessedN[i]=count;

		}


    }


    public 	int[] GetMethodCounter(){
		return GuessedN;
	}

	public int[] results(){
		return LoteryNumbers;
	}


}





















