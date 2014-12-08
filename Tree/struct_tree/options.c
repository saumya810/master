/*
 * options.c
 *
 *  Created on: Nov 12, 2014
 *      Author: svarshne
 */
#include <stdio.h>
#include <stdlib.h>
#include "basic.h"

void option();
void Inorder(struct node *temp);
void insert();
void Postorder(struct node *temp);
void Preorder(struct node *temp);
void PreorderWidoutRecursion(struct node *root);
void PostorderWidoutRecursion(struct node *root);
void printpopparents(struct node *temp);

void option()
{
	int options=0;
	while(options!=5)
	{
		printf("\nChoose the options \n1)  Insert\n2)  Inorder\n3)  Preorder\n4)  Postorder\n5)  Exit  \n6)  Preorder Without Recirsion \n7)  Postorder Widout Recursion");
		scanf("%d",&options);
		if(options==1)
			{
				insert();
			}
		if(options==2)
		{
			Inorder(root);
		}
		if(options==3)
				{
					Preorder(root);
				}
		if(options==4)
				{
					Postorder(root);
				}
		if(options==6)
		{
			PreorderWidoutRecursion(root);
		}
		if(options==7)
		{
			PostorderWidoutRecursion(root);
		}
	}

}

void insert()
{
	struct node *temp,*temp1;
	struct node **parent;
	int num;
	printf("\nEnter the element : - ");
	scanf("%d",&num);
	temp=root;
	parent=&root;
	while(temp!=NULL)
	{
		if(num>=temp->data)
		{
			parent=&(temp->right);
			temp=temp->right;

		}
		else
		{
			parent=&(temp->left);
			temp=temp->left;
		}

	}
	temp1=(struct node *)malloc(sizeof(struct node));
	temp1->data=num;
	temp1->left=NULL;
	temp1->right=NULL;
	*parent=temp1;

}

void Inorder(struct node *temp)
{
	if(temp->left!=NULL)
	  Inorder(temp->left);
	printf("-- %d ",temp->data);
	if(temp->right!=NULL)
		  Inorder(temp->right);


	}

void Preorder(struct node *temp)
{
	printf("-- %d ",temp->data);
	if(temp->left!=NULL)
		  Preorder(temp->left);
	if(temp->right!=NULL)
			  Preorder(temp->right);

}

void Postorder(struct node *temp)
{
	    if(temp->left!=NULL)
			  Postorder(temp->left);
		if(temp->right!=NULL)
				  Postorder(temp->right);
		printf("-- %d ",temp->data);
}

void PreorderWidoutRecursion(struct node *root)
{
	struct node* temp;
	temp=root;
	reset();
	push(root);
	while(!isEmpty())
	{
		temp=pop();
		printf("-- %d ",temp->data);
		push(temp->right);
		push(temp->left);
	}

    //print_stack();
}


void PostorderWidoutRecursion(struct node *root)
{
	struct node* temp,*temp1;
	int i=0;
		temp=root;
		reset();
		push(root);
		while(!isEmpty()&&i<10)
		{
			temp=element();
			if(temp->right==NULL&&temp->left==NULL)
			{
				printf("-- %d ",temp->data);
				temp=pop();
				temp1=element();
				printpopparents(temp);
				continue;


			}

			push(temp->right);
			push(temp->left);
			i++;

		}
}


void printpopparents(struct node *temp)
{
	struct node *temp1;
	if(!isEmpty())
	{
		temp1=element();
	   if(temp1->left==temp||temp1->right==temp)
		{
		temp1=pop();
		printf("-- %d  ",temp1->data);
		printpopparents(temp1);
		}
	}

}
