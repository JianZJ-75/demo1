#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char dict[] = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
int value[] = {184, 1, 2, 4, 77, 53, 66, 44, 32, 22, 47, 88, 99, 100, 107, 34, 55, 58, 49, 54, 23, 17, 71, 85, 57, 119, 74};

typedef struct TNode
{
    char key;                 // 代表字母
    int value;                // 权值
    int len;                  // 编码长度
    int t[100];               // 编码
    struct TNode *fa, *l, *r; // 父节点 左子节点 右子节点
} node;

int n = 27;    // 字符数
node *hfm[53]; // 53 = 2 * 27 - 1

void Init() // 初始化
{
    for (int i = 0; i < 53; i++)
    {
        hfm[i] = (node *)malloc(sizeof(node));
        if (i < n)
            hfm[i]->key = dict[i],
            hfm[i]->value = value[i];
        hfm[i]->len = 0;
        hfm[i]->fa = NULL;
        hfm[i]->l = NULL;
        hfm[i]->r = NULL;
    }
}

void Traverse(node *root, int p) // 遍历二叉树
{
    if (root->l != NULL)
        Traverse(root->l, p);
    if (root->r != NULL)
        Traverse(root->r, p);
    if (root->l == NULL && root->r == NULL)
        root->t[++root->len] = p;
}

void Find(int len, int *s1, int *s2) // 寻找最小
{
    int min;
    for (int i = 0; i <= len; i++) // 寻找第一个父节点为空的并记录
        if (hfm[i]->fa == NULL)
        {
            min = i;
            break;
        }
    for (int i = min; i <= len; i++) // 寻找父节点为空的最小
        if (hfm[i]->fa == NULL && hfm[i]->value < hfm[min]->value)
            min = i;
    *s1 = min;
    for (int i = 0; i <= len; i++) // 寻找第一个父节点为空并记录
        if (hfm[i]->fa == NULL && i != *s1)
        {
            min = i;
            break;
        }
    for (int i = min; i <= len; i++) // 寻找父节点为空的第二小
        if (hfm[i]->fa == NULL && hfm[i]->value < hfm[min]->value && i != *s1)
            min = i;
    *s2 = min;
}

void Print() // 打印编码
{
    for (int i = 0; i < n; i++)
    {
        printf("%c  ", hfm[i]->key);
        for (int j = hfm[i]->len; j > 0; j--)
            printf("%d", hfm[i]->t[j]);
        printf("\n");
    }
}

void Createhfm() // 创建哈夫曼树
{
    int rear = n - 1;
    while (rear != 52)
    {
        int s1, s2;
        Find(rear, &s1, &s2);                                 // 获取最小和次小的下标
        hfm[++rear]->value = hfm[s1]->value + hfm[s2]->value; // 存新节点
        Traverse(hfm[s1], 0);                                 // 将最小的次小节点的子节点哈夫曼编码更新
        Traverse(hfm[s2], 1);
        hfm[rear]->l = hfm[s1]; // 更新新节点的数据
        hfm[rear]->r = hfm[s2];
        hfm[rear]->fa = NULL;
        hfm[s1]->fa = hfm[rear];
        hfm[s2]->fa = hfm[rear];
    }
}

void Encoding() // 编码
{
    char a[10000];
    gets(a); // 读取字符串
    int len = strlen(a);
    if (strcmp(a, "N") == 0) // 特判
        return;
    for (int i = 0; i < len; i++) // 遍历字符串输出编码
    {
        int q = a[i] - 'A' + 1;
        if (a[i] == ' ')
            q = 0;
        for (int j = hfm[q]->len; j > 0; j--)
            printf("%d", hfm[q]->t[j]);
    }
    printf("\n");
}

void Coding() // 解码
{
    char a[10000];
    gets(a); // 读取字符串
    int len = strlen(a);
    if (strcmp(a, "N") == 0) // 特判
        return;
    node *root = hfm[52];
    node *ans = root;
    for (int i = 0; i < len; i++) // 遍历编码
    {
        if (a[i] == '0') // 根据编码顺序从根节点往下寻找
        {
            if (ans->l != NULL)
                ans = ans->l;
            else // 若该节点无子节点，则输出该节点的字母，并重新回到根节点
            {
                printf("%c", ans->key);
                ans = root;
                if (i != len - 1)
                    i--;
            }
        }
        else
        {
            if (ans->r != NULL)
                ans = ans->r;
            else // 若该节点无子节点，则输出该节点的字母，并重新回到根节点
            {
                printf("%c", ans->key);
                ans = root;
                if (i != len - 1)
                    i--;
            }
        }
    }
    printf("%c", ans->key);
}

int main()
{
    Init();
    Createhfm();
    Print();
    Encoding();
    Coding();
    return 0;
}