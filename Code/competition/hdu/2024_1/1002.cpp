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

ll qmi(ll a, ll b)
{
    ll ret = 1;
    while (b)
    {
        if (b & 1)
            ret = ret * a;
        b /= 2;
        a = a * a;
    }
    return ret;
}

ll gcd(ll a, ll b)
{
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

ll a[1003][5];
ll f[1003][4004];
ll n, k;

ll dfs(ll i, ll j) {
    if (j < 0)
        return 1e13;
    if (f[i][j] != -1)
        return f[i][j];
    if (i > n)
        return 1e13;
    f[i][j] = min(dfs(i + 1, j), min(min(min(dfs(i + 1, j - 4) + a[i][4], dfs(i + 1, j - 3) + a[i][3]), dfs(i + 1, j - 2) + a[i][2]), dfs(i + 1, j - 1) + a[i][1]));
    return f[i][j];
}

void Jian()
{
    rep(i, 1, 1002)
        memset(f[i], -1, sizeof(f[i]));
    cin >> n >> k;
    rep(i, 1, n)
    {
        a[i][0] = 0;
        rep(j, 1, 4)
            cin >> a[i][j];
    }
    f[n + 1][0] = 0;
    cout << dfs(1, k) << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    cin >> _;
    while (_--)
        Jian();
    return 0;
}