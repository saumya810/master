/*
 * Main.c
 *
 *  Created on: Nov 12, 2014
 *      Author: svarshne
 */

#include <stdio.h>
#include <stdlib.h>

int main()
{
	int i;
	setbuf(stdout, NULL);
	printf("hello");
	scanf("%d",&i);
	printf("\n i: - %d ",i);
	return 1;
}
