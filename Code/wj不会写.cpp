#include <stdio.h>
int g(int n);//�ж����꣨1��0���� 
int main(){
	int n,x,y,c,date=0;//��ʼ�� 
	scanf("%d/%d/%d",&n,&x,&y);
	int a[13];
	for(int i=1;i<=12;i++){
		if(i==2){
			c=g(n);
			if(c==1){
				a[i]=29;
			}else{
				a[i]=28;
			}
		}else if(i==4||i==6||i==9||i==11){
			a[i]=30;
		}else{
			a[i]=31;
		}
	}//��ÿ����������ֵ 
	for(int i=1;i<=x-1;i++){
		date+=a[i];
	}
	date+=y;//���������� 
	printf("%d",date);
	return 0;
}
int g(int n){
	if(n%4==0&&n%100!=0||n%400==0){
		return 1;
	}else{
		return 0;
	}
}
