#include <stdio.h>
#include <stdlib.h>

//void swap(int *min,int *max);
int main(){
	char *a[]={"ºî³Âè¡",
			   "ÕÅÓî",
			   "ÕÂÒ«¶«",
			   "ÖÓ½¡",
			   "ÅËÌÎ",
			   "ÍõÖĞÓî",};
	for(int i=0;i<6;i++){
		printf("%s\n",a[i]);
	}
	return 0;
}
