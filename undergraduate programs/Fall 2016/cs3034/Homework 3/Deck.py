'''
Created on Oct 8, 2016

@author: Robert
'''

import random
from abc import ABC, abstractmethod

class DeckClass(object):
    
    
    
    #Populates list from 0 - 65
    Cards = [i for i in range (66)]
    print(Cards)
    
    #Function for randomizing Cards list using another list
    def __init__(self):
        ShuffledList = self.Cards
        random.shuffle(ShuffledList)
        self.Cards = ShuffledList
        print("This prints out Cards list")
        print(self.Cards)
        


    #Function that pops cards from the Cards list
    def DealCard(self):
        return self.Cards.pop()
    
    #Function that get's the amount of cards in the list
    def GetAmount(self):
        return len(self.Cards)
    
    
    #Function that does the plays
    def GiveCards(self):
        PlayAgain = 0
        Player = 0
        Computer = 1
        
        #Create object for future use to go into other classes
        RockObj = RockClass()
        PaperObj = PaperClass()
        ScissorsObj = ScissorsClass()
        
        
        

                
        
        
        #RockObj = RockClass()
        #Variable for loop
        i = 0
        while i < 7:
                #Player's cards
            Card1 = self.DealCard()
            Card2 = self.DealCard()
            Card3 = self.DealCard()
            Card4 = self.DealCard()
                
                #Player's list of cards
            CardListPL = [Card1, Card2, Card3, Card4]
            
                #Creates a list with the cards of the user
            ListOfString = []
            
                
            print(CardListPL)
            
                #Player's list
            CardListPL = [Card1, Card2, Card3, Card4]
            
            for k in range(4):
                if(CardListPL[k]//22 == 0):
                    testObj = RockClass()
                    ListOfString.append(testObj.CardStr())
                elif(CardListPL[k]//22 == 1):
                    testObj = PaperClass()
                    ListOfString.append(testObj.CardStr())
                elif(CardListPL[k]//22 == 2):
                    testObj = ScissorsClass()
                    ListOfString.append(testObj.CardStr())
                    
                    
            
            
            
            
            
                #Computer's Cards
            Card5 = self.DealCard()
            Card6 = self.DealCard()
            Card7 = self.DealCard()
            Card8 = self.DealCard()
            
                #Computer's list
            CardListPC = [Card5, Card6, Card7, Card8]
            
                #Creates a list with the cards of the user
            ListOfString2 = []
            
            print(CardListPC)
            
            for k in range(4):
                if(CardListPC[k]//22 == 0):
                    RockObj = RockClass()
                    ListOfString2.append(RockObj.CardStr())
                elif(CardListPC[k]//22 == 1):
                    PaperObj = PaperClass()
                    ListOfString2.append(PaperObj.CardStr())
                elif(CardListPC[k]//22 == 2):
                    ScissorsObj = ScissorsClass()
                    ListOfString2.append(ScissorsObj.CardStr())
                    
              
            
              
            i += 1
            PlayAgain += 1
            
            if(PlayAgain == 7):
                break;
            
            if (Player == 0):
                print("The user is dealt: ", Card1, Card2, Card3, Card4)
                print("This in word form is ", ListOfString[0], ListOfString[1], ListOfString[2], ListOfString[3])
                print("The PC is dealt: ", Card5, Card6, Card7, Card8)
                print("This in word form is ", ListOfString2[0], ListOfString2[1], ListOfString2[2], ListOfString2[3])
                self.Play1(CardListPL, CardListPC)
                
                Computer = 1
                
            if (Player == 1):
                print("The PC is dealt: ", Card5, Card6, Card7, Card8)
                
                print("The user is dealt: ", Card1, Card2, Card3, Card4)
                Computer = 0
                
                
    def Play1(self, CardListPl, CardListPC):
        Rock1 = RockClass()
        Paper1 = PaperClass()
        Scissors1 = ScissorsClass()
        
        
        print("Enter what card you want to deal (Index):")
        PlayerInput = int(input())
        
#         if (CardListPl[PlayerInput]//22)  == 0:
#             a = 0
#             while a < 3:
#                 if((CardListPC[a]//22) == 0):
#                     Rock1.Check(Paper1)
#                 a += 1 
                    
                    
        
        
            
        
class Card(object):
    """
    This class is for abstract purposes only
    """
    
    

    intVariable = -1
    
    def __init__(self, intVariable):
        self.intVariable = intVariable

    

#Rock Class
class RockClass(Card):
    '''
    classdocs
    '''
    Rock_int = 0
    RockVar = "Rock Card"
    

    def __init__(self):
        '''
        Constructor
        '''
        self.intVariable = 0
        
    def CardStr(self):
        if(self.Rock_int == 0):
            return self.RockVar
            
    
    #This decides the winner
    def Check(self, object):
        
        if isinstance(object, Paper):
            print("You win, Rock beats Scissors")
            return True
        else:
            print("Better luck next time chump!")
            return False
    
Rock = RockClass()

#Paper Class
class PaperClass(Card):
    
    Paper_int = 1
    PaperVar = "Paper Card"

    def __init__(self):
        '''
        Constructor
        '''
        self.intVariable = 1
        
    def CardStr(self):
        if(self.Paper_int == 1):
            return self.PaperVar
            
    
    #This method decides the winner
    def Check(self, object):
       
        if isinstance(object, Rock):
            print("You win, Paper beats Rock")
            return True
        else:
            print("Better luck next time chump!")
            return False
    
Paper = PaperClass()

#Scissors Class
class ScissorsClass(Card):
    
    Scissors_int = 2
    ScissorsVar = "Scissors Card"

    def __init__(self):
        '''
        Constructor
        '''
        self.intVariable = 2
        
    def CardStr(self):
        if(self.Scissors_int == 2):
            return self.ScissorsVar
            
    
                
    #This method decides the winner
    def Check(self, object):
        
        if isinstance(object, Paper):
            print("You win, Scissor beats Paper")
            return True
        else:
            print("Better luck next time chump!")
            return False
        
Scissors = ScissorsClass()


#Creates the object, so that we could get info inside class    
GetClassStuff = DeckClass()
GetClassStuff.GiveCards()

# print("Would you like to play again?(0 - yes, 1 - no)")
# PlayerInput = int(input())
# if(PlayerInput == 0):
#     GetClassStuff.GiveCards()
# else:
#     quit()
    