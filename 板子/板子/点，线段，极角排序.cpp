#include <bits/stdc++.h>
using namespace std;
#define ubit(a) (64 - __builtin_clzll(a))
// �����ߵ�1��λ��
#define popcount(a) __builtin_popcountll(a)
// ��һ��1�ĸ���
typedef double db;
const db EPS = 1e-9;
// ��(x,y)֮��Ĳ��� }

// TOP1
// ��
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
	// ��ļӼ��˳���������
	bool operator<(P p) const
	{ // ����˭��С
		int c = cmp(x, p.x);
		if (c)
			return c == -1;
		return cmp(y, p.y) == -1;
	}
	bool operator==(P o) const
	{ // �Ƿ����
		return cmp(x, o.x) == 0 && cmp(y, o.y) == 0;
	}
	db dot(P p) { return x * p.x + y * p.y; }	 // ���
	db det(P p) { return x * p.y - y * p.x; }	 // ��� =|a||b|sin(o) oΪa��b��ʱ����Ǹ��н�
	db distTo(P p) { return (*this - p).abs(); } // ��㵽��ľ���
	db alpha() { return atan2(y, x); }			 // �󼫽�(-pai,pai)(x������Ϊ-pai��ʱ�뵽pai)
	db abs() { return sqrt(abs2()); }			 // ���������
	db abs2() { return x * x + y * y; }			 // �������ƽ��
	P rot90() { return P(-y, x); }				 // ��ʱ����ת90��
	P unit() { return *this / abs(); }
	int quad() const { return sign(y) == 1 || (sign(y) == 0 && sign(x) >= 0); }
	P rot(db an) { return {x * cos(an) - y * sin(an), x * sin(an) + y * cos(an)}; } // ��ʱ��תan�ĽǶ�(an������)
};

// Top2
// �ߣ�����������ʾһ���� ��Ҫ�õ�İ�װ
#define cross(p1, p2, p3) ((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y)) //(p1p2 ��� p1p3)
#define crossOp(p1, p2, p3) sign(cross(p1, p2, p3))										  // 0�����㹲�� 1��p1->p2->p3 ����ʱ�� ��-1����˳ʱ��

// ֱ�� p1p2, q1q2 �Ƿ�ǡ��һ������  1��ʾ�н��� 0��ʾ�޽���
bool chkLL(P p1, P p2, P q1, P q2)
{
	db a1 = cross(q1, q2, p1), a2 = -cross(q1, q2, p2);
	return sign(a1 + a2) != 0;
}

// ��ֱ�� p1p2, q1q2 �Ľ���	(Ҫ����������ж��Ƿ��н���)
P isLL(P p1, P p2, P q1, P q2)
{
	db a1 = cross(q1, q2, p1), a2 = -cross(q1, q2, p2);
	return (p1 * a2 + p2 * a1) / (a1 + a2);
}

// �ж����� [l1, r1], [l2, r2] �Ƿ��ཻ
bool intersect(db l1, db r1, db l2, db r2)
{
	if (l1 > r1)
		swap(l1, r1);
	if (l2 > r2)
		swap(l2, r2);
	return !(cmp(r1, l2) == -1 || cmp(r2, l1) == -1);
}

// �߶� p1p2, q1q2 �Ƿ��ཻ
bool isSS(P p1, P p2, P q1, P q2)
{
	return intersect(p1.x, p2.x, q1.x, q2.x) && intersect(p1.y, p2.y, q1.y, q2.y) &&
		   crossOp(p1, p2, q1) * crossOp(p1, p2, q2) <= 0 && crossOp(q1, q2, p1) * crossOp(q1, q2, p2) <= 0;
}

// �߶� p1p2, q1q2 �ϸ��ཻ  (�����ڶ˵�)
bool isSS_strict(P p1, P p2, P q1, P q2)
{
	return crossOp(p1, p2, q1) * crossOp(p1, p2, q2) < 0 && crossOp(q1, q2, p1) * crossOp(q1, q2, p2) < 0;
}

// m �Ƿ��� a �� b �߶�֮��
bool isMiddle(db a, db m, db b)
{
	return sign(a - m) == 0 || sign(b - m) == 0 || (a < m != b < m);
}
// ��m�Ƿ������ab���������
bool isMiddle(P a, P m, P b)
{
	return isMiddle(a.x, m.x, b.x) && isMiddle(a.y, m.y, b.y);
}

// �� p �Ƿ����߶� p1p2 ��
bool onSeg(P p1, P p2, P q)
{ // �����о�������
	return crossOp(p1, p2, q) == 0 && isMiddle(p1, q, p2);
}
// q1q2 �� p1p2 �Ľ��� �� p1p2 �ϣ�ȷ����ʱ����ҪcrossOp(p1,p2,q) == 0

// �� p �ϸ��� p1p2 ��
bool onSeg_strict(P p1, P p2, P q)
{
	return crossOp(p1, p2, q) == 0 && sign((q - p1).dot(p1 - p2)) * sign((q - p2).dot(p1 - p2)) < 0;
}

// �� q �� ֱ��p1p2 ��ͶӰ�����㣩 p1 != p2
P proj(P p1, P p2, P q)
{
	P dir = p2 - p1;
	return p1 + dir * (dir.dot(q - p1) / dir.abs2());
}

// �� q �� ֱ��p1p2 Ϊ��ķ���   p1 != p2
P reflect(P p1, P p2, P q)
{
	return proj(p1, p2, q) * 2 - q;
}

// �� q �� �߶�p1p2 ����С����
db nearest(P p1, P p2, P q)
{
	if (p1 == p2)
		return p1.distTo(q);
	P h = proj(p1, p2, q);
	if (isMiddle(p1, h, p2))
		return q.distTo(h);
	return min(p1.distTo(q), p2.distTo(q));
}

// �� �߶�p1p2 �� �߶�q1q2 �ľ���
db disSS(P p1, P p2, P q1, P q2)
{
	if (isSS(p1, p2, q1, q2))
		return 0;
	return min(min(nearest(p1, p2, q1), nearest(p1, p2, q2)), min(nearest(q1, q2, p1), nearest(q1, q2, p2)));
}

// TOP3
// ��������x�����ᵽ��ʱ������
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
