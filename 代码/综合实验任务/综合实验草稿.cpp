#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>
#include <cstring>
#define qp system("cls")
#define shuchu if(g<60) cout<<"好好学习，再接再厉哦小朋友"<<endl;\
			   else cout<<"你的得分为"<<g<<endl
#define ddgl  printf("才用了%d次就答对了，小朋友太棒了!\n",i+1)
#define tx printf("(%d)\n",i+1) 			  
using namespace std;

void cy(){
	srand(time(0));
	int jp=rand()%4+1;
	switch(jp){
		case 1:cout<<"写错了哦，不要灰心，加油，";
		case 2:cout<<"失败乃成功之母，加油，"; 
		case 3:cout<<"是不是粗心算错了，再试试，";
		default:cout<<"再仔细看看题目，加油，";
	}
}
void djs(void){ 
	qp;
	for(int i=5;i>0;i--){
		cout<<i<<endl;
		Sleep(1000);
		qp;
	} 
}
int jia(int jp){
	int sum=0;
	for(int i=0;i<50;i++){
		int a,b;
		if(jp==2){
			srand(time(0));
			a=rand()%100;
			b=rand()%100;
		}else{
			srand(time(0));
			a=rand()%10;
			b=rand()%10;
		}
		int ans=a+b;
		tx;
		cout<<a<<"+"<<b<<"=";
		int c=0;
		char res[100];
		for(int i=0;i<5;i++){
			cin>>res;
			int n_=strlen(res);
			for(int j=0;j<n_;j++){
				if(res[j]>='0'&&res[j]<='9'){
					c=c*10+(res[j]-'0');
				}
			}
			if(c==ans){
				sum+=2;
				ddgl;
				break;
			}else{
				cy(); 
				printf("还有%d次机会\n",4-i); 
			}
			c=0;
		}
		cout<<"按任意键开始下一题"; 
		getch();
		qp;
	}
	return sum;
}
int jian(int jp){
	int sum=0;
	for(int i=0;i<50;i++){
		int a,b;
		if(jp==2){
			srand(time(0));
			a=rand()%100;
			b=rand()%(a+1);
		}else{
			srand(time(0));
			a=rand()%10;
			b=rand()%(a+1);
		}
		int ans=a-b;
		tx;
		cout<<a<<"-"<<b<<"=";
		int c=0;
		char res[100];
		for(int i=0;i<5;i++){
			cin>>res;
			int n_=strlen(res);
			for(int j=0;j<n_;j++){
				if(res[j]>='0'&&res[j]<='9'){
					c=c*10+(res[j]-'0');
				}
			}
			if(c==ans){
				sum+=2;
				ddgl;
				break;
			}else{
				cy(); 
				printf("还有%d次机会\n",4-i); 
			}
			c=0;
		}
		cout<<"按任意键开始下一题"; 
		getch();
		qp;
	}
	return sum;
}
int cheng(int jp){
	int sum=0;
	for(int i=0;i<50;i++){
		int a,b;
		if(jp==2){
			srand(time(0));
			a=rand()%100;
			b=rand()%100;
		}else{
			srand(time(0));
			a=rand()%10;
			b=rand()%10;
		}
		int ans=a*b;
		tx;
		cout<<a<<"x"<<b<<"=";
		int c=0;
		char res[100];
		for(int i=0;i<5;i++){
			cin>>res;
			int n_=strlen(res);
			for(int j=0;j<n_;j++){
				if(res[j]>='0'&&res[j]<='9'){
					c=c*10+(res[j]-'0');
				}
			}
			if(c==ans){
				sum+=2;
				ddgl;
				break;
			}else{
				cy(); 
				printf("还有%d次机会\n",4-i); 
			}
			c=0;
		}
		cout<<"按任意键开始下一题"; 
		getch();
		qp;
	}
	return sum;
}
int chu(int jp){
	int sum=0;
	for(int i=0;i<50;i++){
		int a,b;
		if(jp==2){
			srand(time(0));
			a=rand()%99+1;
			int n=100/a;
			b=(rand()%n)*a;
		}else{
			srand(time(0));
			a=rand()%9+1;
			if(a==0) b=rand()%9+1;
			int n=10/a;
			b=(rand()%n)*a;
		}
		int ans=b/a;
		tx;
		cout<<b<<"÷"<<a<<"=";
		int c=0;
		char res[100];
		for(int i=0;i<5;i++){
			cin>>res;
			int n_=strlen(res);
			for(int j=0;j<n_;j++){
				if(res[j]>='0'&&res[j]<='9'){
					c=c*10+(res[j]-'0');
				}
			}
			if(c==ans){
				sum+=2;
				ddgl;
				break;
			}else{
				cy(); 
				printf("还有%d次机会\n",4-i); 
			}
			c=0;
		}
		cout<<"按任意键开始下一题"; 
		getch();
		qp;
	}
	return sum;
}
void cg(void){
	cout<<"恭喜你成功晋级，将在5秒后开始高级测试，请做好准备"<<endl;
	cout<<"按任意键确认"<<endl;
	getch(); 
	djs();
	cout<<"按任意键开始答题"<<endl;
	getch(); 
	qp; 
} 
int main(){
	int jp,g;
	cout<<"哈喽小朋友，欢迎参加测试"<<endl;
	cout<<"你可以选择加（1）、减（2）、乘（3）、除（4）中的任意一种运算方法进行测试"<<endl;
	cout<<"请输入你选择的序号："<<endl; 
	cin>>jp;
	qp;
	cout<<"测试即将开始(一共50题，每题2分，分为初级测试和高级测试，初级测试达95以上可参加高级测试)"<<endl;
	cout<<"初级测试为一位数计算，高级测试混合了一二位运算"<<endl; 
	cout<<"按任意键确认"<<endl;
	getch(); 
	djs();
	cout<<"按任意键开始答题"<<endl;
	getch(); 
	qp;
	switch(jp){
		case 1:
			g=jia(1);
			if(g>=95){
				cout<<"你的分数为"<<g<<endl; 
				cg();
				jia(2);
				shuchu;
			}else shuchu; 
			break;
		case 2:
			g=jian(1);
			if(g>=95){
				cout<<"你的分数为"<<g<<endl;
				cg();
				jian(2);
				shuchu;
			}else shuchu; 
			break;
		case 3:
			g=cheng(1);
			if(g>=95){
				cout<<"你的分数为"<<g<<endl;
				cg();
				cheng(2);
				shuchu;
			}else shuchu; 
			break;
		default:
			g=chu(1);
			if(g>=95){
				cout<<"你的分数为"<<g<<endl;
				cg();
				chu(2);
				shuchu;
			}else shuchu; 
			break;
	}
	return 0;
} 
