#include <bits/stdc++.h>
#define ll long long

using namespace std;

ll qmi(ll a, ll b) {
    ll res = 1;
    while (b) {
        if (b & 1) {
            res = res * a;
        }
        a *= a;
        b /= 2;
    }
    return res;
}

ll gcd(ll a, ll b) {
    if (a < b)
        swap(a, b);
    return b ? gcd(b, a % b) : a;
}

struct P {
    int a;
    int b;
};

void solve() {
    P a = {1, 2}, b = {3, 4};
    P* c = &a;
    cout << c->a << endl;
    cout << (*c).a << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int _ = 1;
    // cin >> _;
    while (_--)
        solve();
    return 0;
}