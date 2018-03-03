--Gives the number to the next one entered
findNext ::  Int -> [Int] -> Int
findNext a [] = -1
findNext a (x:y:ys)
	| a == x = y
    | otherwise = findNext a (y:ys)

--Gives the number to the previous one entered
findPrev :: Int -> [Int] -> Int
findPrev a [] = -1
findPrev a (x:y:ys)
    | a == y = x
    | otherwise = findPrev a (y:ys)
	
--Adds all the integers that are together (addAll 0 == 0) Base case.
addAll :: Int -> Int
addAll 0 = 0
addAll x = (x `mod` 10) + addAll(x `div` 10)