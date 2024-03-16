#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	//初始化
	srand(time(0));
	int number=rand()%100+1;
	//int number=99;
	int a,count;
	int e,f;
	int c=0,d=0;
	count=0;
	//开始游戏
	printf("猜数字猜数字，你爸爸今天跟你玩线上游戏。\n输入1后按回车继续：\n");
	scanf("%d",&e);
	printf("我想好数字了，继续输1按回车：\n"); 
	scanf("%d",&f);
	printf("来猜："); 
	do
	{
		scanf("%d",&a);
		count++;
		if(a>number){
			c++;
			if(c<2){
				printf("李佳琪唉，这也太大了吧，一个暑假过无数了？再让你猜一次："); 
			}else if(c<4){
				printf("唉，我的天，还是大了，你真无数了？再来："); 
			}else{
				printf("大了大了，加油，继续：");
			}
			//scanf("%d",&a);
		}else if(a<number){
			d++;
			if(d<2){
				printf("李佳琪唉，你是怎么想的，猜这么小干什么，无数了？？？再让你猜一次："); 
			}else if(d<4){
				printf("唉，还是小了，你老猜这么小干嘛啊！再来：");
			}else{
				printf("小了小了，加油，继续：");
			}
			//scanf("%d",&a);
		}
	}while(a!=number);
	if(count<=7){
		printf("哟呵，小脑瓜子还不错嘛，才%d次就猜到了，和你爸爸心有灵犀哦。",count);
	}else{
		printf("你个呆皮用了%d次才猜中？？？？你这小脑瓜子，多学学数学吧，没救了......",count);
	}
	//游戏结束 
	return 0;
}
