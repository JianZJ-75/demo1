#include <stdio.h>
#include <math.h>

void g(int *c,int *d);
int f(int *c,int *d,int t);
int main(){
	int t,n;
	scanf("%d",&t);
	int m=t*(t-1)/2,cd=0; 
	int a[t],b[t],c[m],d[m];
	for(int i=0;i<t;i++){//输出坐标，用两数组保存 
		scanf("%d %d",&a[i],&b[i]);
		if(i!=0){
			for(int j=1;i-j>=0;j++){//取每个数组减在其之后各个数组的差值
				c[cd]=a[i]-a[i-j];
				d[cd]=b[i]-b[i-j];
				g(c+cd,d+cd);//约分
				cd++;
			}
		}
	}
	n=2*f(c,d,m);//2*：考虑反方向 
	printf("%d",n);
	return 0;
}
int f(int *c,int *d,int t){//遍历两数组寻找相同
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
			if(q==c[n]||q==-c[n]){//若有相同-1
				ret--;
				c[n]=0;//相同的被初始为0，接下来将不参加遍历 
				for()
				//d[n]=0;
			}
		}
	}
	return ret;
}
void g(int *c,int *d){//约分至最简
	int min,ret;
	int c1,d1;
	c1=fabs(*c);
	d1=fabs(*d);
	if(c1==d1){//相等时除以各自绝对值 
		*c=*c/c1;
		*d=*d/d1;
	}else if(c1==0){//若有一个为0，另一数除以绝对值 
		*d=*d/d1;
	}else if(d1==0){//同上 
		*c=*c/c1;
	}else{
		if(c1>d1){//求最大公约数 
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
		*c=*c/ret;//各除以最大公约数 
		*d=*d/ret;
	}
}
