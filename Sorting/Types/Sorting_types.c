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
void Merge_Sort(int *arr,int start,int end);
void Merge(int *arr,int start,int end,int mid);
void Max_Heapify(int *arr,int start,int end);
void Make_Heap(int *arr,int end);
void Heap_Sort(int *arr,int end);
int left_child(int i);
int right_child(int i);

void options()
{
		int option,i;
		int arr[8]={10,80,13,17,2,55,14,6},res[8],*result;
		printf("Choose the options :\n1. Insertions Sort \n2. Merge Sort\n3. Exit\n4. Heap");
		scanf("%d",&option);
		if(option==1)
		{
			for(i=0;i<8;i++)
				res[i]=arr[i];
			result=Insertion(res);
			print(result);
		}

		else if(option==2)
		{
			for(i=0;i<8;i++)
					res[i]=arr[i];
			Merge_Sort(res,0,7);
			print(res);
		}

		else if(option==3)
		{


			exit(1);
		}

		else if(option==4)
		{
			for(i=0;i<8;i++)
			  res[i]=arr[i];
			Heap_Sort(res,7);
			print(res);
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

void Merge_Sort(int *arr,int start,int end)
{
	int mid;
	if(start<end)
	{

		mid=(start+end)/2;
		Merge_Sort(arr,start,mid);
		Merge_Sort(arr,mid+1,end);
		Merge(arr,start,end,mid);
	}

}


	void Merge(int *arr,int start,int end,int mid)
	{
		int *up,*down,i,j,k;
		up=(int *)malloc((mid-start+1)*(sizeof(int)));
		down=(int *)malloc((end-mid)*(sizeof(int)));
		for(i=0;i<=mid-start;i++)
		{
			up[i]=arr[start+i];
		}
		for(j=0;j<=end-mid-1;j++)
		{
			down[j]=arr[mid+j+1];
		}
		i=0;
		j=0;
		for(k=start;k<=end;k++)
		{
				if(j>end-mid-1)
				{
					arr[k]=up[i];
					i++;
				}
				else if(i>mid-start)
				{
					arr[k]=down[j];
					j++;
				}
				else if(up[i]<=down[j])
				{
					arr[k]=up[i];
					i++;
				}
				else if(up[i]>down[j])
				{
					arr[k]=down[j];
					j++;
				}
			}
}

    int left_child(int i)
    {
    	if(i==0)
    		return 1;
    	else
    		return 2*i+1;
    }

    int right_child(int i)
    {
    	if(i==0)
    		return 2;
    	else
    		return (2*i+2);
    }


	void Max_Heapify(int *arr,int pivot,int end)
	{
		int max,temp,check;
		max=pivot;
		if(left_child(pivot) <= end && arr[left_child(pivot)]>arr[max])
		{
			max=left_child(pivot);
		}
		if(right_child(pivot) <= end && arr[right_child(pivot)] > arr[max])
		{
			max=right_child(pivot);
		}
		if(max != pivot)
		{
			temp=arr[pivot];
			arr[pivot]=arr[max];
			arr[max]=temp;
			check=arr[max];
			Max_Heapify(arr,max,end);
		}
	}

	void Make_Heap(int *arr,int end)
	{
		int n,i;
		n=(end+1)/2;
		for(i=n-1;i>=0;i--)
		{
			Max_Heapify(arr,i,end);
		}
		print(arr);

	}

	void Heap_Sort(int *arr,int end)
	{
		int n,temp;
		Make_Heap(arr,end);
		for(n=end;n>=1;n--)
		{
			temp=arr[0];
			arr[0]=arr[n];
			arr[n]=temp;
			Max_Heapify(arr,0,n-1);

		}
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
