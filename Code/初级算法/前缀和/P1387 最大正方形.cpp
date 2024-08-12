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
const ll M = 1e9 + 7;

using namespace std;

const ll N = 101;
ll n, m;
ll a[N][N], pre[N][N];

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

void Jian()
{
    n = read(), m = read();
    rep(i, 1, n)
        rep(j, 1, m)
        {
            a[i][j] = read();
            pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + a[i][j];
        }
    ll ans = 0;
    rep(len, 1, min(n, m))
        rep(i, 1, n - len + 1)
            rep(j, 1, m - len + 1)
                if (pre[i + len - 1][j + len - 1] - pre[i - 1][j + len - 1] - pre[i + len - 1][j - 1] + pre[i - 1][j - 1] == len * len)
                    ans = max(ans, len);
    cout << ans << endl;
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