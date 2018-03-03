main = do  
    putStrLn "Enter a phrase..."  
    phrase  <- getLine
    putStrLn $ leet phrase

leet :: [Char] -> [Char]
leet [] = []
leet (x:xs) 
	| x == 'o' = '0' : leet xs
	| x == 'e' = '3' : leet xs
	| x == 'a' = '@' : leet xs
	| x == 'l' = '1' : leet xs
	| otherwise = x : leet xs