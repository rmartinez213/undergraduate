import qualified Data.Map as Map
--Question1



--THIS WORKS
--divideFive x = (divFive x)== 0
--divFive x = x `mod` 5  



--THIS WORKS
divisFive :: (Int -> Bool)
divisFive x = x `mod` 5 == 0

--Question2
{--Write a function that checks if every other letter of a string
is between 'a' and 'f' (the remaining letters don't matter, start
with the first letter in the string, skip the second, and so on).
The function takes in a String and returns a Bool. Use partial
application at least once. Empty string returns True. (edited
to specify what empty string returns, some clarification added).
--}

--checkString :: (String -> Char) -> Bool
--checkString str = (`elem` ["a" .. "f"])




--Question3
{--
Write a function that takes two lists, zips them, 
then maps the result to a list of sums of the numbers 
in the tuples. E.g., [1, 2, 3] [4, 5, 6] gets zipped to 
[(1, 4), (2, 5), (3,6)], then gets mapped to [5, 7, 9].
--}

funListMap ::  [Int] -> [Int] -> [Int]
funListMap a b = map (\(a,b) -> a + b) (zip a b)


--Question 4
{--
Write a function that maps a list of Strings that may 
have multiple words to Strings with only the first word
left. E.g. ["Today is Thursday", "Banquet", "unreal games"]
 becomes ["Today", "Banquet", "unreal"].
--}

mapListStrings :: [String] -> [String]
mapListStrings x =  map(\x -> takeWhile (/= ' ') x) x

--Question 5
{--
Write a function that takes a two dimensional matrix
of Strings and transforms all empty strings to "0".
--}

matrixZeroString :: [[String]] -> [[String]]
matrixZeroString [] = []
matrixZeroString (x:xs) = (\xs -> if x == [" "] then ["0"] else if x == [""] then ["0"] else x) xs : matrixZeroString xs


--Question6
{--
Write a function that converts [a, b, c, d, . . . ] 
to [(a,b), (c, d), . . .], where a, b, c, and d can
 be any type.
--}

--Question6
convertString :: [a] -> [(a,a)] -> [(a,a)] 
convertString [] n = n --If no list is passed in
convertString [a] n = n --if one odd list is passed in ex. [1,2,3,4,5]returns [(1,2),(3,4)]
convertString (x:y:z) n = (x,y) : (convertString z n) --Places the numbers/value into a zip like position

mergeMyList :: [a] -> [(a,a)] --Call this method to use the help function above
mergeMyList x = convertString x [] --Calls function from above

--Question7
{--
Using the previous function, convert each tuple to a product
of its two elements, using foldl and a lambda expression.
--}
--A product? Literally product? if so...
--lambdaMyList :: [a] -> [a]


--Question 8
{--
Using scanl, write a function that takes a list of Ints 
and make a list of cumulative sums. 
--}

addAllList :: (Num a) => [a] -> [a]
addAllList x = scanl (+) 0 x



--Question 9
{--
applyThrice :: (Int -> Int) -> Int -> Int
applyThrice f x = f (f (f x))

Use $ to make the second line more readable
--}

applyThrice :: (Int -> Int) -> Int -> Int
applyThrice f x = f $ f $ f x



--Question 10
fn =  (`elem`(['a' .. 'z']))

--Question11
{--
Sort a list of Strings by length of the first word in the strings 
(if the strings have more than one word)
--}

--DOES NOT WORK
--sortMyList :: [String] -> [String]
--sortMyList [] = []
--sortMyList (x:xs) = List.sort(map(\(x:y:ys) -> length x `compare` length y) xs)

--DOWS NOT WORK
--sortMyList :: [String] -> [String]
--sortMyList [] = []
--sortMyList x = List.sort(map (\x -> (length x) `compare` ??) x)

--WORKS
{--
1. sortListHelper a defined function to unword what is passed in worded with functions...A function that returns a function
--}
sortMyList :: [String] -> [String]
sortMyList xs = sortListHelper (map (\x -> (length(head x), x)) (map words xs)) [] 0
{--
1. [(Int, [String])] -> [(Int, [String])]... These two inputs are compared one another.
2. Line 147 returns the sorted String list.
3. Counter is the integer that we iterting through... like i=0 in java.
4. list and strValue are the datas that we are comparing to one another.
5. Ultimately we use filter in order to help with sorting the strings in their proper place.
--}
sortListHelper :: [(Int, [String])] -> [(Int, [String])] -> Int -> [String]
sortListHelper [] strValue counter = map(\(x,y) -> unwords y) strValue
sortListHelper list strValue counter = sortListHelper((filter (\(x,y) -> x /= counter)) list) (strValue++ (filter (\(x,y) -> x==counter) list)) (counter+1)

--Question 12

--Doesn't Work :(
{--
sortMyChar :: [Char] -> [String]
sortMyChar xChar = map() --No map...
--}

--Works!
{--
1. Filters/Deletes all empty chars
2. Zips all the letters together using the filter function
3. 'Repeat' repeats the list with infinite values of all the same value
4. Compare the characters with the reccuring letters from 'Repeat'
--}
myListCharSort :: [Char] -> [String] --Return string
myListCharSort xs = filter (\string ->string/= "" ) $ zipWith (\x letter -> filter (\char -> char==letter) x) (repeat xs)  ['a'..'z'] 


