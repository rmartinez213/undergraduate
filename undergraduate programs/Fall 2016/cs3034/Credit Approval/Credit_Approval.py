#Some code from csns, but changes I applied
import numpy as np
import csv as csv
from sklearn.ensemble import RandomForestClassifier
from sklearn.cross_validation import train_test_split
from sklearn.metrics import accuracy_score


np.set_printoptions(threshold=np.nan) #'nan' value change to np.nan -js

# Open up the csv file in to a Python object
csv_file_object = csv.reader(open('credit.csv', 'rt')) #'rt' instead of rb for string -js
header = next(csv_file_object)
                                 
rawdata=[]                         
for row in csv_file_object:      
    rawdata.append(row)
rawdata
data = np.array(rawdata) 

#display the data
print (data[:3])

#Columns in order:
#PassengerId: 0,Survived 1,Pclass 2,Name 3,Sex 4,Age 5,SibSp 6,
#Parch 7,Ticket 8,Fare 9,Cabin 10,Embarked 11

#select Pclass, sex, age, Sibsp, Parch, Fare 
X = data[:, [1,2,7,10,13,14]]
print ("Columns we are using:")
print (X[:4])

#new indices PClass 0, Sex 1, Age 2, SibSp 3, Parch 4, Fare 5

#convert males to 1, females to 0
f = X[:, 1] == 'female'
m = X[:, 1] == 'male'
X[:, 1][f] = 0
X[:, 1][m] = 1

#Convert question marks to 0
e = X[:] == '?'
X[:][e] = 0

print (X[:5])

# get rid of missing values
n = X[:] == ""
X[n] = 0



#get labels
y = data[:,10]
#print("thhis is y", data[:,1])

#split data into train and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)
print ("X_train: ", X_train[:5])
print ("X_test: ", X_test[:5])
print ("y_train: ", y_train[:5])
print ("y_test: ", y_test[:5])


forests = RandomForestClassifier(n_estimators=100)
forests = forests.fit(X_train, y_train)
train_predictions = forests.predict(X_train)
predictions = forests.predict(X_test)


print ("Accuracy on training set: ", accuracy_score(y_train, train_predictions))
print ("Accuracy on test set: ", accuracy_score(y_test, predictions))




