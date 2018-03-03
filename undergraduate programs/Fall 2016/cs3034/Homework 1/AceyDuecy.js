var readline = require('readline');
var rl = readline.createInterface(process.stdin, process.stdout);

console.log("Welcome! Enter 1 to continue, 0 to quit");
rl.setPrompt('AceyDeucy> ');
rl.prompt();

var deck = {
	
	RankArray: ["2 of", "3 of", "4 of", "5 of", "6 of", "7 of", "8 of", "9 of", "10 of", "Jack of", "Queen of", "King of", "Ace of"],
	
	SuitArray: ["Hearts", "Spades", "Diamonds", "Clubs"],
	
	DeckOfCards: [],
	
	size: 52,
	
	map:{},
	
	
	//Make a function that puts in all the numbers into the map

   
	

	//This function populates the cards into an array
	InitializeCards: function(x){
		for(var i = 0 ; i < 52 ; i++){
			deck.DeckOfCards[i] = i;
		}
	},

	//This function then shuffles the array ****** Cards is the array being passed in the parameters
	// Here is the source I used to implement shuffle http://stackoverflow.com/questions/2450954/how-to-randomize-shuffle-a-javascript-array
	shuffle: function(Cards){
				
		var index = Cards.length - 1;
		var randomIndex;
		var temp;
					
		while(index != 0){
			randomIndex = Math.floor(Math.random() * index);
			//console.log("The randomIndex was: " + randomIndex + ". The index it was switch with was: " + index);
			index -= 1;	
			
			
			
			temp = [index];
			Cards[index] = Cards[randomIndex];
			Cards[randomIndex] = temp;
						
			
		}
	return Cards;
	},



	//This function then creates a suite ****** x is a number variable that is being passed into this function
	// GetSuit : function(x){
		// var SuiteCheck = (x / 13);
		

		
		// if(SuiteCheck < 1)
			// return deck.suit[0];
		// else if(SuiteCheck >= 1 && SuiteCheck < 2)
			// return deck.suit[1];
		// else if(SuiteCheck >= 2 && SuiteCheck < 3)
			// return deck.suit[2];
		// else
			// return deck.suit[3];
		
	// },

	 // GetRank: function(x){
		
		// var GetRankString;
		
		// if(x == 0)
			// GetRankString = deck.RankArray[x];
		// else if(x == 1)
			// GetRankString = deck.RankArray[x];
		// else if(x == 2)
			// GetRankString = deck.RankArray[x];
		// else if(x == 3)
			// GetRankString = deck.RankArray[x];
		// else if(x == 4)
			// GetRankString = deck.RankArray[x];
		// else if(x == 5)
			// GetRankString = deck.RankArray[x];
		// else if(x == 6)
			// GetRankString = deck.RankArray[x];
		// else if(x == 7)
			// GetRankString = deck.RankArray[x];
		// else if(x == 8)
			// GetRankString = deck.RankArray[x];
		// else if(x == 9)
			// GetRankString = deck.RankArray[x];
		// else if(x == 10)
			// GetRankString = deck.RankArray[x];
		// else if(x == 11)
			// GetRankString = deck.RankArray[x];
		// else if(x == 12)
			// GetRankString = deck.RankArray[x];
		// else
			// GetRankString = deck.RankArray[x];
		
		// return GetRankString
	// },
	
	ColabInMap: function(){
		for(var i = 0 ; i < 52 ; i++){
			deck.map[i] = deck.RankArray[i%13] + " " + deck.SuitArray[Math.floor(i/13) + ""];
		}
	}
};

deck.InitializeCards();
deck.shuffle(deck.DeckOfCards);
deck.ColabInMap();
var Pot = 300;
var PlayerMoney = 50;

rl.on('line', function(line) {
    if (line === "0") rl.close();
	
		
	console.log("You drew: " + deck.map[deck.DeckOfCards[deck.size - 1]] + " and " + deck.map[deck.DeckOfCards[deck.size - 2]] + ".");
		
	
    rl.question("Enter a number", function(number){
        console.log(number);
        console.log("Enter 1 to play again, 0 to quit");
        rl.prompt();
		
		 var card_1 = ((deck.DeckOfCards[deck.size - 1] % 13) + 2);
		 var card_2 = ((deck.DeckOfCards[deck.size - 2] % 13) + 2);
		 var card_3 = ((deck.DeckOfCards[deck.size - 3] % 13) + 2);
		
		//console.log(deck.map[4]);
		console.log("You drew: " + deck.map[deck.DeckOfCards[deck.size - 3]]); 
		
		
		//An if statement that filters if the player loses from the draws
		//thirdLastCard < lastCard && thirdLastCard < secondLastCard) || (thirdLastCard > lastCard && thirdLastCard > secondLastCard) || (thirdLastCard == lastCard) || thirdLastCard == secondLastCard
		if((card_3 > card_1 && card_3 > card_2) || (card_3 == card_1) || (card_3 == card_2) || (card_3 < card_1 && card_3 < card_2)){
			PlayerMoney = (PlayerMoney - number);
			Pot = (300 + parseInt(number));
			console.log("You lost, $" + number + " from your wallet.\r");
			console.log("Your wallet now has: $" + PlayerMoney);
			console.log("The pot now has $" + Pot);
			
			
		}
		
		else{
			Pot = Pot - number;
			PlayerMoney = PlayerMoney + number;
			console.log("YOU WIN! You were awarded $" + number);
			console.log("You now have a total of $" + PlayerMoney);
			console.log("The pot now has $" + Pot);
		}
		
		
		deck.DeckOfCards.pop;
		deck.DeckOfCards.pop;
		deck.DeckOfCards.pop;
		deck.size = deck.size - 3;
		
		console.log("The amount of cards in the deck is: " + deck.size);
		
		//This if statement will determine if the deck is less than the amount of cards in the deck
		if(deck.size <= 3){
			deck.size = 52;
			deck.InitializeCards();
			deck.ColabInMap();
			deck.shuffle(deck.DeckOfCards);
		}
		
		//This if statement will check to see if Pot or Playermoney hits 0
		if(Pot <= 0 || PlayerMoney <= 0){
			console.log("You have LOST! Better luck next time!");
			process.exit(1);
		}
		
	});
	

}).on('close',function(){
    console.log("Thanks!");
    process.exit(0);
});