#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;

void Jian()
{
    int x=-1;
	do{
		x=x*x;
		cout<<x;
	}while(x==0);
}

int main()
{
    int t = 1;
    cin >> t;
    while (t--)
        Jian();
    return 0;
}