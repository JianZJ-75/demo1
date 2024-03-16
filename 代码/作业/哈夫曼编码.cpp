#include <bits/stdc++.h>
#include <windows.h>
#include <conio.h>
#define ll long long
#define dd double
#define node pair<double, int>
const int N = 1e4;
const int M = 2 * N - 1;

using namespace std;

struct hfmTree
{
    char code;
    int weight;
    int parent, l, r;
    int ret;
} hfm[M + 1];

int n, length, len, ret = 1;
int A[100];
char B[100];

void Initialization_file()
{
    FILE *fp;                       // 文件指针
    fp = fopen("hfmTree.txt", "w"); // 打开文件，以写入方式打开
    for (int i = 0; i < n; i++)
        fprintf(fp, "%d ", hfm[i].weight); // 循环写入数据
    for (int i = 0; i < n; i++)
        fprintf(fp, "%c", hfm[i].code); // 循环写入数据
    fclose(fp);                         // 关闭文件
}

void Initialization_read()
{
    cout << "请输入字符集大小n:\n";
    cin >> n;
    cout << "请依次输入n个字符:\n";
    getchar();
    string x;
    getline(cin, x);
    for (int i = 1; i <= n; i++)
    {
        hfm[i].code = '\0';
        hfm[i].l = 0;
        hfm[i].r = 0;
        hfm[i].weight = 0;
        hfm[i].parent = 0;
        hfm[i].ret = 0;
        hfm[i].code = x[i - 1];
    }
    cout << "请按以上输入字符顺序对应输入其权值:\n";
    for (int i = 1; i <= n; i++)
        cin >> hfm[i].weight;
}

int Initialization_select(int nn)
{
    int i, temp, min;
    for (i = 1; i <= nn; i++)
    {
        if (hfm[i].ret == 0)
        {
            temp = hfm[i].weight;
            min = i;
            break;
        }
    }
    for (i = 1; i <= nn; i++)
    {
        if (hfm[i].ret == 0 && temp > hfm[i].weight)
        {
            temp = hfm[i].weight;
            min = i;
        }
    }
    hfm[min].ret = 1;
    return min;
}

void Initialization()
{
    Initialization_read();
    int m = 2 * n - 1;
    for (int i = n + 1; i <= m; i++)
    {
        hfm[i].l = 0;
        hfm[i].r = 0;
        hfm[i].weight = 0;
        hfm[i].parent = 0;
        hfm[i].ret = 0;
    }
    for (int i = n + 1; i <= (2 * n - 1); i++)
    {
        int ret1 = Initialization_select(i - 1);
        int ret2 = Initialization_select(i - 1);
        hfm[i].weight = hfm[ret1].weight + hfm[ret2].weight;
        hfm[ret1].parent = i;
        hfm[ret2].parent = i;
        hfm[i].l = ret1;
        hfm[i].r = ret2;
    }
    Initialization_file();
    system("cls");
    cout << "初始化完成!\n";
    cout << "按任意键继续\n";
    getch();
}

void Encoding_getcode()
{
    int get;
    string s;
    cout << "请输入要编码的字符:\n";
    getchar();
    getline(cin, s);
    int m = s.length();
    for (int i = m - 1; i >= 0; i--)
    {
        for (int j = 1; j <= n; j++)
            if (s[i] == hfm[j].code)
                get = j;
        while (hfm[get].parent)
        {
            if (hfm[hfm[get].parent].l == get)
                A[length] = 0;
            else
                A[length] = 1;
            length++;
            get = hfm[get].parent;
        }
    }
    length--;
}

void Encoding_file()
{
    FILE *fp;
    fp = fopen("CodeFile", "w");
    int i;
    for (i = length; i >= 0; i--)
    {
        fprintf(fp, "%d ", A[i]);
        cout << A[i];
    }
    cout << "\n按任意键继续\n";
	getch();
    fclose(fp);
    cout << endl;
}

