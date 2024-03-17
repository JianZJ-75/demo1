#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

string t1 = "春日影(MyGO!!!!! ver.)";
string t2 = "春日影";

void Jian()
{
    ll n;
    cin >> n;
    string s[n + 1];
    rep(i, 1, n)
        cin >> s[i];
    rep(i, 1, n)
        if (s[i] == t1 || s[i] == t2)
        {
            cout << "NO\n";
            return;
        }
    cout << "YES\n";
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