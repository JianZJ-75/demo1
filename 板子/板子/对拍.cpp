#include<bits/stdc++.h>
using namespace std;
int main()
{
	int T=0;
	while(1)
	{
		T++;
		system("C:\\randsequence.exe");//rand
		double stb=clock();
		system("C:\\1.exe");//暴力 
		double edb=clock();
		double stz=clock();
		system("C:\\2.exe");//正解 
		double edz=clock();
		if(system("fc C:\\1.out  C:\\2.out"))
		{
			cout<<"WA";return 0;
		 }
		 else
		 {
		 	printf("测试点: %d  \n 暴力：%.0lfms\n  正解：%.0lfms\n",T,edb-stb,edz-stz);
		 }
	}
}
