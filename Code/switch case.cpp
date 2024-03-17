#include <stdio.h>
int main()
{
	//初始化 
	int a;
	//赋值
	scanf("%d",&a); 
	//判断 
	switch(a){
	case 1:
		printf("你好！");
		break;
	case 2:
		printf("早上好！");
		break;
	case 3:
	 	printf("中午好！");
		break;
	case 4:
		printf("晚上好！");
		break;
	default:
		printf("啊，啊什么啊？");
		break; 
	}
	return 0;
}
