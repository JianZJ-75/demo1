#include <bits/stdc++.h>
using namespace std;
int read()
{
	int num = 0;
	bool flag = 1;
	char c = getchar();
	for (; c < '0' || c > '9'; c = getchar())
		;
	for (; c >= '0' && c <= '9'; c = getchar())
		num = (num << 1) + (num << 3) + c - '0';
	return flag ? num : -num;
}
const int N = 1e5 + 10;
map<int, int> lsh;
struct Q
{
	int l, r, id;
} Qu[N], Ch[N];
int v[N];
bool cmpQu(Q a, Q b)
{
	if (v[a.l] ^ v[b.l])
		return a.l < b.l;
	if (v[a.r] ^ v[b.r])
		if (v[a.l] & 1)
			return a.r < b.r;
		else
			return a.r > b.r;
	return a.id < b.id;
}
int cnt[N << 1], cnt_cnt[N], ans[N];
int n, q, a[N], tot, Qu_tot, Ch_tot;
void add(int x)
{
	cnt_cnt[cnt[a[x]]]--;
	cnt_cnt[++cnt[a[x]]]++;
}
void del(int x)
{
	cnt_cnt[cnt[a[x]]--]--;
	cnt_cnt[cnt[a[x]]]++;
}
void Time(int t, int i)
{
	int l = Qu[i].l, r = Qu[i].r;
	int pos = Ch[t].l, val = Ch[t].r;
	if (pos >= l && pos <= r)
	{
		cnt_cnt[cnt[a[pos]]--]--;
		cnt_cnt[cnt[a[pos]]]++;
		cnt_cnt[cnt[val]]--;
		cnt_cnt[++cnt[val]]++;
	}
	swap(Ch[t].r, a[pos]);
}
int main()
{
	n = read();
	q = read();
	for (int i = 1; i <= n; i++)
	{
		a[i] = read();
		if (!lsh[a[i]])
			lsh[a[i]] = ++tot;
		a[i] = lsh[a[i]];
	}
	for (int i = 1; i <= q; i++)
	{
		int t = read();
		if (t == 1)
		{
			Qu[++Qu_tot].l = read();
			Qu[Qu_tot].r = read();
			Qu[Qu_tot].id = i;
		}
		else
		{
			Ch[++Ch_tot].l = read();
			Ch[Ch_tot].r = read();
			Ch[Ch_tot].id = i;
			if (!lsh[Ch[Ch_tot].r])
				lsh[Ch[Ch_tot].r] = ++tot;
			Ch[Ch_tot].r = lsh[Ch[Ch_tot].r];
		}
	}
	int gh = pow(n, 2.0 / 3.0), l = 1, r = 0, t = 0;
	for (int i = 1; i <= n; i++)
		v[i] = (i - 1) / gh + 1;
	sort(Qu + 1, Qu + Qu_tot + 1, cmpQu);
	Ch[++Ch_tot].id = N;
	// �Ⱥ��˳������Ҫע��
	for (int i = 1; i <= Qu_tot; i++)
	{
		int _l = Qu[i].l, _r = Qu[i].r,
			_t = Qu[i].id, Ans = 1;
		while (r < _r)
			add(++r);
		while (l > _l)
			add(--l);
		while (l < _l)
			del(l++);
		while (r > _r)
			del(r--);
		while (_t > Ch[t + 1].id)
			Time(++t, i);
		while (_t < Ch[t].id)
			Time(t--, i);
		while (cnt_cnt[Ans])
			Ans++;
		ans[Qu[i].id] = Ans;
	}
	for (int i = 1; i <= q; i++)
		if (ans[i])
			printf("%d\n", ans[i]);
	return 0;
}
