#include<bits/stdc++.h>
using namespace std;
#define int long long
const int N=1010;
const int inf=1e18;
struct _KM{
	int n,Map[N][N],matched[N];
	int slack[N],pre[N],ex[N],ey[N];
	bool visx[N],visy[N];
	void match(int u){
		int x,y=0,yy=0,delta;
		memset(pre,0,sizeof(pre));
		for(int i=1;i<=n;i++)slack[i]=inf;
		matched[y]=u;
		while(1){
			x=matched[y];delta=inf;visy[y]=1;
			for(int i=1;i<=n;i++){
				if(visy[i])continue;
				if(slack[i]>ex[x]+ey[i]-Map[x][i]){
					slack[i]=ex[x]+ey[i]-Map[x][i];
					pre[i]=y;
				}
				if(slack[i]<delta){delta=slack[i];yy=i;}
			}
	        for(int i=0;i<=n;i++)
	        {	
	            if(visy[i])ex[matched[i]]-=delta,ey[i]+=delta;
	            else slack[i]-=delta;
	        }
	        y=yy;
	        if(matched[y]==-1)break;
		}
    	while(y){matched[y]=matched[pre[y]];y=pre[y];}
	}
	int KM()
	{
	    memset(matched,-1,sizeof(matched));
	    memset(ex,0,sizeof(ex));
	    memset(ey,0,sizeof(ey));
	    for(int i=1;i<=n;i++)
	    {	
	        memset(visy,0,sizeof(visy));
	        match(i);
	    }
	    int res=0;
	    for(int i=1;i<=n;i++)
	        if(matched[i]!=-1)
			  res+=Map[i][matched[i]];
	    return res/2;
	}
	void init(int _n){
		n=_n;
		for(int i=1;i<=n;i++)
		  for(int j=1;j<=n;j++)
		    Map[i][j]=-inf;
	}
}g;
int n,a[N],p[N],b[N],c[N];
signed main()
{	
    scanf("%lld",&n);
    for(int i=1;i<=n;i++)scanf("%lld",&a[i]);
    for(int i=1;i<=n;i++)scanf("%lld",&p[i]);
    for(int i=1;i<=n;i++)scanf("%lld",&b[i]);
    for(int i=1;i<=n;i++)scanf("%lld",&c[i]);
    g.init(n*2);
    for(int i=1;i<=n;i++){
    	for(int j=1;j<=n;j++){
    		int now=b[i]+c[j],w=0;
    		for(int k=1;k<=n;k++)
    		  if(a[k]<now)w+=p[k];
    		g.Map[i][j+n]=g.Map[j+n][i]=w;
		}
	}
	printf("%lld",g.KM());
    return 0;
}
