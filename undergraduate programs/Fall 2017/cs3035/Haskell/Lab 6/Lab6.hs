--Create a function that adds two Ints together. Then create a function, 
--using the first, that adds a number to 10, using partial application.

addTen :: (Num a) => a -> (a -> a)
addTen x y = x + y + 10

--Using partial application/currying, create a function that checks if
-- a Char is a lowercase letter

isLowerCase :: Char -> Bool
isLowerCase = (`elem` ['a' .. 'z'])

--Write a function that takes another function and an Int and applies
--it 3 times.
applyThree :: (Int -> Int) -> Int -> Int
applyThree f x = f (f (f x))

{--
Using recursion, write a function that takes a function and a list 
of Ints, and applies the function to every other element in the 
list (applies to first, skips the second, and so on), and returns a
new list with both the transformed and untransformed elements
in place
--}

transformationList :: (Num a) => (a -> a) -> [a] -> [a] --input: function, list ----- Outpout: list
transformationList _ [] = [] --incase if user passes in a false list
transformationList f (x:y:xs) = f x: y: transformationList f (xs)
transformationList f (x:xs) = f x: []

	
{--
Write a function like zipWith, except that it takes 3 lists and a 
function that takes 3 parameters, and returns a list with the
function applied to each corresponding element in the 3 lists
--}

zipWith' ::  (a -> b -> c -> d) -> [a] -> [b] -> [c] -> [d]
zipWith' _ [] _ _ = []
zipWith' _ _ [] _ = []
zipWith' _ _ _ [] = []
zipWith' f (x:xs) (y:ys) (z:zs) = f x y z : zipWith' f xs ys zs
{--
Write a function that takes a function (Int -> Int) and an 
Int and returns (Int, Int), where the first element is the Int
without the function applied to it, and the second is the result  of 
applying the function to the Int. That is, if we call the 
function toTuple, toTuple (+3) 6 should return (6, 9)
--}

--returns the notapplied function with appilied applied function
tupleApplied :: (a -> a) -> a -> (a, a)
tupleApplied f x = (x, f x)

--'map' is a built in function
functionTransformation :: (a -> a) -> [a] -> [(a,a)]
functionTransformation _ [] = [] 
functionTransformation f x = map (tupleApplied f) x

 