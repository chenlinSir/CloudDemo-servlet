package com.cloud.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cloud.dao.QueryTheWarehouseDao;
import com.cloud.dao.WarehouseDao;
import com.cloud.entity.QuerytheWarehouseEntity;
/*
 * 这是一个添加配件信息的类 包括配件图片
 * */
public class AddPartInfoAndFile extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if(op==null){
			//指定上传文件的存放路径
			String pathimg ="BackgrounPage/page/warehouse/img"; //图片保存地址
			String path = this.getServletContext().getRealPath("/")+pathimg;
			File fl = new File(path);
			//创建磁盘文件组对象
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setRepository(fl);//设置文件上传时的缓存目录
			factory.setSizeThreshold(1024*1024*1024*10);//设置文件上传时缓存的大小，单位字节 最大10MB
			//创建文件上传对象
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setSizeMax(1024*1024*1024*10);//文件最大大小 10MB
			upload.setHeaderEncoding("UTF-8");//编码格式
			String fileName;
			WarehouseDao dao = new WarehouseDao();
			QueryTheWarehouseDao dao1 = new QueryTheWarehouseDao();
			QuerytheWarehouseEntity QWE = new QuerytheWarehouseEntity();
			int ID=dao.QuerytheWarehouseMaxId();
			//配件信息
			QWE.setQ_id(ID);//设置ID
			QWE.setQ_number(0);//添加数量默认为0
			QWE.setQ_noFollow(1);//默认为显示
			
		//	String calName = request.getParameter("calName");
			try {
				List<FileItem> list = upload.parseRequest(request);
				if(list!=null && list.size()>0){
					for(FileItem fi : list){
						//判断是否是文件
						if(!fi.isFormField() && fi.getSize()>0){//isFormField()取反表示是一个文件域对象并且有数据
							//是文件则实现上传操作
							fileName=fi.getName();
							File f=new File(path+"/"+fi.getName());
							//System.out.println("图片IMG:"+fileName);
							QWE.setQ_partsImg(fi.getName()); //设置配件图片的名称
							fi.write(f);
							
						}else{//普通数据
							//如何获取指定表单值
							String name =fi.getFieldName();
							System.out.println(name);
							if("q_vehicleBrand".equals(name)){ 
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_vehicleBrand(value);
			
							}else if("q_partsName".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_partsName(value);
							}else if("q_partBrand".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_partBrand(value);
							}else if("q_unit".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_unit(value);
							}else if("q_partType".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_partType(value);
							}else if("q_partEffect".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_partEffect(value);
							}else if("q_buyingRate".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_buyingRate(Double.parseDouble(value));
							}else if("q_sellingPrice".equals(name)){
								String value = fi.getString("utf-8");
								System.out.println(value);
								QWE.setQ_sellingPrice(Double.parseDouble(value));
							}
							
						}
					}
				}
				boolean bool= dao1.InsertQuerytheWarehouse(QWE);
				if(bool){
					System.out.println("添加成功");
				}else{
					System.out.println("添加失败");
				}
				System.out.println("ID"+QWE.getQ_id());
				System.out.println("适合"+QWE.getQ_vehicleBrand());
				System.out.println("图片"+QWE.getQ_partsImg());
				System.out.println("名称"+QWE.getQ_partsName());
				System.out.println("品牌"+QWE.getQ_partBrand());
				System.out.println("数量"+QWE.getQ_number());
				System.out.println("单位"+QWE.getQ_unit());
				System.out.println("型号"+QWE.getQ_partType());
				System.out.println("作用"+QWE.getQ_partEffect());
				System.out.println("进价"+QWE.getQ_buyingRate());
				System.out.println("售价"+QWE.getQ_sellingPrice());
				System.out.println("显示"+QWE.getQ_noFollow());
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
