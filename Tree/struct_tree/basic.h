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

void option();

#endif /* BASIC_H_ */
