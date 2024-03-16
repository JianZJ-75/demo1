#include <bits/stdc++.h>
#define ll long long
#define dd double
#define endl '\n'
#define rep(i, a, b) for (ll i = a; i <= b; i++)
#define rrep(i, a, b) for (ll i = a; i >= b; i--)
const int M = 1e9 + 7;

using namespace std;

ll qmi(ll a, ll b, ll mod)
{
    ll ret = 1;
    while (b)
    {
        if (b & 1)
            ret = ret * a % mod;
        b /= 2;
        a = a * a % mod;
    }
    return ret;
}

ll gcd(ll a, ll b)
{
    if(a < b)
        swap(a, b);
    return b ? gcd(b , a % b) : a;
}

struct Node
{
    ll value;
    ll k;
    bool operator<(const Node &p) const
    {
        return value < p.value;
    }
};

void Jian()
{
    priority_queue<Node> q;
    priority_queue<int> q;//默认大根堆
    priority_queue<int, vector<int>, greater<int>> a;//小根堆
    priority_queue<int, vector<int>, less<int>> b;//大根堆
    a.empty();//判断是否为空
    a.size();//元素个数
    a.pop();//去顶
    a.push(1);//插入
    a.top();//对顶元素
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