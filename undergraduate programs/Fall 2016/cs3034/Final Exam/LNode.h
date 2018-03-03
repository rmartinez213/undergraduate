/*
 * LNode.h
 *
 *  Created on: Dec 5, 2016
 *      Author: Robert
 */

#ifndef LNode_H
#define	LNode_H

class LNode {

public:

	struct node {
		int data; //Stores data of each node
		node *next; //Pointer for next variable in the list
	};

	node *headnode;
	node *currentnode;
	node *temp;


	LNode(); //A constructor
	void AddNode(int addN);
	void DelNode(int delN);
	void PrintL();
	void NewNodeList();
	void DeleteNodes();
	void SplitLinkedList();
};

#endif
