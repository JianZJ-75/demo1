#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for(int i = a; i <= b; i++)
#define rrep(i, a, b) for(int i = a; i >= b; i--)

using namespace std;

void Jian()
{
	int n0, n1, n;
	cin >> n0 >> n1 >> n;
	int ans0 = 0, ans1 = 100001;
	rep(i, 1, n - 1)
	{
		int x = i, y = n - i;
		if(n0 % x == 0 && n1 % y == 0 && n0 / x != 1 && n1 / y != 1)
			if((n0 / x - n1 / y) < abs(ans0 - ans1))
				ans0 = x, ans1 = y;
	}
	if(ans0 == 0 && ans1 == 100001)
		cout << "No Solution\n";
	else
		cout << ans0 << " " << ans1 << endl;
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
