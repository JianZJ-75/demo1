#include <bits/stdc++.h>
using namespace std;
#define ubit(a) (64 - __builtin_clzll(a))
// 获得最高的1的位置
#define popcount(a) __builtin_popcountll(a)
// 第一个1的个数
typedef double db;
const db EPS = 1e-9;
// 点(x,y)之间的操作 }

// TOP1
// 点
inline int sign(db a) { return a < -EPS ? -1 : a > EPS; }
// 1)a<0 -> -1  2)a>0 ->1  3)a=0->0
inline int cmp(db a, db b) { return sign(a - b); }
struct P
{
	db x, y;
	P() {}
	P(db _x, db _y) : x(_x), y(_y) {}
	P operator+(P p) { return {x + p.x, y + p.y}; }
	P operator-(P p) { return {x - p.x, y - p.y}; }
	P operator*(db d) { return {x * d, y * d}; }
	P operator/(db d) { return {x / d, y / d}; }
	// 点的加减乘除基本运算
	bool operator<(P p) const
	{ // 两者谁更小
		int c = cmp(x, p.x);
		if (c)
			return c == -1;
		return cmp(y, p.y) == -1;
	}
	bool operator==(P o) const
	{ // 是否相等
		return cmp(x, o.x) == 0 && cmp(y, o.y) == 0;
	}
	db dot(P p) { return x * p.x + y * p.y; }	 // 点积
	db det(P p) { return x * p.y - y * p.x; }	 // 叉积 =|a||b|sin(o) o为a到b逆时针的那个夹角
	db distTo(P p) { return (*this - p).abs(); } // 求点到点的距离
	db alpha() { return atan2(y, x); }			 // 求极角(-pai,pai)(x负半轴为-pai逆时针到pai)
	db abs() { return sqrt(abs2()); }			 // 求两点距离
	db abs2() { return x * x + y * y; }			 // 两点距离平方
	P rot90() { return P(-y, x); }				 // 逆时针旋转90度
	P unit() { return *this / abs(); }
	int quad() const { return sign(y) == 1 || (sign(y) == 0 && sign(x) >= 0); }
	P rot(db an) { return {x * cos(an) - y * sin(an), x * sin(an) + y * cos(an)}; } // 逆时针转an的角度(an弧度制)
};

// Top2
// 线，随便两个点表示一段线 ，要用点的包装
#define cross(p1, p2, p3) ((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y)) //(p1p2 叉乘 p1p3)
#define crossOp(p1, p2, p3) sign(cross(p1, p2, p3))										  // 0是三点共线 1是p1->p2->p3 是逆时针 ，-1则是顺时针

// 直线 p1p2, q1q2 是否恰有一个交点  1表示有交点 0表示无交点
bool chkLL(P p1, P p2, P q1, P q2)
{
	db a1 = cross(q1, q2, p1), a2 = -cross(q1, q2, p2);
	return sign(a1 + a2) != 0;
}

// 求直线 p1p2, q1q2 的交点	(要先用上面的判断是否有交点)
P isLL(P p1, P p2, P q1, P q2)
{
	db a1 = cross(q1, q2, p1), a2 = -cross(q1, q2, p2);
	return (p1 * a2 + p2 * a1) / (a1 + a2);
}

// 判断区间 [l1, r1], [l2, r2] 是否相交
bool intersect(db l1, db r1, db l2, db r2)
{
	if (l1 > r1)
		swap(l1, r1);
	if (l2 > r2)
		swap(l2, r2);
	return !(cmp(r1, l2) == -1 || cmp(r2, l1) == -1);
}

// 线段 p1p2, q1q2 是否相交
bool isSS(P p1, P p2, P q1, P q2)
{
	return intersect(p1.x, p2.x, q1.x, q2.x) && intersect(p1.y, p2.y, q1.y, q2.y) &&
		   crossOp(p1, p2, q1) * crossOp(p1, p2, q2) <= 0 && crossOp(q1, q2, p1) * crossOp(q1, q2, p2) <= 0;
}

// 线段 p1p2, q1q2 严格相交  (不交在端点)
bool isSS_strict(P p1, P p2, P q1, P q2)
{
	return crossOp(p1, p2, q1) * crossOp(p1, p2, q2) < 0 && crossOp(q1, q2, p1) * crossOp(q1, q2, p2) < 0;
}

// m 是否在 a 和 b 线段之间
bool isMiddle(db a, db m, db b)
{
	return sign(a - m) == 0 || sign(b - m) == 0 || (a < m != b < m);
}
// 点m是否在这个ab这个矩形内
bool isMiddle(P a, P m, P b)
{
	return isMiddle(a.x, m.x, b.x) && isMiddle(a.y, m.y, b.y);
}

// 点 p 是否在线段 p1p2 上
bool onSeg(P p1, P p2, P q)
{ // 可能有精度问题
	return crossOp(p1, p2, q) == 0 && isMiddle(p1, q, p2);
}
// q1q2 和 p1p2 的交点 在 p1p2 上？确定的时候不需要crossOp(p1,p2,q) == 0

// 点 p 严格在 p1p2 上
bool onSeg_strict(P p1, P p2, P q)
{
	return crossOp(p1, p2, q) == 0 && sign((q - p1).dot(p1 - p2)) * sign((q - p2).dot(p1 - p2)) < 0;
}

// 求 q 到 直线p1p2 的投影（垂足） p1 != p2
P proj(P p1, P p2, P q)
{
	P dir = p2 - p1;
	return p1 + dir * (dir.dot(q - p1) / dir.abs2());
}

// 求 q 以 直线p1p2 为轴的反射   p1 != p2
P reflect(P p1, P p2, P q)
{
	return proj(p1, p2, q) * 2 - q;
}

// 求 q 到 线段p1p2 的最小距离
db nearest(P p1, P p2, P q)
{
	if (p1 == p2)
		return p1.distTo(q);
	P h = proj(p1, p2, q);
	if (isMiddle(p1, h, p2))
		return q.distTo(h);
	return min(p1.distTo(q), p2.distTo(q));
}

// 求 线段p1p2 与 线段q1q2 的距离
db disSS(P p1, P p2, P q1, P q2)
{
	if (isSS(p1, p2, q1, q2))
		return 0;
	return min(min(nearest(p1, p2, q1), nearest(p1, p2, q2)), min(nearest(q1, q2, p1), nearest(q1, q2, p2)));
}

// TOP3
// 极角排序（x负半轴到逆时针排序）
const int N = 1e5 + 10;
P p[N];
int n;
void Sort()
{
	sort(p + 1, p + n + 1, [&](P &a, P &b)
		 {
		int qa=a.quad(),qb=b.quad();
		if(qa!=qb)return qa<qb;
		  else return sign(a.det(b))>0; });
}
signed main()
{
	return 0;
}
