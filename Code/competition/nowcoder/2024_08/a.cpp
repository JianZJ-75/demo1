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

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

ll gcd(ll a, ll b)
{
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

const ll N = 1e5 + 1;

void Jian()
{
    ll n = read();
    ll a[N] = {0};
    ll mx = 0;
    rep(i, 1, n)
    {
        ll x = read();
        a[x] = 1;
        mx = max(mx, x);
    } 
    ll ans = 0;
    rep(i, 1, mx)
    {
        ll k = 0;
        if (a[i])
            continue;
        for (ll j = 2; i * j <= mx; j++)
        {
            if (a[i * j])
                k = gcd(k, j);
            if (k == 1)
            {
                ans++;
                break;
            }
        }
    }
    cout << (ans & 1 ? "dXqwq\n" : "Haitang\n");
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    _ = read();
    while (_--)
        Jian();
    return 0;
}