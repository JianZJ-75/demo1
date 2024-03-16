#include <stdio.h>
#include <math.h>
int M(int x1,int y1,int x2,int y2);
int main(){
	int t,x1,y1,x2,y2,x3,y3;
	int s;
	scanf("%d",&t);
	for(int i=0;i<t;i++){
		printf("\n");
		scanf("%d %d",&x1,&y1);
		scanf("%d %d",&x2,&y2);
		scanf("%d %d",&x3,&y3);
		int c;
		if(x1>x2){
			c=x1;
			x1=x2;
			x2=c;
		}
		if(y1>y2){
			c=y1;
			y1=y2;
			y2=c;
		}
		s=x2-x1+y2-y1;
		switch(M(x1,y1,x2,y2)){
			case 1:
				if(x2==x3&&y3>y1&&y3<y2){
					s+=2;
				}
				break;
			case 2:
				if(y2==y3&&x3>x1&&x3<x2){
					s+=2;
				}
				break;
			default:
				break;
		}
		printf("%d\n",s);
	}
	return 0;
} 
int M(int x1,int y1,int x2,int y2){
	if(x1==x2){
		return 1;
	}else if(y1==y2){
		return 2;
	}else{
		return 3;
	}
}
