/*
*File name: LNode.cpp
*Created by: Robert
*2:46:47 PM
*Dec 5, 2016
*/


#include <iostream> //Reading input and output
#include <cstdlib> //Standard Library
#include "LNode.h"


using namespace std;

//Constructor function for our list LNode class
LNode::LNode(){
	headnode = NULL;
	currentnode = NULL;
}

void LNode::AddNode(int addN) {
	//cout << "Test Add" << endl;
	node *n = new node;
	n->next = NULL;
	n->data = addN;

	if (headnode != NULL) {
		currentnode = headnode;
		while (currentnode->next != NULL) {
			currentnode = currentnode->next; //Advances current pointer until to the last node in the list
		}
		currentnode->next = n;
	}

	else {
		headnode = n;
	}
}


void LNode::PrintL() {
	currentnode = headnode;

	while (currentnode != NULL) {
		cout << currentnode->data << endl;
		currentnode = currentnode->next;
	}
}

//Replace the nodes with 100 and 1000
void LNode::NewNodeList(){
	//cout << "Replace 3 divisible" << endl;
	currentnode = headnode;

	LNode NodeObj;
	NodeObj.currentnode = NodeObj.headnode;


	while(currentnode != NULL){

		if(((currentnode->data % 10) == 0) && (currentnode->data > 0) && (currentnode->data % 3 == 0)){
					currentnode->data = 1000;
		}

		else if(((currentnode->data % 10) == 0) && (currentnode->data > 0)){
			currentnode->data = 1000;
		}

		else if((currentnode->data % 3 == 0) && (currentnode->data > 0)){
			currentnode->data = 100;
		}

		currentnode = currentnode->next;
	}
}

void LNode::DeleteNodes(){

	LNode NodeObj;

	node *DeletePointer = NULL;
	currentnode = headnode;

	NodeObj.temp = NodeObj.headnode;
	NodeObj.currentnode = NodeObj.headnode;

	while(currentnode != NULL){

		while (currentnode != NULL && currentnode->data < 50) {
			temp = currentnode;
			currentnode = currentnode->next;
		}

		//Value was not found with this condition checking
		if (currentnode == NULL) {
			delete DeletePointer;
		}

		//Value was found with this condition checking
		else {
			DeletePointer = currentnode;
			currentnode = currentnode->next; //Connects
			temp->next = currentnode;
			delete DeletePointer;
		}
	}
}

void LNode::SplitLinkedList(){

	currentnode = headnode;

	int counter = 0;

	while (currentnode != NULL) {
		counter++;
		cout << currentnode->data << endl;
		currentnode = currentnode->next;
	}

//	cout << "The counter is: " << counter << endl;

	LNode List1;
	LNode List2;

	//Splits the linked list
	currentnode = headnode;

	for(int i = 0 ; i < counter ;i++){
		if(i < counter / 2){
			List1.AddNode(currentnode->data);
		}

		else{
			List2.AddNode(currentnode->data);
		}

		currentnode = currentnode->next;
	}

	cout << "This is the first split linked list" << endl;
	List1.PrintL();
	cout << "This is the second split linked list" << endl;
	List2.PrintL();

}
