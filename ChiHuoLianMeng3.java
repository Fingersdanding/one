package ShuZu;

import java.util.Scanner;

public class ChiHuoLianMeng3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner a = new Scanner(System.in);
		
		//�˵���Ϣ
		String[] caiMing = {"���մ��� ","������˿ ","ʱ���߲� "};
		double[] danJia = {38.0,20.0,10.0};
		int[] dianZan = new int[3];
		
		//������Ϣ
		String[] name = new String[4];
		String[] caiPin = new String[4];
		int[] shiJian = new int[4];
		String[] diZhi = new String[4];
		double[] zongJinE = new double[4];
		int[] zhuangTai = new int[4]; //0��Ԥ�� 1�����
		
		name[0]="����";
		caiPin[0]="���մ���"+" "+2+"��";
		shiJian[0]=12;
		diZhi[0]="֪��·112��";
		zongJinE[0]=76;
		zhuangTai[0]=0;
		
		name[1]="������";
		caiPin[1]="ʱ���߲�"+" "+3+"��";
		shiJian[1]=13;
		diZhi[1]="֪��·119��";
		zongJinE[1]=36;
		zhuangTai[1]=1;
		
		int xunHuan=-1;
		boolean fanHui=false;
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		do {
			System.out.println("**********************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("**********************************");
			System.out.print("��ѡ��:");
			int xuan = a.nextInt();
			
			boolean kong = false;
			switch(xuan) {
				case 1:
					System.out.println("*****************��Ҫ����*****************");
					for(int i=0;i<name.length;i++) {
						if(name[i]==null) {
							kong = true;
							System.out.print("��������������:");
							String name1 = a.next();
							
							System.out.println("���\t����\t����");
							for(int j=0;j<caiMing.length;j++) {
								String dianZan2 = (dianZan[j]==0)?" ":dianZan[j]+"��";
								System.out.println((j+1)+"\t"+caiMing[j]+danJia[j]+"\t"+dianZan2);
							}
							
							System.out.print("��������Ҫ��Ĳ�Ʒ���:");
							int bianHao = a.nextInt();
							while(bianHao>caiMing.length) {
								System.out.print("����û�д˲�!����������:");
								bianHao = a.nextInt();
							}
							
							System.out.print("��ѡ����Ҫ�ķ���:");
							int fenShu = a.nextInt();
							
							System.out.print("�������Ͳ�ʱ��(�Ͳ�ʱ����10-20����֮��):");
							int songCanShiJian2 = a.nextInt();
							while(songCanShiJian2<10||songCanShiJian2>20) {
								System.out.print("�����Ͳ�ʱ����!����������:");
								songCanShiJian2 = a.nextInt();
							}
							
							System.out.print("�������Ͳ͵�ַ:");
							String songCanDiZhi = a.next();
							
							System.out.println("���ͳɹ�");
							
							//������Ϣ
							String dingCanXinXi = caiMing[bianHao-1]+fenShu+" "+"��";
							System.out.println("��������:"+dingCanXinXi);
							System.out.println("�Ͳ�ʱ����:"+songCanShiJian2+"ʱ");
							
							double canFei = danJia[bianHao-1]*fenShu;
							double peiSongFei  = (canFei>=50)?0:6;
							double zongJi = canFei+peiSongFei;
							System.out.println("�ͷ�:"+canFei+",�Ͳͷ�:"+peiSongFei+",�ܼ�:"+zongJi);
							
							name[i] = name1;
							caiPin[i]=dingCanXinXi;
							shiJian[i]=songCanShiJian2;
							diZhi[i]=songCanDiZhi;
							zongJinE[i]=zongJi;							
							break;
						}
					}
					
					
					if(!kong) {
						System.out.println("��������!���ܶ���");
					}
					break;
				case 2:
					System.out.println("*****************�鿴�ʹ�*****************");
					System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t����״̬");
					for(int i=0;i<name.length;i++) {
						if(name[i] != null) {
				
							String songCanshiJian = shiJian[i]+"ʱ";
							String zhuangTai2 = (zhuangTai[i]==0)?"��Ԥ��":"�����";
							System.out.println((i+1)+"\t"+name[i]+"\t"+caiPin[i]+"\t"+songCanshiJian+"\t"+diZhi[i]+"\t"+zongJinE[i]+"\t"+zhuangTai2);
						}
					}
					break;
				case 3:
					System.out.println("*****************ǩ�ն���*****************");
					boolean cun=false;
					System.out.print("������Ҫǩ�յĶ���:");
					int qian = a.nextInt();
					for(int i=0;i<name.length;i++) {
						if(name[i]!=null && zhuangTai[i]==0 && i==qian-1) {
							cun = true;
							zhuangTai[i]=1;
							System.out.println("ǩ�ճɹ�");
						}else if(name[i]!=null && zhuangTai[i]==1 && i==qian-1) {
							cun = true;
							System.out.print("��������ɣ�����ǩ��");
						}
					}
					if(!cun) {
						System.out.println("����������");
					}
					break;
				case 4:
					System.out.println("*****************ɾ������*****************");
					boolean cun1=false;
					System.out.print("������Ҫɾ���Ķ���:");
					int shan = a.nextInt();
					for(int i=0;i<name.length;i++) {
						if(name[i]!=null && zhuangTai[i]==0 && i==shan-1) {
							cun1 = true;
							System.out.println("����δ��ɣ�����ɾ��");
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
							
							System.out.println("ɾ�����");

							
						}

					}
					if(!cun1) {
						System.out.println("����������");
					}
					break;
				case 5:
					System.out.println("*****************��Ҫ����*****************");
						System.out.println("���\t����\t����");
						for(int j=0;j<caiMing.length;j++) {
							String dianZan2 = (dianZan[j]==0)?" ":dianZan[j]+"��";
							System.out.println((j+1)+"\t"+caiMing[j]+danJia[j]+"\t"+dianZan2);
						}
						System.out.print("������Ҫ���޵Ĳ�Ʒ���:");
						int dian = a.nextInt();
						while(dian<1||dian>caiMing.length) {
							System.out.print("����û��!����������:");
							dian = a.nextInt();
						}
						dianZan[dian-1]++;
					
					break;
				default:
					fanHui = true;
					break;
			}
			if(!fanHui) {
				System.out.print("����0����:");
				xunHuan = a.nextInt();
			}else {
				break;
			}
		}while(xunHuan==0);
		System.out.println("��ӭʹ��");
	}

}
