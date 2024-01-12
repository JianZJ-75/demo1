1、下载VirtualBox
2、CentOS镜像源
	http://isoredirect.centos.org/centos/7/isos/x86_64/
	新加坡国立镜像源min版本
	https://download.nus.edu.sg/mirror/centos/7.9.2009/isos/x86_64/CentOS-7-x86_64-Minimal-2009.iso
3、新建
	![[Pasted image 20240112120739.png]]
	内存8192MB，4CPU
	![[Pasted image 20240112120910.png]]
	磁盘空间30GB，不预先分配全部空间
	![[Pasted image 20240112121040.png]]
4、启动Linux
	光驱即为所下载的镜像源文件
	![[Pasted image 20240112121159.png]]
	不用测试，直接选安装，回车
	![[Pasted image 20240112121301.png]]
	若未出现该界面，按右边ctrl，再点击Linux
	![[Pasted image 20240112121340.png]]
	安装位置直接选
	![[Pasted image 20240112121506.png]]
	打开以太网后开始安装
	![[Pasted image 20240112121527.png]]
5、配置网络
	ip addr 查看ip
	![[Pasted image 20240112121738.png]]
	vi /etc/sysconfig/network-scripts/ifcfg-enp0s3 编辑
	![[Pasted image 20240112121852.png]]
	配置网络
		改dhcp为static
		按图增添
	![[Pasted image 20240112121947.png]]
	按Esc退出编辑，然后输入：wq保存
	systemctl restart network 重启网卡
	![[Pasted image 20240112122433.png]]
	ping www.baidu.com 看是否能ping通
	![[Pasted image 20240112122145.png]]
6、Xshell连接
	Xshell下载地址：
	https://www.netsarang.com/en/free-for-home-school/
	如图配置CentOS
	![[Pasted image 20240112122816.png]]
	端口转发 新建
	![[Pasted image 20240112122906.png]]
	进入Xshell如图新建
	![[Pasted image 20240112123107.png]]
	然后即可连上