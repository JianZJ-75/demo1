#include <bits/stdc++.h>
using namespace std;
#define ll long long
ll n;
ll read()
{
    ll num = 0;
    bool flag = 1;
    char c = getchar();
    for (; c < '0' || c > '9'; c = getchar())
        if (c == '-')
            flag = 0;
    for (; c >= '0' && c <= '9'; c = getchar())
        num = (num << 1) + (num << 3) + c - '0';
    return flag ? num : -num;
}
int ck(int p)
{
    int sum = 0;
    while (p)
    {
        sum += p % 10;
        p /= 10;
    }
    return sum;
}
const ll Mod = 1e6;
int p[1000010];
signed main()
{
    for (int i = 1; i <= 1e6; i++)
        p[i] = ck(i);
    int T = read();
    while (T--)
    {
        n = read();
        ll m = n;
        vector<int> d;
        while (n)
        {
            d.push_back(n % 10);
            n /= 10;
        }
        reverse(d.begin(), d.end());
        int Max_S = 0, sum = 0;
        n = d.size();
        for (int i = 0; i < n; i++)
        {
            if (d[i] && Max_S < sum + d[i] - 1 + 9 * (n - i - 1))
                Max_S = sum + d[i] - 1 + 9 * (n - i - 1);
            sum += d[i];
        }
        Max_S = max(Max_S, sum);
        int ans = 0;
        for (ll i = 1; i * i <= m; i++)
        {
            int sh = m % i;
            if (sh > Max_S)
                continue;
            if (i > 9 && p[i % Mod] + p[i / Mod] == sh)
                ans++;
            ll u = (m - sh) / i;
            for (; u > i && sh <= Max_S; u--, sh += i)
                if (u > 9 && p[u / Mod] + p[u % Mod] == sh)
                    ans++;
        }
        printf("%d\n", ans);
    }
    return 0;
}