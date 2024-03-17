#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

ll gcd(ll a, ll b)
{
    if (a < b)
        swap(a, b);
    return b ? gcd(a % b, b) : a;
}

void Jian()
{
    ll n, a, b, p, q;
    cin >> n >> a >> b >> p >> q;
    ll sum = 0;
    ll c = a * b / gcd(a, b);
    sum += (n / a - n / c) * p;
    sum += (n / b - n / c) * q;
    sum += n / c * max(p, q);
    cout << sum << endl;
}

int main()
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