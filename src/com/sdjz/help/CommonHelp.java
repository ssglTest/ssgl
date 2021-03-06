package com.sdjz.help;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.Actor;
import com.sdjz.domain.User;
import com.sdjz.exception.UserInvalidException;
import com.sdjz.other.Common;

public class CommonHelp {

	@SuppressWarnings("unused")
	private static String original_encoding = "utf-8";

	/**
	 * 验证字符串是否合法
	 * 
	 * @param value
	 * @return 是否合法
	 */
	public static boolean isValidString(String value) {
		return value != null && value.length() > 0;
	}

	/**
	 * @param password
	 *            明文
	 * @return md5密文
	 */
	public static String makeMD5(String password) {
		MessageDigest md;
		try {
			// 生成一个MD5加密计算摘要
			md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(password.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public static Calendar getNow() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		return ca;
	}

	// 得到当前年份
	public static Integer getYear() {
		Calendar calendar = getNow();
		Integer year = Integer.valueOf(calendar.get(Calendar.YEAR));
		return year;
	}

	/*
	 * 得到当前月份
	 */
	public static Integer getMonth() {
		Calendar calendar = getNow();
		Integer month = Integer.valueOf(calendar.get(Calendar.MONTH));
		return month;
	}
	
	// 返回一个含有message的JSON数据,其message为status
		static public void buildSimpleJson(HttpServletResponse response,
				String message) {
			String result = "{\"status\":\"" + message + "\"}";
			PrintWriter out = null;
			response.setContentType("application/json");
			try {
				out = response.getWriter();
				out.write(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 返回一个含有status：""的JSON数据
		static public void buildSimpleJson(HttpServletResponse response) {
			CommonHelp.buildSimpleJson(response, "");
		}

	/*
	 * 得到日期
	 */
	public static Integer getDay() {
		Calendar calendar = getNow();
		Integer day = Integer.valueOf(calendar.get(Calendar.DATE));
		return day;
	}

	public static String getCurrentDate() {
		Integer day = getDay();
		Integer month = getMonth() + 1;
		Integer year = getYear();
		String currentDate = day + "/" + month + "/" + year;
		return currentDate;
	}

	/**
	 * 得到当前的用户
	 * 
	 * @param session
	 * @return
	 */
	public static User getCurrentUser(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if (user == null)
			throw new UserInvalidException("请重新登录");
		return user;
	}

	/**
	 * 得到当前用户对应的actor
	 * 
	 * @param session
	 * @return
	 */
	public static Actor getCurrentActor(HttpSession session) {
		User user = getCurrentUser(session);
		return user.getActor();
	}

	/*
	 * 获取上传的路径
	 */
	public static String getUploadPath(HttpSession httpSession) {
		String rootPath = httpSession.getServletContext().getRealPath("/");
		String uploadPath = rootPath.substring(0, rootPath.lastIndexOf("\\")) + Common.UPLOAD_DIR;
		return uploadPath;
	}

	/*
	 * 验证手机号是否合法，以1开关，共10位
	 */
	public static boolean isMobileNo(String mobile) {
		Pattern pattern = Pattern.compile("^[1]\\d{10}$");
		Matcher m = pattern.matcher(mobile);
		return m.matches();
	}

	/*
	 * 验证邮箱是否合法
	 */
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher m = pattern.matcher(email);
		return m.matches();
	}

	/*
	 * 验证qq是否合法，大于5位
	 */
	public static boolean isQQ(String qq) {
		Pattern p = Pattern.compile("^\\d{5,}$");
		Matcher m = p.matcher(qq);
		return m.matches();
	}

	/**
	 * 得到文件的名字
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileName(MultipartFile file) {
		return file.getName();
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 *            JSP中type="file"的名字
	 * @param httpSession
	 * @param folderName
	 *            文件夹的名字
	 * @param fileName
	 *            文件的名字
	 * @return url
	 */
	public static String upload(MultipartFile file, HttpSession httpSession, String folderName, String fileName) {
		// 文件夹名称：应用程序的根路径+上传目录
		String folder = CommonHelp.getUploadPath(httpSession);
		// 文件的扩展名
		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),
				file.getOriginalFilename().length());
		String name = folderName + "/" + fileName + extension;
		// 上传文件
		if (!file.isEmpty()) {
			try {
				File tempFile = new File(folder + name);
				// 如果不存在该文件夹，则创建
				if (!tempFile.exists())
					tempFile.mkdirs();
				file.transferTo(tempFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	public static String upload(MultipartFile file, HttpSession httpSession, String folderName, Integer id) {
		return upload(file, httpSession, folderName, id.toString());
	}

	/**
	 * 用最原始的文件名保存文件
	 * 
	 * @param file
	 * @param httpSession
	 * @param folderName
	 * @return
	 */
	public static String upload(MultipartFile file, HttpSession httpSession, String folderName) {
		// 文件夹名称：应用程序的根路径+上传目录
		String folder = CommonHelp.getUploadPath(httpSession);
		// 文件的扩展名
		String name = folderName + "/" + file.getOriginalFilename();
		// 上传文件
		if (!file.isEmpty()) {
			try {
				File tempFile = new File(folder + name);
				// 如果不存在该文件夹，则创建
				if (!tempFile.exists())
					tempFile.mkdirs();
				file.transferTo(tempFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	/**
	 * 下载文件
	 * 
	 * @param httpSession
	 * @param url
	 * @param name
	 *            下载文件显示的名称
	 * @param subDir
	 *            子目录
	 * @return
	 * @throws IOException
	 */
	public static ResponseEntity<byte[]> download(HttpSession httpSession, String url, String name, String subDir)
			throws IOException {
		String folder = CommonHelp.getUploadPath(httpSession);
		File file = new File(folder + url);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		String nameFile = name + "." + url.split("\\\\")[0];
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment",
				URLEncoder.encode(nameFile, "utf-8").replaceAll("\\+", "%20"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	public static ResponseEntity<byte[]> download(HttpSession httpSession, String url, String name) throws IOException {
		return download(httpSession, url, name, "");
	}

	/**
	 * 删除文件
	 * 
	 * @param httpSession
	 * @param url
	 */
	public static void delete(HttpSession httpSession, String url) {
		String uploadPath = CommonHelp.getUploadPath(httpSession);
		String path = uploadPath + url;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 
	 * @param str
	 *            改变的字符
	 * @return 首字母小写
	 */
	public static String initialToLowerCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
	}

	/**
	 * 用于比较两个路径是否相等
	 * 
	 * @param url
	 *            用户请求的路径
	 * @param resUrl
	 *            数据库中的路径
	 * @return
	 */
	public static boolean PathMatchesUrl(String url, String resUrl) {
		if (url.equals(resUrl)) {
			return true;
		}
		return false;
	}

}
