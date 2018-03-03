'''
Created on Oct 2, 2016

@author: Robert
'''
import random



#Creates the map with the keys corresponding to the rank
#               1           2           3           4           5               6       7           8           9           10                  11              12              13
Rank_Dict = {0: "2 of ", 1: "3 of ", 2: "4 of ", 3: "5 of ", 4: "6 of ", 5: "7 of ", 6: "8 of ", 7: "9 of ", 8: "10 of ", 9: "Jack of ", 10: "Queen of ", 11: "King of ", 12: "Ace of "}
#Empty dictionary that will store every rank and suit
Rank_Dict2 = {}
#Generate random number for the cards
import random
GetCards = [x for x in range (52)]
random.shuffle(GetCards)
print(GetCards)

#increments variable 
add = 0

#Variable that helps iterate through the loop
i = 0

#initial player amount
player = 30



print("Player amount:" , player)

#Loop that concatenates ranks to suits
while i < 52:
    if(i < 13):
        temp = i % 13
        Rank_Dict2[i] = Rank_Dict[temp] + "hearts"
    elif(i >= 13 and i < 26):
        temp = i % 13
        Rank_Dict2[i] = Rank_Dict[temp] + "clubs"
    elif(i >= 26 and i < 39):
        temp = i % 13
        Rank_Dict2[i] = Rank_Dict[temp] + "diamonds"
    else:
        temp = i % 13
        Rank_Dict2[i] = Rank_Dict[temp] + "spades"
        
    #print(Rank_Dict2[i])
    i += 1




while True:
    
    VarNum = input("Enter 1 to play, 0 to quit: ")
    
    if VarNum == '1':
        print("You want to play!")
        
        #Gives player 2 cards
        UserC1 = Rank_Dict2[GetCards[add]]
        card1 = GetCards[add]
        print("\nYour first card is: ", UserC1)
        add += 1
        
        UserC2 = Rank_Dict2[GetCards[add]]
        card2 = GetCards[add]
        add += 1
        print("Your second card is: ", UserC2)
        
        #Give computer 2 cards
        ComputerC1 = Rank_Dict2[GetCards[add]]
        print("\nComputer's card was: ", ComputerC1)
        card3 = GetCards[add]
        add += 1
        
        ComputerC2 = Rank_Dict2[GetCards[add]]
        card4 = GetCards[add]
        add += 1
        
        #used to check if two aces AND two same ranks 
        SameR1 = card1 % 13
        SameR2 = card2 % 13
        SameR3 = card3 % 13
        SameR4 = card4 % 13
        
        #two same flush
        SameF1 = card1 // 13
        SameF2 = card2 // 13
        SameF3 = card3 // 13
        SameF4 = card4 // 13
        
        #Prints the suits
        '''
        print("Card1 suit", SameF1)
        print("Card1 suit", SameF2)
        print("Card1 suit", SameF3)
        print("Card1 suit", SameF4)
        '''
        
        VarNumString = input("How much would you like to bet this round? ")
        VarNum2 = int(VarNumString)
        
        print("\nComputer's second card was: ", ComputerC2)
        
        #two aces
        if ((SameR4 == 0) and (SameR3 == 0)):
            print("Computer wins: Two Aces")
            player -= VarNum2
        
        elif ((SameR1 == 0) and (SameR2 == 0)):
            print("Player wins: Two Aces")
            player += VarNum2
        
        #same ranks       
        elif (SameR4 == SameR3):
            print("Computer wins: Same Rank")
            player -= VarNum2
           
        elif (SameR1 == SameR2):
            print("Player wins: Same Rank")
            player += VarNum2
            
        #Same suite... Checks to see if both have same suit, if they do then checks for better rank
        elif((SameF1 == SameF2) and (SameF3 == SameF4)):
            print("All four cards are in the same suit.")
            if((SameR4 + SameR3) >= (SameR1 + SameR2)):
                print("Computer has highest total value of cards.")
                player -= VarNum2
            elif ((SameR4 + SameR3) < (SameR1 + SameR2)):
                print("User has highest total value of cards.")
                player += VarNum2
                     
        elif((SameF3 == SameF4) and SameF1 != SameF2):
            print("Computer has matching cards in the same suit")
            player -= VarNum2
        
        elif((SameF1 == SameF2) and (SameF3 != SameF4)):
            print("Player has matching cards in the same suit")
            player += VarNum2
        
        #Compares the rank
        elif ((SameR4 + SameR3) >= (SameR1 + SameR2)):
            print("Computer has highest total value of cards")
            player -= VarNum2
            
        elif ((SameR4 + SameR3) < (SameR1 + SameR2)):
            print("Player has highest total value of cards")
            player += VarNum2
            

        print("Player now has: $", player)
        
        if player <= 0:
            print("\nPlayer has no more money.")
            break;

        if add >= 49:
            print("\nThere are no more cards in the deck")
            break;
        
    else:
        print("You don't want to play!")
        break;
    