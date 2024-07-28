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

const ll N = 2e5 + 10;
ll x[N], y[N], d[N];
const int dict[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
ll n;

ll check(ll mid) {
    ll mxx = -INF, mxy = -INF;
    ll mnx = INF, mny = INF;
    rep(i, 1, n){
        mxx = max(mxx, x[i] + mid * dict[d[i]][0]);
        mxy = max(mxy, y[i] + mid * dict[d[i]][1]);
        mnx = min(mnx, x[i] + mid * dict[d[i]][0]);
        mny = min(mny, y[i] + mid * dict[d[i]][1]);
    }
    return 2 * (mxx - mnx + mxy - mny);
} 

void Jian()
{
    cin >> n;
    rep(i, 1, n) {
        char op;
        cin >> x[i] >> y[i] >> op;
        if(op == 'W') d[i] = 0;
        if(op == 'S') d[i] = 1;
        if(op == 'N') d[i] = 2;
        if(op == 'E') d[i] = 3;
    }
    ll l = 1, r = 2e9;
    while (r - l > 2) {
        ll mid = l + (r - l) / 3, mmid = r - (r - l) / 3;
        if (check(mid) <= check(mmid))
            r = mmid;
        else
            l = mid;
    }
    cout << check(l + 1) << endl;
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