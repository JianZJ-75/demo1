#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for(int i = a; i <= b; i++)
#define rrep(i, a, b) for(int i = a; i >= b; i--)

using namespace std;

int sz[10000];
int szhead = 0;
int xz[10000];
int xzhead = 0;

void Jian()
{
	int n, m, k;
	cin >> n >> m >> k;
	int a[n + 1];
	rep(i, 1, n)
		cin >> a[i];
	int idex = 1;
	sz[++szhead] = a[idex++];
	while(szhead != 0 && xzhead != 0)
	{
		
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int _ = 1;
	//cin >> _;
	while(_--)
		Jian();
	return 0;
}
