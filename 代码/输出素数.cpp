#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	//初始化
	int q,m,x;
	//输入并赋值 
	q=1;
	m=1;
	//判断并输出
	while(m!=0){
		srand(time(0));
		x=rand()%100; 
		for(int i=2;i<x;i++){
			q=x%i;
			//printf("q=%d\n",q);
			if (q==0){
				m=1;//非素数  
				break;
			}else 
			m=0;
			//printf("%d",x);
			//m=0;//素数 
		} 
		//m=0;
		//if(m==0){
			//printf("%d",x);
		//}
	}
	printf("%d",x);
	return 0; 
}
