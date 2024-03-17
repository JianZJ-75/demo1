#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

void Jian()
{
    string s;
    cin >> s;
    ll len = s.length() - 1;
    rep(i, 0, len)
    {
        cout << s[i];
        if (i >= 2 && s[i] == 'm' && s[i - 1] == 'c' && s[i - 2] == 'a')
            cout << "yyds";
    }
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