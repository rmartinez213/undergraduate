{-#LANGUAGE ScopedTypeVariables#-}

main = do
	putStrLn "What is your weight?"
	w :: Float  <- readLn
	putStrLn "What is your height?"
	h :: Float  <- readLn
	putStrLn $ bmiTell w h

	
bmiTell :: (RealFloat a) => a -> a -> String  
bmiTell w h
	| (w * 0.45) / (h * 0.025) ^ 2 <= 18.5 = "You're underweight"    
	| (w * 0.45) / (h * 0.025) ^ 2 <= 25.0 = "You're normal"
	| (w * 0.45) / (h * 0.025) ^ 2 <= 30.0 = "You're overweight"
	| otherwise = "You're obese"