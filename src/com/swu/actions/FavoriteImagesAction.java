package com.swu.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.swu.dto.User;
import com.swu.service.FavoriteImagesService;
import com.swu.util.DownLoadImages;
import com.swu.util.PrintUtil;

public class FavoriteImagesAction  extends ActionSupport{

	private static final long serialVersionUID = 8070634172875427262L;
	public String favoriteImagesAction(){
		//获取request和response对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置编码格式
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//定义返回值
		Object data = null;
		Object size = null;
		//定义标识
		String fn = request.getParameter("fn");
		//从session中获取user
		User user =  (User) request.getSession().getAttribute("user");
		//获取用户编号
		String userUnid = user.getUser_unid();
		
		
		//获取收藏夹的URL列表
		if("queryImagesList".equals(fn)){
			String condition = request.getParameter("condition");
			String currPage = request.getParameter("currPage");
			//获取分页的size
			size = FavoriteImagesService.queryCount(condition,userUnid);
			data = FavoriteImagesService.queryImages(condition,currPage,userUnid);
		}
		//删除功能
		else if("deleteList".equals(fn)){
			String unid = request.getParameter("images_unid");
			data = FavoriteImagesService.deleteList(unid,userUnid);
		}
		//修改功能
		else if("updateRemark".equals(fn)){
			String unid = request.getParameter("images_unid");
			String remark = request.getParameter("images_remark");
			data =  FavoriteImagesService.updateRemark(unid,remark,userUnid);
		}
		//下载功能
		else if("downloadList".equals(fn)){
			String images = request.getParameter("images_url");
			String path = DownLoadImages.downloadImages(images);
			data=("文件成功下载至" + path).substring(0, 16);
		}
		
		 //返回值
		JSONObject result = new JSONObject();
		result.put("data", data);
		result.put("size", size);
		PrintUtil.print(response, result);
		
        return null;
	}
}