/*
 * options.c
 *
 *  Created on: Nov 10, 2014
 *      Author: svarshne
 */

#include <stdio.h>
#include <stdlib.h>
#include "basic.h"

void insert();
void display();
void append();
void reverse();
void reverse(struct node *point);
void swap_alternate_nodes(struct node **pointer);

void options()
{
	int op;
	op=1;
	while(op!=6)
			{
	          printf("\nSelect The  Options  :- \n\n1) Insert\n2)  Display\n3)  Append\n4)  reverse\n5)  Swap_alternate_nodes\n6)  Exit");
	           scanf("%d",&op);

		       if(op==1)
			    {
				printf("insert\n\n\n\n");
				insert();
			    }
		        if(op==2)
					{
						printf("display\n\n\n\n");
						display();

					}
		        if(op==3)
		        					{
		        						printf("Append\n\n\n\n");
		        						append();

		        					}
		        if(op==4)
		        					{
		        						printf("reverse\n\n\n\n");
		        						reverse(start);

		        					}
		        if(op==5)
		        					{
		        						printf("swap_alternate_nodes\n\n\n\n");
		        						swap_alternate_nodes(&start);

		        					}

		     }

}

void insert()
{
	int num,i,value;
	struct node *temp;
	printf("Enter the toal NUM : ");
	scanf("%d",&num);
	for(i=0;i<num;i++)
	{
		if(start==NULL)
		{
			start=(struct node *)malloc(sizeof(struct node));
			temp=start;
		}
		else
		{
			temp->next=(struct node *)malloc(sizeof(struct node));
			temp=temp->next;
		}

		printf("\n Enter the element no %d ",i+1);
		scanf("%d",&value);
		temp->data=value;
		temp->next=NULL;
	}
}

void display()
{
	struct node *temp;
	temp=start;
	while(temp!=NULL)
	{
		printf("------> %d ",temp->data);
		temp=temp->next;
	}
}

void append()
{
	    struct node *temp;
	    int val;
		temp=start;
		while(temp->next!=NULL)
		{
			temp=temp->next;
		}
		temp->next=(struct node *)malloc(sizeof(struct node));
		temp=temp->next;
		printf("\n  Enter the element :-  ");
		scanf("%d",&val);
		temp->data=val;
		temp->next=NULL;


}

void reverse(struct node *point)
{
	struct node *temp,*p,*q;
	if(point->next==NULL)   //odd number of items as end item is left and (point) is not null
	{
		start=point;
		return;
	}

	temp=point;
	p=point->next;
	q=point->next->next;
	p->next=temp;
    if(point==start)
    {
    	point->next=NULL;
    }
	if(q!=NULL)
	{
		reverse(q); // on back tracking making link for alternate left out nodes
		q->next=p;
	}
	else
	{
		start=p;
	}

}

void swap_alternate_nodes(struct node **pointer)
{
	struct node *temp,*p,*s;
	struct node **q;
	temp=*pointer;
	s=temp->next->next;
	p=temp->next;
	*pointer=p;
	p->next=temp;
    temp->next=s;
    if(s!=NULL&&s->next!=NULL)
    {
    	swap_alternate_nodes(&temp->next);
    }



}
