import System.IO     
import Data.Char


main = do  
    putStrLn "Enter a phrase..."  
    phrase  <- getLine
    writeFile "leet.txt" (leet phrase)

leet :: [Char] -> [Char]
leet [] = []
leet (x:xs) 
	| x == 'o' = '0' : leet xs
	| x == 'e' = '3' : leet xs
	| x == 'a' = '@' : leet xs
	| x == 'l' = '1' : leet xs
	| otherwise = x : leet xs