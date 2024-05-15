#include <bits/stdc++.h>
using namespace std;
typedef double db;
const db EPS = 1e-9;

inline int sign(db a) { return a < -EPS ? -1 : a > EPS; }

inline int cmp(db a, db b) { return sign(a - b); }

struct P
{
    db x, y;
    P() {}
    P(db _x, db _y) : x(_x), y(_y) {} // 点的加减乘除基本运算
    P operator+(P p) { return {x + p.x, y + p.y}; }
    P operator-(P p) { return {x - p.x, y - p.y}; }
    P operator*(db d) { return {x * d, y * d}; }
    P operator/(db d) { return {x / d, y / d}; }

    bool operator<(P p) const
    { // 先比较x大小，再比较y 返回小的
        int c = cmp(x, p.x);
        if (c)
            return c == -1;
        return cmp(y, p.y) == -1;
    }

    bool operator==(P o) const
    {
        return cmp(x, o.x) == 0 && cmp(y, o.y) == 0;
    }

    db dot(P p) { return x * p.x + y * p.y; }
    db det(P p) { return x * p.y - y * p.x; } // 叉积 正为逆时针方向

    db distTo(P p) { return (*this - p).abs(); } // 求点到点的距离
    db alpha() { return atan2(y, x); }           // 求极角
    void read() { cin >> x >> y; }
    void write() { cout << "(" << x << "," << y << ")" << endl; }
    db abs() { return sqrt(abs2()); } // 求两点距离
    db abs2() { return x * x + y * y; }
    P rot90() { return P(-y, x); }     // 旋转 90度
    P unit() { return *this / abs(); } //
    int quad() const { return sign(y) == 1 || (sign(y) == 0 && sign(x) >= 0); }
    P rot(db an) { return {x * cos(an) - y * sin(an), x * sin(an) + y * cos(an)}; }
};
#define cross(p1, p2, p3) ((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y))
#define crossOp(p1, p2, p3) sign(cross(p1, p2, p3))
bool isMiddle(db a, db m, db b)
{
    return sign(a - m) == 0 || sign(b - m) == 0 || (a < m != b < m);
}

bool isMiddle(P a, P m, P b)
{
    return isMiddle(a.x, m.x, b.x) && isMiddle(a.y, m.y, b.y);
}
// 点 p 在线段 p1p2 上
bool onSeg(P p1, P p2, P q)
{
    return crossOp(p1, p2, q) == 0 && isMiddle(p1, q, p2);
}
// 求直线 p1p2, q1q2 的交点
P isLL(P p1, P p2, P q1, P q2)
{
    db a1 = cross(q1, q2, p1), a2 = -cross(q1, q2, p2);
    return (p1 * a2 + p2 * a1) / (a1 + a2);
}
//-------------------这里开始是多边形，前面都是点线段的代码------------------

db area(vector<P> ps)
{
    db res = 0;
    for (int i = 0; i < ps.size(); i++)
        res += ps[i].det(ps[(i + 1) % ps.size()]);
    return abs(res) / 2;
} // 面积，只有点按照逆时针或顺时针才能这么算

int contain(vector<P> ps, P p)
{ // 2:inside,1:on_seg,0:outside
    int n = ps.size(), ret = 0;
    for (int i = 0; i < n; i++)
    {
        P u = ps[i], v = ps[(i + 1) % n];
        if (onSeg(u, v, p))
            return 1;
        if (cmp(u.y, v.y) <= 0)
            swap(u, v);
        if (cmp(p.y, u.y) > 0 || cmp(p.y, v.y) <= 0)
            continue;
        ret ^= crossOp(p, u, v) > 0;
    }
    return ret * 2;
} // 点包含

// 凸包：包含所有点的一个凸多边形，且顶点都是给定点
vector<P> convexHull(vector<P> ps)
{
    int n = ps.size();
    if (n <= 1)
        return ps;
    sort(ps.begin(), ps.end());
    vector<P> qs(n * 2);
    int k = 0;
    for (int i = 0; i < n; qs[k++] = ps[i++])
        while (k > 1 && crossOp(qs[k - 2], qs[k - 1], ps[i]) <= 0)
            --k;
    for (int i = n - 2, t = k; i >= 0; qs[k++] = ps[i--])
        while (k > t && crossOp(qs[k - 2], qs[k - 1], ps[i]) <= 0)
            --k;
    qs.resize(k - 1);
    return qs;
} // 严格的凸包（不含180°角）
vector<P> convexHullNonStrict(vector<P> ps)
{
    int n = ps.size();
    if (n <= 1)
        return ps;
    sort(ps.begin(), ps.end());
    vector<P> qs(n * 2);
    int k = 0;
    for (int i = 0; i < n; qs[k++] = ps[i++])
        while (k > 1 && crossOp(qs[k - 2], qs[k - 1], ps[i]) < 0)
            --k;
    for (int i = n - 2, t = k; i >= 0; qs[k++] = ps[i--])
        while (k > t && crossOp(qs[k - 2], qs[k - 1], ps[i]) < 0)
            --k;
    qs.resize(k - 1);
    return qs;
} // 不严格的凸包（含180°角）
// 注意这个一定要去重

vector<P> convexCut(const vector<P> &ps, P q1, P q2)
{
    vector<P> qs;
    int n = ps.size();
    for (int i = 0; i < n; i++)
    {
        P p1 = ps[i], p2 = ps[(i + 1) % n];
        int d1 = crossOp(q1, q2, p1), d2 = crossOp(q1, q2, p2);
        if (d1 >= 0)
            qs.push_back(p1);
        if (d1 * d2 < 0)
            qs.push_back(isLL(p1, p2, q1, q2));
    }
    return qs;
} // q1 q2分割凸多边形ps后变成的新凸多边形

db convexDiameter(vector<P> ps)
{
    int n = ps.size();
    if (n <= 1)
        return 0;
    int is = 0, js = 0;
    for (int k = 1; k < n; k++)
        is = ps[k] < ps[is] ? k : is, js = ps[js] < ps[k] ? k : js;
    int i = is, j = js;
    db ret = ps[i].distTo(ps[j]);
    do
    {
        if ((ps[(i + 1) % n] - ps[i]).det(ps[(j + 1) % n] - ps[j]) >= 0)
            (++j) %= n;
        else
            (++i) %= n;
        ret = max(ret, ps[i].distTo(ps[j]));
    } while (i != is || j != js);
    return ret;
} // 这些点中最远的两个点的点距离
signed main()
{
    return 0;
}
