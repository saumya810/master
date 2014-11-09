
/*
 * Linked_List.h
 *
 *  Created on: Nov 8, 2014
 *      Author: svarshne
 */

#ifndef LINKED_LIST_H_
#define LINKED_LIST_H_

struct node {
	int data;
	struct node *next;
};
int test();
void createLinkedList();
void hu();
struct node *start;

#endif /* LINKED_LIST_H_ */
