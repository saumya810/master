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
void options()
{
	int op;
	op=1;
	while(op!=3)
			{
	          printf("\nSelect The Options :- \n\n1) Insert\n2)  Display\n3)  Exit");
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
