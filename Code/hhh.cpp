#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
	//初始化
	srand(time(0));
	int number=rand()%100+1;
	//int number=50;
	int a,count;
	int c,d;
	int e=0,f=0;
	int select;
	int i=0,j=0;
	int p=0;
	count=0;
	//开始游戏
	printf("有两个小程序你想先看哪个呢（0和1选一个输入）：\n"); 
	printf("(P：不要开全屏，有个程序全屏有bug，我找不到原因，小窗口就好)\n");	
	scanf("%d",&select);
	while(select!=2){
		if(select==1){
			i++;
			j++;
			printf("猜数字猜数字\n输入1后按回车继续：\n");
			scanf("%d",&c);
			printf("我想好数字了，继续输1按回车：\n数字范围是1-100\n"); 
			scanf("%d",&d);
			printf("来猜：");
			do
			{
				scanf("%d",&a);
				count++;
				if(a>number){
					e++;
					if(e<2){
						printf("这也太大了吧，怎么回事？再让你猜一次："); 
					}else if(e<4){
						printf("还是大了，再来："); 
					}else{
						printf("大了大了，加油，继续："); 
					}
					//scanf("%d",&a);
				}else if(a<number){
					f++;
					if(f<2){
						printf("猜这么小干什么，再猜再猜："); 
					}else if(f<4){
						printf("哎哟，怎么还小了？你这运气不行啊，再来：");
					}else{
						printf("小了小了，加油，继续：");
					}
					//scanf("%d",&a);
				}
			}while(a!=number);
			if(count<=7){
				int m=1;
				while(m--){
					p++;
				}
				printf("哟呵，小脑瓜子还不错嘛，才%d次就猜到了。\n",count);
			}else{
				int n=1;
				while(n--){
					p++;
				}
				printf("你个呆皮用了%d次才猜中？？？？你这小脑瓜子，多学学数学吧，没救了......\n",count);
			}
		}else if(select==0){
			i++;
			system("color fC");
			//system("color 5"); 
			printf("************************                **                **          **                            ******              \n");
		    printf("**                    **                 **               **          **                ************                  **\n");
			printf("**                    **      **********************   ** ***   **************         **                             **\n");
			printf("**  ****************  **      **          **           ** ** **       **    **        **        **                    **\n");
			printf("**         **         **      **          **           ** **  **      **    **        **        **                    **\n");
			printf("**         **         **      **          **           ** **  **      **    **       **         **                    **\n");
			printf("**  ****************  **      **          **           ** **          **    **       **         **                    **\n");
			printf("**         **         **      **  ******************   ** **          **    **       ************************         **\n");
			printf("**         ** **      **      **          **              **  *******************               **                    **\n");
			printf("**         **   **    **      **         ****             **          **                   **   **   **               **\n");
			printf("**         **         **      **        **  **            **         ****                **     **     **               \n");
			printf("**  ****************  **      **       **    **           **        **  **             **       **       **             \n"); 
			printf("**                    **     **       **      **          **      **      **          **        **        **          **\n");
			printf("**                    **    **      **          **        **    **          **      **          **          **        **\n");
			printf("************************   **     **              **      **  **              **   **           **           **         \n");
			printf("**                    **  *     **                  **    ****                  **          *****                       \n");
		}
		printf("你还想看看另一个程序吗？如果想，输入它的序号(退出的话输入2)：\n");
//		if(i<2){
//			printf("你还想看看另一个程序吗？如果想，输入它的序号(退出的话输入2)：\n");
//			//printf("程序1猜中次数不同答案不同哦~"); 
//			//scanf("%d",&select);
//		}else{
//			if(p!=2){
//				if(j>0&&j<3){
//					printf("程序1猜中次数不同收尾不同哦~想再试一试吗，输入序号(退出的话输入2)：\n"); 
//				}else if(j>=3){
//					printf("加油，我相信你可以的，继续输入序号："); 
//				}
//				//scanf("%d",&select);
//			}else if(p==2){
//				printf("这么快2个收尾都看到了嘛，不错哦~既然都体验完了，输2结束吧："); 
//			}
//		}
		scanf("%d",&select);
	}
	//游戏结束 
	return 0;
}
