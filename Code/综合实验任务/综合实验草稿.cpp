#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>
#include <cstring>
#define qp system("cls")
#define shuchu if(g<60) cout<<"�ú�ѧϰ���ٽ�����ŶС����"<<endl;\
			   else cout<<"��ĵ÷�Ϊ"<<g<<endl
#define ddgl  printf("������%d�ξʹ���ˣ�С����̫����!\n",i+1)
#define tx printf("(%d)\n",i+1) 			  
using namespace std;

void cy(){
	srand(time(0));
	int jp=rand()%4+1;
	switch(jp){
		case 1:cout<<"д����Ŷ����Ҫ���ģ����ͣ�";
		case 2:cout<<"ʧ���˳ɹ�֮ĸ�����ͣ�"; 
		case 3:cout<<"�ǲ��Ǵ�������ˣ������ԣ�";
		default:cout<<"����ϸ������Ŀ�����ͣ�";
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
				printf("����%d�λ���\n",4-i); 
			}
			c=0;
		}
		cout<<"���������ʼ��һ��"; 
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
				printf("����%d�λ���\n",4-i); 
			}
			c=0;
		}
		cout<<"���������ʼ��һ��"; 
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
				printf("����%d�λ���\n",4-i); 
			}
			c=0;
		}
		cout<<"���������ʼ��һ��"; 
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
		cout<<b<<"��"<<a<<"=";
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
				printf("����%d�λ���\n",4-i); 
			}
			c=0;
		}
		cout<<"���������ʼ��һ��"; 
		getch();
		qp;
	}
	return sum;
}
void cg(void){
	cout<<"��ϲ��ɹ�����������5���ʼ�߼����ԣ�������׼��"<<endl;
	cout<<"�������ȷ��"<<endl;
	getch(); 
	djs();
	cout<<"���������ʼ����"<<endl;
	getch(); 
	qp; 
} 
int main(){
	int jp,g;
	cout<<"���С���ѣ���ӭ�μӲ���"<<endl;
	cout<<"�����ѡ��ӣ�1��������2�����ˣ�3��������4���е�����һ�����㷽�����в���"<<endl;
	cout<<"��������ѡ�����ţ�"<<endl; 
	cin>>jp;
	qp;
	cout<<"���Լ�����ʼ(һ��50�⣬ÿ��2�֣���Ϊ�������Ժ͸߼����ԣ��������Դ�95���ϿɲμӸ߼�����)"<<endl;
	cout<<"��������Ϊһλ�����㣬�߼����Ի����һ��λ����"<<endl; 
	cout<<"�������ȷ��"<<endl;
	getch(); 
	djs();
	cout<<"���������ʼ����"<<endl;
	getch(); 
	qp;
	switch(jp){
		case 1:
			g=jia(1);
			if(g>=95){
				cout<<"��ķ���Ϊ"<<g<<endl; 
				cg();
				jia(2);
				shuchu;
			}else shuchu; 
			break;
		case 2:
			g=jian(1);
			if(g>=95){
				cout<<"��ķ���Ϊ"<<g<<endl;
				cg();
				jian(2);
				shuchu;
			}else shuchu; 
			break;
		case 3:
			g=cheng(1);
			if(g>=95){
				cout<<"��ķ���Ϊ"<<g<<endl;
				cg();
				cheng(2);
				shuchu;
			}else shuchu; 
			break;
		default:
			g=chu(1);
			if(g>=95){
				cout<<"��ķ���Ϊ"<<g<<endl;
				cg();
				chu(2);
				shuchu;
			}else shuchu; 
			break;
	}
	return 0;
} 
