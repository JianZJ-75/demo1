#include <bits/stdc++.h>
using namespace std;
int read()
{
    int num = 0;
    bool flag = 1;
    char c = getchar();
    for (; c < '0' || c > '9'; c = getchar())
    {
        if (c == '-')
            flag = 0;
    }
    for (; c >= '0' && c <= '9'; c = getchar())
    {
        num = (num << 1) + (num << 3) + c - '0';
    }
    return flag ? num : -num;
}
#define ll long long
const int N = 1e5 + 10;
const int inf = 1e9 + 10;
int n, m, a[N];
queue<int> q[N];
array<int, 2> c[N];
priority_queue<array<int, 3>> Q;
signed main()
{
    int T = read();
    while (T--)
    {
        n = read();
        m = read();
        for (int i = 1; i <= n; i++)
        {
            a[i] = read();
            while (!q[i].empty())
            {
                q[i].pop();
            }
        }
        for (int i = 1; i <= m; i++)
        {
            c[i][0] = read(); // xj
            c[i][1] = read(); // tj
        }
        sort(c + 1, c + m + 1);
        ll ans = 0;
        for (int i = 1; i <= m; i++)
        {
            q[c[i][1]].push(c[i][0]);
        }
        for (int i = 1; i <= n; i++)
        {
            if (q[i].empty())
            {
                Q.push({-inf, a[i], i});
                continue;
            }
            int p = q[i].front();
            q[i].pop();
            Q.push({-p, a[i], i});
        }
        int nowid = 1;
        while (!Q.empty())
        {
            auto it = Q.top();
            // 距离 电量 id
            Q.pop();
            int x = -it[0], pw = it[1], id = it[2];
            if (x < ans && x != inf)
            {
                // 无后续, 直接加INF
                if (q[id].empty())
                {
                    Q.push({-inf, pw, id});
                    continue;
                }
                // 有后续, 加后续第一个
                int nw = q[id].front();
                q[id].pop();
                Q.push({-nw, pw, id});
                continue;
            }
            if (nowid > m || ans + pw < c[nowid][0])
            {
                ans += pw;
                continue;
            }
            pw -= c[nowid][0] - ans;
            if (pw != 0 && c[nowid][1] != id)
            {
                Q.push({-x, pw, id});
            }
            ans = c[nowid][0];
            id = c[nowid][1];
            nowid++;
            if (q[id].empty())
            {
                x = inf;
            }
            else
            {
                x = q[id].front();
                q[id].pop();
            }
            pw = a[id];
            Q.push({-x, pw, id});
        }
        printf("%lld\n", ans);
    }
    return 0;
}