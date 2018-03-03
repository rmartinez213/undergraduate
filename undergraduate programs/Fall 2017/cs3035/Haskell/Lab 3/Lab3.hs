--Question1
--Function1
grade :: (Integral a) => a -> String
grade 1 = "First Grade"
grade x = "Far beyond reach!"

--Function2
factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial(n - 1)

--Function3
summation :: Int -> Int
summation 0 = 0
summation n = n + summation(n - 1)


--Question 2
addMe :: (Num a) => a -> a -> a
addMe x y = x + y

--Question 3
--show :: Show -> Float
--show x = x
--stringToFloat :: (Integral a) => a -> Float
--stringToFloat x  

--Question 4
numMe :: (Integral a) => a -> String 
numMe 1 = "Once"
numMe 2 = "Twice"
numMe 3 = "Thrice"
numMe x = "Don't know how to say that in English"

--Question 5
first :: (a, b, c, d) -> a  
first (w, _, _, _) = w  
  
second :: (a, b, c, d) -> b  
second (_, x, _, _) = x  
  
third :: (a, b, c, d) -> c  
third (_, _, y, _) = y

fourth :: (a, b, c, d) -> d
fourth (_, _, _, z) = z

--Question6
squareMe :: Int -> Int -> Int
squareMe x y = x ^ y

--Question7
multi :: (Integral a) =>[a] -> a
multi [] = 0
multi (x:[]) = x
multi (x:y:[]) = x * y
multi (x:y:z:_) = x * y * z