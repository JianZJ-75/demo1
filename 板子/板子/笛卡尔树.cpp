// һ������ȡ����СֵΪ��
// �ֳ��������������Ҷ���
// ���߷ֱ��ظ���Щ����
#include <bits/stdc++.h>
using namespace std;
// ����1��������СֵΪ�����˵��lca
// ����2�������������ԭ����
/*����3��һ��������Ƚڵ㣬���������Ƚڵ㵽������·���ǵ�һ���� ��/�� ��·��
����ô������Ƚڵ���� ��/�� �ߵ�һ��С�ڵ���������*/
const int N = 1e5 + 10;
int n, a[N], l[N], r[N];
void build()
{
  stack<int> st;
  int root = 0;
  for (int i = 1; i <= n; i++)
  {
    int last = 0;
    while (!st.empty() && a[st.top()] > a[i])
    {
      last = st.top();
      st.pop();
    }
    if (!st.empty())
      r[st.top()] = i;
    else
      root = i;
    l[i] = last;
    st.push(i);
  }
}
signed main()
{
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]);
  return 0;
}
