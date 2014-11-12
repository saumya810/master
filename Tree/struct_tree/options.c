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

void option()
{
	int options=0;
	while(options!=5)
	{
		printf("\nChoose the options \n1)  Insert\n2)  Inorder\n3)  Preorder\n4)  Postorder\n5)  Exit: ");
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
