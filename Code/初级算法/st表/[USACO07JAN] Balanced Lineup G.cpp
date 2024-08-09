// https://www.luogu.com.cn/problem/P2880
#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define pii pair<ll, ll>
#define x first
#define y second
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3f
const ll maxn = 5e4;
const ll logn = 20;
ll n, m, mx[maxn + 1][logn + 1], Log[maxn + 1], mi[maxn + 1][logn + 1];

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

void init()
{
    rep(i, 2, maxn)
        Log[i] = Log[i / 2] + 1;
    rep(j, 1, logn)
        rep(i, 1, maxn + 1 - (1 << j))
        {
            mx[i][j] = max(mx[i][j - 1], mx[i + (1 << j - 1)][j - 1]);
            mi[i][j] = min(mi[i][j - 1], mi[i + (1 << j - 1)][j - 1]);
        }
}

void Jian()
{
    n = read(), m = read();
    rep(i, 1, n)
    {    
        mx[i][0] = read();
        mi[i][0] = mx[i][0];
    }
    init();
    rep(i, 1, m)
    {
        ll l = read(), r = read();
        ll s = Log[r - l + 1];
        cout << max(mx[l][s], mx[r - (1 << s) + 1][s]) - min(mi[l][s], mi[r - (1 << s) + 1][s]) << endl;
    }
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // _ = read();
    while (_--)
        Jian();
    return 0;
}