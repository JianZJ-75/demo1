#include <bits/stdc++.h>
using namespace std;
const int N=11e6+10;
char s[N],b[N<<1];int p[N<<1];
int Manacher(){
	int n=strlen(s+1);
    for(int i=1;i<=n;i++)
	  b[i*2]=s[i],b[i*2-1]='$';
	int len=n<<1;b[0]='%';b[++len]='$';
	int pos,R=0,Max=0;
	for(int i=1;i<=len;i++){
		if(i<R)p[i]=min(R-i+1,p[2*pos-i]);else p[i]=1;
		while(b[i+p[i]]==b[i-p[i]])p[i]++;
        if(i+p[i]-1>R){R=i+p[i]-1;pos=i;}
        Max=max(Max,p[i]-1);
	}
	return Max;
}
signed main(){
	scanf("%s",s+1);
	printf("%d",Manacher());
	return 0;
}