void Encoding()
{
    Encoding_getcode();
    Encoding_file();
    system("cls");
    cout << "编码完成!\n";
    cout << "按任意键继续";
    getch();
}

void Decoding_getcode()
{
    int len = 0, rr = 2 * n - 1;
    for (int i = length; i >= 0; i--)
    {
        if (A[i] == 1)
        {
            rr = hfm[rr].r;
            if (hfm[rr].r == 0)
            {
                B[len] = hfm[rr].code;
                len++;
                rr = 2 * n - 1;
            }
        }
        else
        {
            rr = hfm[rr].l;
            if (hfm[rr].l == 0)
            {
                B[len] = hfm[rr].code;
                len++;
                rr = 2 * n - 1;
            }
        }
    }
    len--;
}

void Decoding_file()
{
    FILE *fp;
    fp = fopen("TextFile", "w");
    int i;
    for (i = length; i >= 0; i--)
        fprintf(fp, "%d ", B[i]);
    fclose(fp);
    cout << endl;
}

void Decoding()
{
    Decoding_getcode();
    Decoding_file();
    system("cls");
    cout << "译码完成!\n";
    cout << "按任意键继续";
    getch();
}

void Print_file()
{
    FILE *fp;
    fp = fopen("CodePrin", "w");
    int i;
    for (i = length; i >= 0; i--)
        fprintf(fp, "%d ", B[i]);
    fclose(fp);
    cout << endl;
}

void Print()
{
    Print_file();
    cout << B << endl;
    cout << endl;
    cout << "按任意键继续\n";
    getch();
    system("cls");
    cout << "打印结束!\n";
    cout << "按任意键继续";
    getch();
}

void Treeprinting_file()
{
    FILE *fp;
    fp = fopen("Treeprint.txt", "w");
    for (int i = 0; i < n; i++)
        fprintf(fp, "%d ", hfm[i].weight);
    for (int i = 0; i < n; i++)
        fprintf(fp, "%c", hfm[i].code);
    for (int i = 0; i < n; i++)
        fprintf(fp, "%d", hfm[i].l);
    for (int i = 0; i < n; i++)
        fprintf(fp, "%d", hfm[i].r);
    fclose(fp);
}

void Treeprinting()
{
    Treeprinting_file();
    cout << "结点\tweigt\tcode\tl\tr\n";
    for (int i = 1; i <= n; i++)
    {
        cout << i << "\t";
        cout << hfm[i].weight << "\t";
        cout << hfm[i].code << "\t";
        cout << hfm[i].l << "\t";
        cout << hfm[i].r << "\n";
    }
    cout << "按任意键继续\n";
    getch();
    system("cls");
    cout << "打印结束!\n";
    cout << "按任意键继续";
    getch();
}

void Notice()
{
    cout << "I——初始化\n";
    cout << "E——编码\n";
    cout << "D——译码\n";
    cout << "P——打印代码文件\n";
    cout << "T——打印哈夫曼树\n";
    cout << "请选择你要进行的操作:\n";
    cout << "注意:若想退出系统请输入0\n";
}

void Decide()
{
    char tp;
    cin >> tp;
    switch (tp)
    {
    case 'I':
    {
        Initialization();
        break;
    }
    case 'E':
    {
        Encoding();
        break;
    }
    case 'D':
    {
        Decoding();
        break;
    }
    case 'P':
    {
        Print();
        break;
    }
    case 'T':
    {
        Treeprinting();
        Sleep(1000);
        break;
    }
    case '0':
    {
        cout << "即将退出系统...\n";
        ret = 0;
        return;
    }
    default:
    {
        cout << "选择无效,请重新选择正确操作:\n";
        cout << "注意:若想退出系统请输入0\n";
        Decide();
    }
    }
}

int main()
{
    cout << "欢迎进入哈夫曼编/译码系统!\n";
    Notice();
    Decide();
    while (ret != 0)
    {
        cout << "请选择你的下一步操作:\n";
        Notice();
        Decide();
    }
    cout << "感谢您的使用!再见!\n";
    return 0;
}
