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
int n, m, dfn[N], low[N], v[N], idx;
vector<vector<int>> scc;
stack<int> st;
void Tarjan(int x)
{
	dfn[x] = low[x] = ++idx;
	st.push(x);
	v[x] = 1;
	for (auto y : e[x])
	{
		if (!dfn[y])
		{
			Tarjan(y);
			low[x] = min(low[x], low[y]);
		}
		if (v[y])
			low[x] = min(low[x], dfn[y]);
	}
	if (low[x] == dfn[x])
	{
		vector<int> c;
		while (1)
		{
			int now = st.top();
			st.pop();
			v[now] = 0;
			c.push_back(now);
			if (now == x)
				break;
		}
		sort(c.begin(), c.end());
		scc.push_back(c);
	}
}
signed main()
{
	n = read();
	m = read();
	for (int i = 1; i <= m; i++)
	{
		int x = read(), y = read();
		e[x].push_back(y);
	}
	for (int i = 1; i <= n; i++)
		if (!dfn[i])
			Tarjan(i);
	sort(scc.begin(), scc.end());
	for (auto now : scc)
	{
		for (auto x : now)
			printf("%d ", x);
		printf("\n");
	}
	return 0;
}
