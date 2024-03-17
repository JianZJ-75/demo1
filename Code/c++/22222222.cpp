#include <bits/stdc++.h>
#define ll long long
#define dd double
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i++)

using namespace std;

const ll N = 1e6 + 1;
ll a[N];
ll sz[N];
ll fa[N];
ll ttt = 0;

void Init(ll n)
{
    rep(i, 1, n)
    {
        fa[i] = i;
        sz[i] = 1;
    }
}

ll Find(ll x)
{
    if (fa[x] == x)
        return x;
    fa[x] = Find(fa[x]);
    sz[x] = sz[Find(fa[x])];
    return fa[x];
}

void Un(ll x, ll y)
{
    ll fx = Find(x), fy = Find(y);
    if (fx == fy)
    {
        return;
    }
    if (sz[fx] > sz[fy])
        swap(fx, fy);
    fa[fx] = fy;
    sz[fy] += sz[fx];
}

struct P
{
    ll x;
    ll y;
};

bool cmp(P a, P b)
{
    if (a.x == b.x)
        return a.y < b.y;
    return a.x < b.x;
}

void Jian()
{
    ll n, m;
    cin >> n >> m;
    Init(n);
    P p[m + 1];
    rep(i, 1, m)
    {
        cin >> p[i].x >> p[i].y;
        if(p[i].x > p[i].y)
            swap(p[i].x, p[i].y);
    }
    sort(p + 1, p + 1 + m, cmp);
    rep(i, 1, m)
    {
        if (i != 1)
        {
            if (p[i].x == p[i - 1].x && p[i].y == p[i - 1].y)
                ttt++;
        }
        Un(p[i].x, p[i].y);
    }
    ll t[n + 1] = {0};
    ll num = 0;
    ll qq = 1000000000;
    ll u = 0;
    ll v = 0;
    rep(i, 1, n)
    {
        ll q = Find(i);
        if (t[q] == 0)
        {
            t[q] = 1;
            ll tt = sz[q] * (sz[q] - 1) / 2;
            num += tt;
            if (sz[q] != 1)
            {
                if(sz[q] < qq)
                    qq = sz[q],
                    v = q;
            }
            else
                u++;
        }
    }
    m -= ttt;
    if (num == m)
    {
        if (u >= 2)
            cout << 1 << endl;
        else if(u == 0)
        {
            ll uu = 1000000000;
            rep(i, 1, n)
            {
                ll q = Find(i);
                if(q != v)
                {
                    uu = min(uu, sz[q]);
                }
            }
            cout << qq * uu << endl;
        }
        else
            cout << qq << endl;
    }
    else
        cout << num - m << endl;
}

int main()
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
