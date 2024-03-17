#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for(int i = a; i <= b; i++)
#define rrep(i, a, b) for(int i = a; i >= b; i--)

using namespace std;

struct P
{
    int h1, m1, s1;
    int h2, m2, s2;
};

bool cmp(P a, P b)
{
	if(a.h1 == b.h1)
	{
		if(a.m1 == b.m1)
			return a.s1 < b.s1;
		return a.m1 < b.m1;
	}
	return a.h1 < b.h1;
}

void Jian()
{
    int n;
    cin >> n;
    if(n == 1)
    {
		string x, y, z;
		cin >> x >> y >> z;
		if(x != "00:00:00")
			cout << "00:00:00 - " << x << endl;
		if(z != "23:59:59")
			cout << z << " - 23:59:59\n";
		return;
	}
    P a[n + 1];
    rep(i, 1, n)
        scanf("%d:%d:%d - %d:%d:%d", &a[i].h1, &a[i].m1, &a[i].s1, &a[i].h2, &a[i].m2, &a[i].s2);
    sort(a + 1, a + 1 + n, cmp);
    /*rep(i, 1, n)
    {
		cout << a[i].h1 << ":" << a[i].m1 << ":" << a[i].s1 << " _ ";
		cout << a[i].h2 << ":" << a[i].m2 << ":" << a[i].s2 << endl;
	}*/
	rep(i, 1, n)
    {
		if(i == 1)
		{
			if(a[i].h1 != 0 || a[i].m1 != 0 || a[i].s1 != 0)
			{
				cout << "00:00:00 - ";
				if(a[i].h1 < 10)
					cout << 0 << a[i].h1;
				else
					cout << a[i].h1;
				cout << ":";
				if(a[i].m1 < 10)
					cout << 0 << a[i].m1;
				else
					cout << a[i].m1;
				cout << ":";
				if(a[i].s1 < 10)
					cout << 0 << a[i].s1;
				else
					cout << a[i].s1;
				cout << endl;
			}
		}else if(i == n)
		{
			if(!(a[i].h1 == a[i - 1].h2 && a[i].m1 == a[i - 1].m2 && a[i].s1 == a[i - 1].s2))
			{
				if(a[i - 1].h2 < 10)
					cout << 0 << a[i - 1].h2;
				else
					cout << a[i - 1].h2;
				cout << ":";
				if(a[i - 1].m2 < 10)
					cout << 0 << a[i - 1].m2;
				else
					cout << a[i - 1].m2;
				cout << ":";
				if(a[i - 1].s2 < 10)
					cout << 0 << a[i - 1].s2;
				else
					cout << a[i - 1].s2;
				cout << " - ";
				if(a[i].h1 < 10)
					cout << 0 << a[i].h1;
				else
					cout << a[i].h1;
				cout << ":";
				if(a[i].m1 < 10)
					cout << 0 << a[i].m1;
				else
					cout << a[i].m1;
				cout << ":";
				if(a[i].s1 < 10)
					cout << 0 << a[i].s1;
				else
					cout << a[i].s1;
				cout << endl;
			}
            if(a[i].h2 != 23 || a[i].m1 != 59 || a[i].s1 != 59)
			{
				if(a[i].h2 < 10)
					cout << 0 << a[i].h2;
				else
					cout << a[i].h2;
				cout << ":";
				if(a[i].m2 < 10)
					cout << 0 << a[i].m2;
				else
					cout << a[i].m2;
				cout << ":";
				if(a[i].s2 < 10)
					cout << 0 << a[i].s2;
				else
					cout << a[i].s2;
				cout << " - 23:59:59\n";
			}
		}else
		{
			if(!(a[i].h1 == a[i - 1].h2 && a[i].m1 == a[i - 1].m2 && a[i].s1 == a[i - 1].s2))
			{
				if(a[i - 1].h2 < 10)
					cout << 0 << a[i - 1].h2;
				else
					cout << a[i - 1].h2;
				cout << ":";
				if(a[i - 1].m2 < 10)
					cout << 0 << a[i - 1].m2;
				else
					cout << a[i - 1].m2;
				cout << ":";
				if(a[i - 1].s2 < 10)
					cout << 0 << a[i - 1].s2;
				else
					cout << a[i - 1].s2;
				cout << " - ";
				if(a[i].h1 < 10)
					cout << 0 << a[i].h1;
				else
					cout << a[i].h1;
				cout << ":";
				if(a[i].m1 < 10)
					cout << 0 << a[i].m1;
				else
					cout << a[i].m1;
				cout << ":";
				if(a[i].s1 < 10)
					cout << 0 << a[i].s1;
				else
					cout << a[i].s1;
				cout << endl;
			}
		}
	}
}

int main()
{
	//ios::sync_with_stdio(false);
	//cin.tie(0);
	//cout.tie(0);
	int _ = 1;
	//cin >> _;
	while(_--)
		Jian();
	return 0;
}
