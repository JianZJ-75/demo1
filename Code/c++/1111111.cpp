#include <bits/stdc++.h>
using namespace std;

int read()
{
    char c = getchar();
    int num = 0;
    for (; c < '0' || c > '9'; c = getchar())
        ;
    for (; c >= '0' && c <= '9'; c = getchar())
        num = (num << 1) + (num << 3) + c - '0';
    return num;
}

const int N = 5e3 + 10;
int n, m, _s, _t;

struct cow
{
    int x, y, z;
} e[N];

bool cmp(cow a, cow b)
{
    return a.z < b.z;
}

int tot;

void add(int x, int y, int z)
{
    e[++tot].x = x;
    e[tot].y = y;
    e[tot].z = z;
}

int fa[N];

int getf(int x)
{
    return x == fa[x] ? x : fa[x] = getf(fa[x]);
}

int Kur(int _st)
{
    for (int i = 1; i <= n; i++)
        fa[i] = i;
    int maxx = 0;
    for (int i = _st; i <= tot; i++)
    {
        int x = e[i].x, y = e[i].y, z = e[i].z;
        if (getf(x) == getf(y))
            continue;
        fa[x] = getf(y);
        maxx = max(maxx, z);
        if (getf(_s) == getf(_t))
            return maxx;
    }
    return -1;
}

cow Solve()
{
    sort(e + 1, e + tot + 1, cmp);
    cow ans = {0, 0, -1};
    for (int i = 1; i <= m; i++)
    {
        int maxx = Kur(i);
        int minn = e[i].z;
        if (maxx == -1)
            continue;
        if (ans.z == -1)
        {
            ans = (cow){maxx, minn, 1};
            continue;
        }
        if (maxx * ans.y < ans.x * minn)
            ans = (cow){maxx, minn, 1};
    }
    return ans;
}

int _gcd(int x, int y)
{
    return y ? _gcd(y, x % y) : x;
}

signed main()
{
    n = read();
    m = read();
    for (int i = 1; i <= m; i++)
    {
        int x = read(), y = read(), z = read();
        add(x, y, z);
    }
    _s = read();
    _t = read();
    cow ans = Solve();
    if (ans.z == -1)
    {
        printf("IMPOSSIBLE");
        return 0;
    }
    int u = _gcd(ans.x, ans.y);
    printf("%d", ans.x / u);
    if (ans.y != u)
        printf("/%d", ans.y / u);
    return 0;
}