package ShuZu;

import java.util.Scanner;

public class ChiHuoLianMeng3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner a = new Scanner(System.in);
		
		//菜单信息
		String[] caiMing = {"红烧带鱼 ","鱼香肉丝 ","时令蔬菜 "};
		double[] danJia = {38.0,20.0,10.0};
		int[] dianZan = new int[3];
		
		//订单信息
		String[] name = new String[4];
		String[] caiPin = new String[4];
		int[] shiJian = new int[4];
		String[] diZhi = new String[4];
		double[] zongJinE = new double[4];
		int[] zhuangTai = new int[4]; //0已预订 1已完成
		
		name[0]="张三";
		caiPin[0]="红烧带鱼"+" "+2+"份";
		shiJian[0]=12;
		diZhi[0]="知春路112号";
		zongJinE[0]=76;
		zhuangTai[0]=0;
		
		name[1]="啦啦啦";
		caiPin[1]="时令蔬菜"+" "+3+"份";
		shiJian[1]=13;
		diZhi[1]="知春路119号";
		zongJinE[1]=36;
		zhuangTai[1]=1;
		
		int xunHuan=-1;
		boolean fanHui=false;
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		do {
			System.out.println("**********************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("**********************************");
			System.out.print("请选择:");
			int xuan = a.nextInt();
			
			boolean kong = false;
			switch(xuan) {
				case 1:
					System.out.println("*****************我要订餐*****************");
					for(int i=0;i<name.length;i++) {
						if(name[i]==null) {
							kong = true;
							System.out.print("请输入点菜人姓名:");
							String name1 = a.next();
							
							System.out.println("序号\t菜名\t单价");
							for(int j=0;j<caiMing.length;j++) {
								String dianZan2 = (dianZan[j]==0)?" ":dianZan[j]+"赞";
								System.out.println((j+1)+"\t"+caiMing[j]+danJia[j]+"\t"+dianZan2);
							}
							
							System.out.print("请输入您要点的菜品编号:");
							int bianHao = a.nextInt();
							while(bianHao>caiMing.length) {
								System.out.print("本店没有此菜!请重新输入:");
								bianHao = a.nextInt();
							}
							
							System.out.print("请选择您要的份数:");
							int fenShu = a.nextInt();
							
							System.out.print("请输入送餐时间(送餐时间在10-20整点之间):");
							int songCanShiJian2 = a.nextInt();
							while(songCanShiJian2<10||songCanShiJian2>20) {
								System.out.print("不在送餐时间内!请重新输入:");
								songCanShiJian2 = a.nextInt();
							}
							
							System.out.print("请输入送餐地址:");
							String songCanDiZhi = a.next();
							
							System.out.println("订餐成功");
							
							//订餐信息
							String dingCanXinXi = caiMing[bianHao-1]+fenShu+" "+"份";
							System.out.println("您定的是:"+dingCanXinXi);
							System.out.println("送餐时间是:"+songCanShiJian2+"时");
							
							double canFei = danJia[bianHao-1]*fenShu;
							double peiSongFei  = (canFei>=50)?0:6;
							double zongJi = canFei+peiSongFei;
							System.out.println("餐费:"+canFei+",送餐费:"+peiSongFei+",总计:"+zongJi);
							
							name[i] = name1;
							caiPin[i]=dingCanXinXi;
							shiJian[i]=songCanShiJian2;
							diZhi[i]=songCanDiZhi;
							zongJinE[i]=zongJi;							
							break;
						}
					}
					
					
					if(!kong) {
						System.out.println("订单已满!不能订餐");
					}
					break;
				case 2:
					System.out.println("*****************查看餐袋*****************");
					System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t\t总金额\t订单状态");
					for(int i=0;i<name.length;i++) {
						if(name[i] != null) {
				
							String songCanshiJian = shiJian[i]+"时";
							String zhuangTai2 = (zhuangTai[i]==0)?"已预订":"已完成";
							System.out.println((i+1)+"\t"+name[i]+"\t"+caiPin[i]+"\t"+songCanshiJian+"\t"+diZhi[i]+"\t"+zongJinE[i]+"\t"+zhuangTai2);
						}
					}
					break;
				case 3:
					System.out.println("*****************签收订单*****************");
					boolean cun=false;
					System.out.print("请输入要签收的订单:");
					int qian = a.nextInt();
					for(int i=0;i<name.length;i++) {
						if(name[i]!=null && zhuangTai[i]==0 && i==qian-1) {
							cun = true;
							zhuangTai[i]=1;
							System.out.println("签收成功");
						}else if(name[i]!=null && zhuangTai[i]==1 && i==qian-1) {
							cun = true;
							System.out.print("订单已完成，不能签收");
						}
					}
					if(!cun) {
						System.out.println("订单不存在");
					}
					break;
				case 4:
					System.out.println("*****************删除订单*****************");
					boolean cun1=false;
					System.out.print("请输入要删除的订单:");
					int shan = a.nextInt();
					for(int i=0;i<name.length;i++) {
						if(name[i]!=null && zhuangTai[i]==0 && i==shan-1) {
							cun1 = true;
							System.out.println("订单未完成，不能删除");
						}else if(name[i]!=null && zhuangTai[i]==1 && i==shan-1) {
							cun1 = true;
							for(int j=i;j<name.length-1;j++) {
								name[j]=name[j+1];
								caiPin[j]=caiPin[j+1];
								shiJian[j]=shiJian[j+1];
								diZhi[j]=diZhi[j+1];
								zongJinE[j]=zongJinE[j+1];
								zhuangTai[j]=zhuangTai[j+1];

							}
							name[name.length-1]=null;
							caiPin[name.length-1]=null;
							shiJian[name.length-1]=0;
							diZhi[name.length-1]=null;
							zongJinE[name.length-1]=0;
							zhuangTai[name.length-1]=0;
							
							System.out.println("删除完成");

							
						}

					}
					if(!cun1) {
						System.out.println("订单不存在");
					}
					break;
				case 5:
					System.out.println("*****************我要点赞*****************");
						System.out.println("序号\t菜名\t单价");
						for(int j=0;j<caiMing.length;j++) {
							String dianZan2 = (dianZan[j]==0)?" ":dianZan[j]+"赞";
							System.out.println((j+1)+"\t"+caiMing[j]+danJia[j]+"\t"+dianZan2);
						}
						System.out.print("请输入要点赞的菜品编号:");
						int dian = a.nextInt();
						while(dian<1||dian>caiMing.length) {
							System.out.print("本店没有!请重新输入:");
							dian = a.nextInt();
						}
						dianZan[dian-1]++;
					
					break;
				default:
					fanHui = true;
					break;
			}
			if(!fanHui) {
				System.out.print("输入0返回:");
				xunHuan = a.nextInt();
			}else {
				break;
			}
		}while(xunHuan==0);
		System.out.println("欢迎使用");
	}

}
