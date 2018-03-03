--Question1
generation :: Integer -> String
generation gen
 | gen > 1995 = "Generation Z"
 | gen > 1980 = "Millennial"
 | gen > 1965 = "Generation X"
 | gen > 1945 = "Baby Boomer"
 | gen > 1933 = "The Silent Generation"
 | otherwise = "The Greatest Generation"
 
 
 
 --Question3
 --hypotenuse :: (RealFloat a) => [(a, a)] -> [a]
-- hypotenuse xs = [hypo | (side1, side2) <- xs, let hypo = sqrt(side1^2 + side2^2), hypo > 0] 

--calcBmis' :: (RealFloat a) => [(a, a)] -> [a]  
--calcBmis' xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2]  
 
--Question4
multiplyList :: (RealFloat a) => [a] -> [a]  
multiplyList xs = [listValue | (a) <- xs, let listValue = a * pi]

--Question5
--listMultiplication :: [a] -> [a]
--listMultiplication xs = case xs of [] -> error "empty list" 
-- [_] -> 0
-- (x:y:_) -> x * y
-- (x:y:z) -> x*y*z
-- (x:y:z:_) -> error "too many!"