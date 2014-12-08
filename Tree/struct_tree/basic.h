/*
 * basic.h
 *
 *  Created on: Nov 12, 2014
 *      Author: svarshne
 */

#ifndef BASIC_H_
#define BASIC_H_

struct node {
	int data;
	struct node *left;
	struct node *right;

};
struct node *root;
struct node *arr[50];
int top;
void push(struct node *temp);
struct node* pop();
void display();
void reset();
void print_stack();
int isEmpty();
struct node* element();
void option();

#endif /* BASIC_H_ */
