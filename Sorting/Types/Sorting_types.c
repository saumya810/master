/*
 * Sorting_types.c
 *
 *  Created on: Feb 9, 2015
 *      Author: svarshne
 */

#include <stdio.h>
#include <stdlib.h>
#include "basic.h"

int * Insertion(int * res);
void print(int * res);
void Merge();

void options()
{
		int option,i;
		int arr[8]={1,8,3,7,2,5,4,6},res[8],*result;
		printf("Choose the options :\n1. Insertions Sort \n2. Merge Sort\n3. Exit");
		scanf("%d",&option);
		if(option==1)
		{
			for(i=0;i<8;i++)
				res[i]=arr[i];
			result=Insertion(res);
			print(result);
		}

		else if(option==3)
		{
			exit(1);
		}

}

int * Insertion(int *arr)
{

	int i,key,j;
	for(i=1;i<8;i++)
	{
		key=arr[i];
		j=i-1;
		while(j>=0 && arr[j]>key)
		{
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;

	}

	return arr;

}

void Merge()
{

}

void print(int * res)
{
	int i;
	for(i=0;i<8;i++)
	{
		printf(" %d ",res[i]);
	}
	printf("\n\n *************************************\n\n");
}
