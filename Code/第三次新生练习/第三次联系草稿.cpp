#include <stdio.h>
#include <math.h>

void g(int *c,int *d);
int f(int *c,int *d,int t);
int main(){
	int t,n;
	scanf("%d",&t);
	int m=t*(t-1)/2,cd=0; 
	int a[t],b[t],c[m],d[m];
	for(int i=0;i<t;i++){//������꣬�������鱣�� 
		scanf("%d %d",&a[i],&b[i]);
		if(i!=0){
			for(int j=1;i-j>=0;j++){//ȡÿ�����������֮���������Ĳ�ֵ
				c[cd]=a[i]-a[i-j];
				d[cd]=b[i]-b[i-j];
				g(c+cd,d+cd);//Լ��
				cd++;
			}
		}
	}
	n=2*f(c,d,m);//2*�����Ƿ����� 
	printf("%d",n);
	return 0;
}
int f(int *c,int *d,int t){//����������Ѱ����ͬ
	int q,w,n,ret;
	ret=t;
	for(int i=0;i<t;i++){
		q=c[i];
		//w=d[i];
		n=i+1;
		for(;n<t;n++){
			if(c[n]==0&&d[n]==0){
				continue;
			}
			if(q==c[n]||q==-c[n]){//������ͬ-1
				ret--;
				c[n]=0;//��ͬ�ı���ʼΪ0�������������μӱ��� 
				for()
				//d[n]=0;
			}
		}
	}
	return ret;
}
void g(int *c,int *d){//Լ�������
	int min,ret;
	int c1,d1;
	c1=fabs(*c);
	d1=fabs(*d);
	if(c1==d1){//���ʱ���Ը��Ծ���ֵ 
		*c=*c/c1;
		*d=*d/d1;
	}else if(c1==0){//����һ��Ϊ0����һ�����Ծ���ֵ 
		*d=*d/d1;
	}else if(d1==0){//ͬ�� 
		*c=*c/c1;
	}else{
		if(c1>d1){//�����Լ�� 
			min=d1;
		}else{
			min=c1;
		}
		int i=1;
		for(;i<=min;i++){
			if(c1%i==0&&d1%i==0){
				ret=i;
			}
		}
		*c=*c/ret;//���������Լ�� 
		*d=*d/ret;
	}
}
