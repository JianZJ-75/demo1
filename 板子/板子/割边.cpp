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
vector<pair<int, int>> e[N];
int n, m, dfn[N], low[N], idx;
vector<int> bridge;
void Tarjan(int x, int id)
{
	dfn[x] = low[x] = ++idx;
	for (auto it : e[x])
	{
		int y = it.first, id2 = it.second;
		if (!dfn[y])
		{
			Tarjan(y, id2);
			low[x] = min(low[x], low[y]);
		}
		else if (id != id2)
			low[x] = min(low[x], dfn[y]);
	}
	if (low[x] == dfn[x] && id)
		bridge.push_back(id);
}
signed main()
{
	n = read();
	m = read();
	for (int i = 1; i <= m; i++)
	{
		int x = read(), y = read();
		e[x].push_back({y, i});
		e[y].push_back({x, i});
	}
	for (int i = 1; i <= n; i++)
		if (!dfn[i])
			Tarjan(i, 0);
	sort(bridge.begin(), bridge.end());
	printf("%d\n", bridge.size());
	for (auto num : bridge)
		printf("%d ", num);
	return 0;
}
