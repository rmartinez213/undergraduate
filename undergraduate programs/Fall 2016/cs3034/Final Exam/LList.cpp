/*
 * File name: Main.cpp
*Created by: Robert
*2:35:12 PM
*Dec 5, 2016
*/

#include <iostream>
#include "LNode.h"
using namespace std;

int main() {
	cout << "Linked nodes inside the LList.cpp file" << endl;

	LNode test;

	for(int i = 0 ; i <= 50 ; i++){
		test.AddNode(i);
	}

//Prints the nodes from 1-50
	cout << "Prints all the nodes from 1-50: " << endl;
	test.PrintL();

//Prints the nodes and replace 3 and 10
	cout << "Prints the nodes that are placed by 100 and 1000: " << endl;
	test.NewNodeList();
	test.PrintL();

//Deletes the integers above 50 and prints
	cout << "Prints the nodes that are above 50: " << endl;
	test.DeleteNodes();


//Split the linked list into 2 list
	test.SplitLinkedList();

}
