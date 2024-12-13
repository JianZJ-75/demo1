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
    ll x = 0, f = 1;
    char c = getchar();
    while (c < '0' || c > '9')
    {
        if (c == '-')
            f = -1;
        c = getchar();
    }
    while (c >= '0' && c <= '9')
    {
        x = x * 10 + c - '0';
        c = getchar();
    }
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

const ll N = 1e5 + 100;
ll n, m;
ll a[N], b[N], x[N], t[N];
map<ll, bool> mp;
map<pii, ll> mmp;

struct P
{
    ll d;
    ll now;
    bool operator<(const P &p) const
    {
        return d < p.d;
    }
    bool operator>(const P &p) const
    {
        return d > p.d;
    }
} p[N];

void init()
{
    mmp.clear();
    mp.clear();
    rep(i, 0, n + 10)
        a[i] = b[i] = 0;
    rep(i, 0, m + 10)
        x[i] = t[i] = 0;
}

void Jian()
{
    cin >> n >> m;
    init();
    rep(i, 1, n)
    {    
        cin >> a[i];
        b[i] = a[i];
    }
    rep(i, 1, m)
    {
        cin >> x[i] >> t[i];
        mp[t[i]] = 1;
    }
    priority_queue<P, vector<P>, greater<P>> q;
    ll sum = 0;
    rep(i, 1, n)
    {
        if (!mp[i])
        {
            sum += a[i];
        }       
    }
    ll tt[n + 1] = {0};
    rrep(i, m, 1)
    {
        if (tt[t[i]] != 0)
        {
            mmp[{t[i], x[i]}] = tt[t[i]];
        }
        tt[t[i]] = x[i];
    }
    a[n + 1] = sum;
    q.push(P{LINF, n + 1});
    rep(i, 1, m)
    {
        q.push(P{x[i], t[i]});
    }
    ll ans = 0;
    ll idx = 1;
    // cout << q.size() << endl;
    // rep(i, 1, n + 1)
    //     cout << a[i] << " ";
    // cout << endl;
    while (!q.empty())
    {
        P tmp = q.top();
        if (idx <= m && ans + a[tmp.now] >= x[idx])
        {
            // cout << tmp.now << " " << x[idx] - ans << endl;
            a[tmp.now] -= x[idx] - ans;
            ans = x[idx];
            q.pop();
            if (tmp.now != n + 1)
                a[n + 1] += a[tmp.now];
            else
                q.push(P{LINF, n + 1});
            // cout << "--------------\n";
            // rep(i, 1, n + 1)
            //     cout << a[i] << " ";
            // cout << endl;
            // cout << "--------------\n";
            if (mmp[{t[idx], x[idx]}] != 0)
            {
                q.push(P{mmp[{t[idx], x[idx]}], t[idx]});
                a[n + 1] -= a[t[idx]];
                a[t[idx]] = b[t[idx]];
            } else {
                a[n + 1] -= a[t[idx]];
                a[t[idx]] = 0;
                a[n + 1] += b[t[idx]];
            }
            idx++;
        } else {
            ans += a[tmp.now];
            a[tmp.now] = 0;
            q.pop();
        }
        // cout << "ans = " << ans << " " << q.size() << endl;
        // rep(i, 1, n + 1)
        //     cout << a[i] << " ";
        // cout << endl;
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
    cin >> _;
    while (_--)
        Jian();
    return 0;
}