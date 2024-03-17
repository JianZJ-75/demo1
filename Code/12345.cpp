#include <bits/stdc++.h>
#define ll long long
#define dd double

using namespace std;
struct p
{
    ll s;
    ll e;
};
p a[1000010];
bool cmp(p b, p c)
{
    return b.e < c.e;
}
void run()
{
    ll n;
    cin >> n;
    for (ll i = 0; i < n; i++)
        cin >> a[i].s >> a[i].e;
    sort(a, a + n, cmp);
    ll sum = 1;
    for (ll i = 1; i < n; i++)
    {
        ll t = a[0].e;
        if (a[i].s >= t)
        {
            sum++;
            t = a[i].e;
        }
    }
    cout << sum;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    run();
}