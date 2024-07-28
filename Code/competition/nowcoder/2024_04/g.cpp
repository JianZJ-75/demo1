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

dd calc(dd x1, dd y1, dd x2, dd y2) {
    dd tmp = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    return sqrt(tmp);
}

void Jian()
{
    dd x1, y1, x2, y2;
    scanf("%lf %lf %lf %lf", &x1, &y1, &x2, &y2);
    x1 = -x1;
    dd ans1 = calc(x1, y1, x2, y2);
    x1 = -x1;
    y1 = -y1;
    dd ans2 = calc(x1, y1, x2, y2);
    printf("%.9lf\n", min(ans1, ans2));
}

signed main()
{
//     srand(time(0));
//     ios::sync_with_stdio(false);
//     cin.tie(0);
//     cout.tie(0);
    int _ = 1;
    scanf("%d", &_);
    while (_--)
        Jian();
    return 0;
}