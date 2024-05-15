#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
const int inf = 1e9;
int read()
{
	int num = 0;
	bool flag = 1;
	char c = getchar();
	for (; c < '0' || c > '9'; c = getchar())
		if (c == '-')
			flag = 0;
	for (; c >= '0' && c <= '9'; c = getchar())
		num = (num << 1) + (num << 3) + c - '0';
	return flag ? num : -num;
}
vector<int> e[N];
int n, m, dfn[N], low[N], idx, cut[N], rt;
void Tarjan(int x, int fa)
{
	dfn[x] = low[x] = ++idx;
	int ct = 0;
	for (auto y : e[x])
	{
		if (!dfn[y])
		{
			Tarjan(y, fa);
			ct++;
			if (low[y] >= dfn[x])
			{
				cut[x] = 1;
			}
			low[x] = min(low[x], low[y]);
		}
		else if (y != fa)
			low[x] = min(low[x], dfn[y]);
	}
	if (x == rt && ct <= 1)
		cut[x] = 0;
}
signed main()
{
	n = read();
	m = read();
	for (int i = 1; i <= m; i++)
	{
		int x = read(), y = read();
		e[x].push_back(y);
		e[y].push_back(x);
	}
	for (int i = 1; i <= n; i++)
		if (!dfn[i])
			rt = i, Tarjan(i, 0);
	int sum = 0;
	for (int i = 1; i <= n; i++)
		sum += cut[i];
	printf("%d\n", sum);
	for (int i = 1; i <= n; i++)
		if (cut[i])
			printf("%d ", i);
	return 0;
}
