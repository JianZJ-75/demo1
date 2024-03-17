#include <iostream>
#define ll long long

using namespace std;

int main(){
	int N;
    cin>>N;
    int ret=1;
    int a[N][N];
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
        	cin>>a[i][j];
        }
    }
    if(N>=4){
        int h=0,l=0,x=0;
        for(int i=0;i<N-3;i++){
            for(int j=0;j<N-3;j++){
                if(a[i][j]==1){
				    //cout<<"i="<<i<<" j="<<j<<endl;
				    for(int j1=j;j1<=j+3;j1++){
				        if(a[i][j1]!=1){
				            h=1;
				            break;
				        }
				    }
				    //cout<<"h="<<h<<endl;
				    if(h==0){
                    	ret=0;
                    	//cout<<"h"<<endl;
                    	break;
					}
				    for(int i1=i;i1<=i+3;i1++){
				        if(a[i1][j]!=1){
				            l=1;
				            break;
				        }
				    }
				    //cout<<"l="<<l<<endl;
				    if(l==0){
                    	ret=0;
                    	//cout<<"l"<<endl;
                    	break;
					}
				    for(int i1=i+1,j1=j+1,n_=0;n_<=2;i1++,j1++){
						n_++;
						//cout<<a[i1][j1]<<endl;
						if(a[i1][j1]!=1){
				    		x=1;
				    		break;
						}
					}
					//cout<<"x="<<x<<endl;
				    if(x==0){
                    	ret=0;
                    	//cout<<"x"<<endl;
                    	break;
					}
					if(i>=3){
						for(int i1=i-1,j1=j+1,n_=0;n_<=2;i1--,j1++){
							n_++;
							if(a[i1][j1]!=1){
					    		x=1;
					    		break;
							}
						}
						//cout<<"x="<<x<<endl;
					    if(x==0){
	                    	ret=0;
	                    	//cout<<"x"<<endl;
	                    	break;
						}
					}
                }
            }
            if(ret==0) break;
        }
    }
    if(ret==1) cout<<"123456";
    else cout<<"114514";
	return 0;
} 
