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

const ll N = 1e5 + 10;
vector<ll> edges[N];
ll sz[N];
ll n, k, cnt;

void dfs(ll x, ll fa)
{
    sz[x] = 1;
    for (auto i : edges[x])
    {
        if (i == fa)
            continue;
        dfs(i, x);
        sz[x] += sz[i];
    }
}

bool ok(ll x)
{
    ll cnt = 0;
    if (sz[1] >= x)
        cnt += sz[1] / x;
    // rep(i, 1, n)
    //     if (sz[i] >= x)
    //         cnt += sz[i] / x;
    return cnt <= k;
}

void tt(ll x, ll fa, ll mid)
{
    ll q = edges[x].size();
    for (auto i : edges[x])
    {
        if (i == fa)
        {
            q--;
            continue;
        }
        if (q > 1 && sz[i] > mid || q == 1 && sz[i] + 1 > mid)
        {
            cnt++;
            q--;
        }
        
        // if (q == 1 && sz[i] > mid || q > 1 && sz[i] + 1 < mid)
        // {
        //     cnt++;
        //     q--;
        // }
        tt(i, x, mid); 
    }
}

void Jian()
{
    memset(sz, 0, sizeof(sz));
    cin >> n >> k;
    rep(i, 1, n)
        edges[i].clear();
    rep(i, 1, n - 1)
    {
        ll u, v;
        cin >> u >> v;
        edges[u].push_back(v);
        edges[v].push_back(u);
    }
    dfs(1, -1);
    rep(i, 1, n)
    {
        sort(edges[i].begin(), edges[i].end(), [&](ll a, ll b) {
            return sz[a] > sz[b];
        });
    }
    ll l = 0, r = n + 1;
    while (r - l > 1)
    {
        cnt = 0;
        ll mid = (l + r) / 2;
        tt(1, -1, mid);
        if (cnt <= k)
            r = mid;
        else
            l = mid;
        // cout << mid << "    " << cnt << endl;
        // cout << l << " " << r << endl;
    }
    cout << r << endl;
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