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
#define mmax(a, b) (a) >= (b) ? (a) : (b)
#define mmin(a, b) (a) <= (b) ? (a) : (b)

using namespace std;

ll read()
{
    ll x = 0, f = 1; char c = getchar();
    while (c < '0' || c > '9') { if (c == '-') f = -1; c = getchar(); }
    while (c >= '0' && c <= '9') { x = x * 10 + c - '0'; c = getchar(); }
    return x * f;
}

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

struct P {
    ll w;
    ll v;
};

const ll N = 1e4 + 30;
ll n, m, k;
ll ls[N], f[N];

bool cmp(P a, P b)
{
    if (a.w == b.w)
        return a.v < b.v;
    return a.w < b.w;
}

void Jian()
{
    cin >> n >> m >> k;
    P a[n + 1];
    rep(i, 1, n)
    {
        cin >> a[i].w >> a[i].v;
    }
    sort(a + 1, a + 1 + n, cmp);
    ls[n + 1] = 0;
    priority_queue<ll, vector<ll>, greater<ll>> q;
    ll tmp = 0;
    rrep(i, n, 1)
    {
        q.push(a[i].v);
        tmp += a[i].v;
        while (q.size() > k)
        {
            tmp -= q.top();
            q.pop();
        }
        ls[i] = tmp;
    }
    ll ans = ls[1];
    rep(i, 1, n)
        rrep(j, m, a[i].w)
        {
            f[j] = max(f[j], f[j - a[i].w] + a[i].v);
            ans = max(ans, f[j] + ls[i + 1]);
        }
    cout << ans << endl;
}

signed main()
{
    srand(time(0));
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        Jian();
    return 0;
}