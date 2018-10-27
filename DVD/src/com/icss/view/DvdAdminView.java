package com.icss.view;

import java.util.Scanner;

import com.icss.db.UserArray;
import com.icss.model.Dvd;
import com.icss.model.Users;

public class DvdAdminView {
	int n = 3;
	//开始
	public void init(){
		System.out.println("欢迎登陆DVD,请登陆:");
		Scanner input = new Scanner(System.in);
		System.out.println("请选择 : 1-注册,2-登陆");
		String mun = input.next();
		switch (mun) {
		case "1":
			regist(input);
			break;
		case "2":
			login(input);
			break;
		default:
			init();
			break;
		}
	}

	//注册
	public void regist(Scanner input){
		int type = 1;
		System.out.println("请输入您要注册的用户名:");
		String name = input.next();
		System.out.println("请输入您要注册的密码:");
		String pwd = input.next();
		for (int i = 0; i < UserArray.users.size(); i++) {
			if(name.equals(UserArray.users.get(i).getUser())){
				System.out.println("用户名已经被注册,请重新输入:");
				type = 2;
			}
		}
		System.out.println(type);
		switch (type) {
		case 1:
			UserArray.users.add(new Users(name,pwd));
			System.out.println("==================");
			login(input);
			break;
		case 2:
			regist(input);
			break;

		default:
			break; 
		}
	}

	//登录
	public void login(Scanner input){
		System.out.println("---------------");
		System.out.println("请输入您要登陆的用户名:");
		String name = input.next();
		System.out.println("请输入您要登陆的密码:");
		String pwd = input.next();
		for (int j = 0; j < UserArray.users.size(); j++) {
			if(UserArray.users.get(j).getUser().equals(name) && UserArray.users.get(j).getPwd().equals(pwd)){
				System.out.println(name +","+ pwd);
				System.out.println(UserArray.users.get(j).getUser() + ","+ UserArray.users.get(j).getPwd() + "---");
				option(input);
				break;
			}

		}
		init();
	}

	//选项
	public void option(Scanner input){
		System.out.println("请选择您需要使用的功能: 创建(1),删除(2),修改(3),查询(4),退出(5) :");
		String num = input.next();
		switch(num){
		case "1":
			create(input);
			break;
		case "2":
			dalete(input);
			break;
		case "3":
			update(input);
			break;
		case "4":
			select(input);
			break;
		case "5":
			System.exit(0);
			break;
		default:
			System.out.println("选择错误,请重新选择:");
			login(input);
			break;
		}

	}


	//创建
	public void create(Scanner input){
		Dvd dvda;
		System.out.println("请创建一个DVD名字:");
		String dvd = input.next();
		for (int i = 0; i < UserArray.dvds.size(); i++) {
			if (!dvd.equals(UserArray.dvds.get(i).getDvdName())) {
				dvda = new Dvd(n,dvd,"可借",0);
				UserArray.dvds.add(dvda);
				System.out.println(dvda);
				n ++;
				break;
			}else{
				System.out.println("查询错误,返回:创建(1),选项(其他键)");
				String nums = input.next();
				switch(nums){
				case "1":
					create(input);
					break;
				default:
					System.out.println("返回选项");
					option(input);
					break;
				}
			}
		}
		System.out.println("添加完成,返回选项");
		option(input);
	}

	//删除
	public void dalete(Scanner input){
		System.out.println("请输入您要删除的DVD:");
		String name = input.next();
		for (int i = 0; i < UserArray.dvds.size(); i++) {
			System.out.println(UserArray.dvds.get(i).toString());
			if (UserArray.dvds.get(i).getDvdName().equals(name)) {
				UserArray.dvds.remove(i);
				System.out.println("删除成功，返回选项");
				option(input);
				break;
			}
		}

		System.out.println("删除失败,返回:删除(1),选项(其他键)");
		String num = input.next();
		switch(num){
		case "1":
			dalete(input);
			break;
		default:
			System.out.println("返回选项");
			break;
		}
	}

	//修改
	public void update(Scanner input){
		String[] dvdss;
		System.out.println("请输入您要修改的DVD:");
		String name = input.next();
		for (int i = 0; i < UserArray.dvds.size(); i++) {
			if (name.equals(UserArray.dvds.get(i).getDvdName())) {
				System.out.println("请输入您要修改的DVD(以,隔开):");
				String dvd = input.next();
				dvdss = dvd.split(",");
				UserArray.dvds.get(i).setDvdId(Integer.parseInt(dvdss[0]));
				UserArray.dvds.get(i).setDvdName(dvdss[1]);
				UserArray.dvds.get(i).setLendCount(Integer.parseInt(dvdss[2]));
				UserArray.dvds.get(i).setStatus(dvdss[3]);
				System.out.println("修该完成,返回选项");
				option(input);
				break;
			}
		}
		System.out.println("修改错误,返回:修改(1),选项(其他键)");
		String num = input.next();
		switch(num){
		case "1":
			update(input);
			break;
		default:
			System.out.println("返回选项");
			option(input);
			break;
		}
	}

	//查询
	public void select(Scanner input){
		System.out.println("请选择查询:查询全部(1),查询单个(2)");
		String num = input.next();
		switch(num){
		case "1":
			select1(input);
			break;
		case "2":
			select2(input);
			break;
		default:
			System.out.println("选择错误,请重新选择");
			select(input);
			break;
		}

	}

	public void select1(Scanner input){
		for (int i = 0; i < UserArray.dvds.size(); i++) {
			System.out.println(UserArray.dvds.get(i).getDvdId()+","+
					UserArray.dvds.get(i).getDvdName()+","+
					UserArray.dvds.get(i).getStatus()+","+
					UserArray.dvds.get(i).getLendCount());
		}
		option(input);
	}

	public void select2(Scanner input){
		System.out.println("请输入您要查询的Dvd名称:");
		String name = input.next();
		for (int i = 0; i < UserArray.dvds.size(); i++) {
			if(name.equals(UserArray.dvds.get(i).getDvdName())){
				System.out.println(UserArray.dvds.get(i).getDvdId()+","+
						UserArray.dvds.get(i).getDvdName()+","+
						UserArray.dvds.get(i).getStatus()+","+
						UserArray.dvds.get(i).getLendCount());
				break;
			}else{
				System.out.println("查询错误,返回:查询单个(1),选项(其他键)");
				String num = input.next();
				switch(num){
				case "1":
					select2(input);
					break;
				default:
					System.out.println("返回选项");
					option(input);
					break;
				}
			}
		}
		option(input);

	}











}
