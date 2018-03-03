--Homework1

--This works! v0.1
--recursive1 :: [Int] -> [Float]
--recursive1 (x:xs)
--	| x >=5 = []
--	| otherwise = (fromIntegral 1) / (fromIntegral x+1) : recursive1 xs

--This works better! v0.2
--recursive1 :: [Int] -> [Float]
--recursive1 (x:y:ys)
--	| y >=6 = []
--	| otherwise = (fromIntegral 1) / (fromIntegral y) : recursive1 (x:y+1:ys)

--Working one v1.0
recursiveFun :: Int -> Float
recursiveFun x
    | x <= 0 = 0
    | otherwise = (fromIntegral 1 / fromIntegral x) + recursiveFun (x-1)


--Working two
recursiveFun2 :: Int -> Float
recursiveFun2 x
    | x <= 0 = 0
    | otherwise = (fromIntegral x / fromIntegral (x+1)) + recursiveFun2 (x-1)

{--
v0.1
This removes the dupilcates of concurrent values
ex:
input: [1,2,3,2,1,2,2]
output: [1,2,3,2,1,2]

removeMax :: [Int] -> [Int]
removeMax [] = []
removeMax (x:y:ys)
	| x == y = (y:ys)
	| otherwise = x : removeMax(y:ys)

--}
	
{--
v0.2 for number 3 problem

maxFun :: [Int] -> [Int]
maxFun [] = []
maxFun (x:y:ys)
	| x > y = maxFunBigNum x ys
	| otherwise = x : maxFun(y:ys)

maxFunBigNum :: (Ord a) => a -> [a] -> a
maxFunBigNum bigNum [] = bigNum
maxFunBigNum bigNum (x:xs) = 
	if x > bigNum then
		maxFunBigNum x xs
	else
		maxFunBigNum bigNum xs

--}

--Working three v1.0
delNumList :: (Ord a) => [a] -> [a]
delNumList (x:xs) =
	delNumList (bigNumFunction x xs) [] (x:xs)
	where
		{--
		This will get the maximum number in the list that
		will then be used in delNumList
		--}
       bigNumFunction :: (Ord a) => a -> [a] -> a
       bigNumFunction maxNum [] = maxNum
       bigNumFunction maxNum (currNum:xs)
         | currNum > maxNum = bigNumFunction currNum xs
         | otherwise = bigNumFunction maxNum xs
	   {--
	   This will delete the biggest number from the list 
	   by comparing the big number to all the numbers of the list
	   and eventually will delete the maxNum and return the
	   rest of the list
	   --}
       delNumList maxNum prevNum (listNums:xs)
         | maxNum == listNums = prevNum ++ xs
         | otherwise = delNumList maxNum (prevNum ++ [listNums]) xs



	
{-- v0.1
This sorts the first number where x > y,
but only the first value... 


recursiveSort :: [Int] -> [Int]
recursiveSort [] = []
recursiveSort [x] = [x]
recursiveSort (x:y:xs)
	| y < x = y : recursiveSort(x:xs)
	|otherwise = x : recursiveSort (y:xs)
--}
	
--Try implementing bubble sort/or/insertion sort 
recursiveBubble :: (Ord a) => [a] -> [a]
recursiveBubble [] = []
recursiveBubble (x:xs) = bubble x (recursiveBubble xs)

bubble :: (Ord a) => a -> [a] -> [a]
bubble x [] = [x]
bubble x (y:ys)
	| y >= x = (x:y:ys)
	| otherwise = y:bubble x ys
