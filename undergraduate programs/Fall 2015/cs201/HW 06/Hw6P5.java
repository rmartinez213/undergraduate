import java.util.Scanner;
public class Hw6P5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("|                 Welcome to the token game!                         |");
		System.out.println("|--------------------------------------------------------------------|");
		GenerateIntro();
	}

	public static void GenerateIntro(){
		while(true){
			Scanner input = new Scanner(System.in);
			//This variable is for the amount of tokens in the game
			int generate = 10 + (int)(Math.random() * (100 - 10 + 1));
			//This variable generates intro settings and determines who goes first
			int GenerateIntro =  1 + (int)(Math.random() * (2 - 1 + 1));
			//This variable will determine the difficulty of the AI
			int GenerateDifficulty =  1 + (int)(Math.random() * (2 - 1 + 1));
			//If Generate 1 Game is on easy!
			if(GenerateDifficulty == 1){
				System.out.println("Game is on Easy!");
				System.out.println("The amount of tokens in this game are: " + generate);
				while (generate != 0){
					getEasyIntro(GenerateIntro);
					for(int z = GenerateIntro; generate > 0 ;){
						if(z % 2 == 1){

							System.out.print("Enter how many tokens you want: ");
							int SubtractPile = input.nextInt();
							System.out.println();
							if ((SubtractPile <= generate / 2 && SubtractPile > 0) || SubtractPile == 1){
								generate = generate - SubtractPile;
								System.out.println("How much is left in the pile: " + generate);
								z++;
								if(generate == 0){
									System.out.println("You Lose! Tough luck, better luck next time!");
								}
							}
							else if (SubtractPile == 0){
								System.out.println("You must take atleast 1 token! Try again");
							}
							else if (SubtractPile < 0){
								System.out.println("You cannot take negative amount of coins! Try again!");
							}
							else{
								System.out.println("Taking too many tokens! Try again.");
							}

						}
						else if(z % 2 == 0){
							generate = EasyAiGenerate(generate);
							z++;
							if(generate == 0)
								System.out.println("You Win!");
						}
					}
				}
			}

			else{

				getHardIntro(GenerateIntro, generate);

				while (generate != 0){
					for(int z = GenerateIntro; generate > 0 ;){
						if(z % 2 == 1){
							System.out.print("Enter how many tokens you want: ");
							int SubtractPile = input.nextInt();
							System.out.println();
							if ((SubtractPile <= generate / 2 && SubtractPile > 0) || SubtractPile == 1){
								generate = generate - SubtractPile;
								System.out.println("How much is left in the pile: " + generate);
								z++;
								if(generate == 0){
									System.out.println("You Lose! Tough luck, better luck next time!");
								}
							}
							else if (SubtractPile == 0){
								System.out.println("You must take atleast 1 token! Try again");
							}
							else if (SubtractPile < 0){
								System.out.println("You cannot take negative amount of coins! Try again!");
							}
							else{
								System.out.println("Taking too many tokens! Try again.");
							}

						}

						else if(z % 2 == 0){
							generate = HardMode(generate);
							System.out.println("How much is left in the pile: " + generate);
							z++;

							if(generate == 0){
								System.out.println("You Win!");
							}
						}
					}
				}
			}
			getEnding(generate);
		}
	}

	public static void getEasyIntro(int GenerateIntro){
		//These if statements will print out who goes first
		if(GenerateIntro == 1){
			System.out.println("User Starts!\n");
		}
		else if (GenerateIntro == 2){
			System.out.println("Ai Starts!\n");
		}
	}

	public static int EasyAiGenerate(int generate){
		int AiGenerate = 1 + (int)(Math.random() * ((generate / 2) - 1 + 1));
		generate = generate - AiGenerate;
		System.out.println("The AI takes: " + AiGenerate);
		System.out.println("How much is left in the pile: " + generate);
		return generate;
	}

	public static int HardMode(int tokens){
		int PileAmount = tokens;
		int TokenAmount = tokens;
		if ((PileAmount == 63) || (PileAmount == 31) || (PileAmount == 15) || (PileAmount == 7) 
				|| (PileAmount == 3)){
			int AiGenerate = 1 + (int)(Math.random() * ((tokens / 2) - 1 + 1));
			TokenAmount = tokens - AiGenerate;
			System.out.println("Ai takes: " + AiGenerate);
		}
		else if (PileAmount >= 64){
			TokenAmount = tokens - 63;
			System.out.println("Ai takes: " + 63);
		}
		else if (PileAmount >= 32){
			TokenAmount = tokens - 31;
			System.out.println("Ai takes: " + 31);
		}
		else if (PileAmount >= 16){
			TokenAmount = tokens - 15;
			System.out.println("Ai takes: " + 15);
		}
		else if (PileAmount >= 8){
			TokenAmount = tokens - 7;
			System.out.println("Ai takes: " + 7);
		}
		else if (PileAmount >= 4){
			TokenAmount = tokens - 3;
			System.out.println("Ai takes: " + 3);
		}
		else if (PileAmount >= 2){
			TokenAmount = tokens - 1;
			System.out.println("Ai takes: " + 1);
		}
		else if (PileAmount == 1){
			TokenAmount = tokens - 1;
			System.out.println("Ai takes: " + 1);
		}
		return TokenAmount;

	}
	public static void getHardIntro(int GenerateIntro, int generate){
		System.out.println("Game is on Hard!");
		System.out.println("The amount of tokens in this game are: " + generate);
		//This if statement will print out who goes first
		if(GenerateIntro == 1){
			System.out.println("User Starts!\n");
		}
		else if (GenerateIntro == 2){
			System.out.println("Ai Starts!\n");
		}
	}

	public static void getEnding(int generate){
		Scanner input = new Scanner(System.in);
		if (generate == 0 || generate < 0){
			System.out.println();
			System.out.println("Would you like to play again? ");
			System.out.print("0 for yes. 1 for no: ");
			int YesOrNo = input.nextInt();
			System.out.println();

			if(YesOrNo == 0){
				System.out.println("New game begins now!");
			}
			else if(YesOrNo == 1){
				System.out.println("The game will now close! Thanks for playing!");
				System.exit(1);
			}
		}
	}
}



