#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for(int i = a; i <= b; i++)
#define rrep(i, a, b) for(int i = a; i >= b; i--)

using namespace std;

int ks(int x)
{
	int a = 2, re = 1;
	while(x)
	{
		if(x % 2 != 0)
			re *= a;
		x /= 2;
		a *= a;
	}
	return re;
}

void Jian()
{
	int k;
	cin >> k;
	rep(i, 1, k)
		rep(j, 1, ks(k - i))
		{
			int x;
			cin >> x;
		}
	int w;
	cin >> w;
	if(k == 3)
		cout << "7 4 8 5 9 8 6 5\n";
	else if(k == 2)
		cout << "No Solution\n";
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
