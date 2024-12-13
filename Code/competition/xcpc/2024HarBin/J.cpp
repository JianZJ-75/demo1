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

const ll N = 1e5 + 100;
ll n, m;
// a点亮 b原始电量的备份
ll a[N], b[N];
// 记录哪些会被充电
map<ll, bool> mp;
// 记录是否存在后续充电桩
map<pii, ll> mmp;

struct T 
{
    ll x; // 距离
    ll t; // 所充电瓶
} pp[N];

bool cmp (T a, T b)
{
    return a.x < b.x;
}

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
        pp[i].x = pp[i].t = 0;
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
        cin >> pp[i].x >> pp[i].t;
        mp[pp[i].t] = 1;
    }
    sort(pp + 1, pp + 1 + m, cmp);
    priority_queue<P, vector<P>, greater<P>> q;
    // 把没有充电桩的放在一起
    ll sum = 0;
    rep(i, 1, n)
    {
        if (mp[i] == 0)
        {
            sum += a[i];
        }       
    }
    // tt 记录每个电瓶当前第一个备选充电桩的距离
    ll tt[n + 1];
    rep(i, 1, n)
        tt[i] = LINF;
    rrep(i, m, 1)
    {
        if (tt[pp[i].t] != 0)
        {
            // pp[i].t电瓶在pp[i].x这个充电桩后的第一个充电桩
            mmp[{pp[i].t, pp[i].x}] = tt[pp[i].t];
        }
        tt[pp[i].t] = min(tt[pp[i].t], pp[i].x);
    }
    // 用n + 1代替所有没有充电桩的
    a[n + 1] = sum;
    // LINF为距离 设置无限大
    q.push(P{LINF, n + 1});
    rep(i, 1, m)
    {
        q.push(P{pp[i].x, pp[i].t});
    }
    ll ans = 0;
    // 当前充电桩的下标
    ll idx = 1;
    while (!q.empty())
    {
        P tmp = q.top();
        // 如果还有充电桩, 并且该次电瓶用完前能到达
        if (idx <= m && ans + a[tmp.now] >= pp[idx].x)
        {
            // 减少电量
            a[tmp.now] -= pp[idx].x - ans;
            ans = pp[idx].x;
            q.pop();
            // 如果不是n + 1电瓶 需要把剩余电量加到n + 1
            if (tmp.now != n + 1)
                a[n + 1] += a[tmp.now];
            else
                // 否则把pop的n + 1电瓶重新插入
                q.push(P{LINF, n + 1});
            // 如果该充电桩所充电瓶还存在后续充电桩
            if (mmp[{pp[idx].t, pp[idx].x}] != 0)
            {
                // 把后续充电桩push
                q.push(P{mmp[{pp[idx].t, pp[idx].x}], pp[idx].t});
                // 因为之前把该电瓶剩余电量加入n + 1 需要取出并充满电
                a[n + 1] -= a[pp[idx].t];
                a[pp[idx].t] = b[pp[idx].t];
            } else {
                // 不存在后续充电桩
                // 因为之前把该电瓶剩余电量加入n + 1 需要取出并充满电再重新加入
                a[n + 1] -= a[pp[idx].t];
                // 因为加入n + 1 需要把该电瓶电量清0
                a[pp[idx].t] = 0;
                a[n + 1] += b[pp[idx].t];
            }
            idx++;
        } else {
            // 没到充电桩
            ans += a[tmp.now];
            a[tmp.now] = 0;
            q.pop();
        }
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