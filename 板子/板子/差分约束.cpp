#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 10;
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
int n, m, d[N];
vector<array<int, 3>> e;
signed main()
{
	n = read();
	m = read();
	for (int i = 1; i <= n; i++)
	{
		int x = read(), y = read(), z = read();
		//		e.push_back({y,x,z});
		// d[x]-d[y]<=z -> �𰸵����ֵ
		e.push_back({x, y, z});
		// ��di'=-di(����di),��di'�����ֵ����֪����di����Сֵ
		//(-dx')-(-dy')<=z -> dy'-dx'<=z �߷���������
	}
	for (int i = 1; i <= n; i++)
		e.push_back({0, i, 0});
	// d[0]-d[i]<=0 -> d[0]<=d[i]�������Сֵ������ÿ������ʵ��d0' di',
	//(-d0')<=(-di') di'-d0'<=0
	for (int i = 0; i <= n; i++)
		for (auto k : e)
			d[k[1]] = min(d[k[1]], d[k[0]] + k[2]);
	for (auto k : e)
		if (d[k[1]] > d[k[0]] + k[2])
		{
			printf("-1");
			return 0;
		}
	for (int i = 1; i <= n; i++)
		printf("%d ", -d[i] + d[0]);
	// ����Сֵ��ÿ��ȡ�����������
	return 0;
}
