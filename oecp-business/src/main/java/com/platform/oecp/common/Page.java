package com.platform.oecp.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @className: Page
 * @author: LILIANG
 * @date: Create In 2020/3/16 10:15
 * @description:
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
	protected int pageNo = 1;
	/**
	 * 页面大小，设置为“-1”表示不进行分页（分页无效）
	 */
	protected int pageSize = 10;
	/**
	 * 总记录数，设置为“-1”表示不查询总数
	 */
	protected long count;
	/**
	 * 首页索引
	 */
	protected int first;
	/**
	 * 尾页索引
	 */
	protected int last;
	/**
	 * 上一页索引
	 */
	protected int prev;
	/**
	 * 下一页索引
	 */
	protected int next;
	/**
	 * 是否是第一页
	 */
	private boolean firstPage;
	/**
	 * 是否是最后一页
	 */
	private boolean lastPage;
	/**
	 * 显示页面长度
	 */
	protected int length = 8;
	/**
	 * 前后显示页面长度
	 */
	protected int slider = 1;
	
	private List<T> list = new ArrayList<T>();
	/**
	 * 标准查询有效， 实例： update_date desc, name asc
	 */
	private String orderBy = "";
	/**
	 * 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
	 */
	protected String funcName = "page";
	/**
	 * 函数的附加参数，第三个参数值。
	 */
	protected String funcParam = "";
	/**
	 * 设置提示消息，显示在“共n条”之后
	 */
	private String message = "";

	public Page() {
		this.pageSize = -1;
	}
	
	/**
	 * 构造方法
	 * @param pageNo 当前页码
	 * @param pageSize 分页大小
	 */
	public Page(int pageNo, int pageSize) {
		this(pageNo, pageSize, 0);
	}
	
	/**
	 * 构造方法
	 * @param pageNo 当前页码
	 * @param pageSize 分页大小
	 * @param count 数据条数
	 */
	public Page(int pageNo, int pageSize, long count) {
		this(pageNo, pageSize, count, new ArrayList<T>());
	}
	
	/**
	 * 构造方法
	 * @param pageNo 当前页码
	 * @param pageSize 分页大小
	 * @param count 数据条数
	 * @param list 本页数据对象列表
	 */
	public Page(int pageNo, int pageSize, long count, List<T> list) {
		this.setCount(count);
		this.setPageNo(pageNo);
		this.pageSize = pageSize;
		this.list = list;
	}

	/**
	 * 初始化参数
	 */
	public void initialize(){

		//1
		this.first = 1;

		this.last = (int)(count / (this.pageSize < 1 ? 20 : this.pageSize) + first - 1);

		if (this.count % this.pageSize != 0 || this.last == 0) {
			this.last++;
		}

		if (this.last < this.first) {
			this.last = this.first;
		}

		if (this.pageNo <= 1) {
			this.pageNo = this.first;
			this.firstPage=true;
		}

		if (this.pageNo >= this.last) {
			this.pageNo = this.last;
			this.lastPage=true;
		}

		if (this.pageNo < this.last - 1) {
			this.next = this.pageNo + 1;
		} else {
			this.next = this.last;
		}

		if (this.pageNo > 1) {
			this.prev = this.pageNo - 1;
		} else {
			this.prev = this.first;
		}

		//2 如果当前页小于首页
		if (this.pageNo < this.first) {
			this.pageNo = this.first;
		}
		// 如果当前页大于尾页
		if (this.pageNo > this.last) {
			this.pageNo = this.last;
		}

	}

	/**
	 * 默认输出当前分页标签
	 * <div class="page">${page}</div>
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		long startIndex = (pageNo-1)*pageSize + 1;
		long endIndex = pageNo*pageSize <=count? pageNo*pageSize:count;

		sb.append("<div class=\"pull-left pagination-detail\">");
		sb.append("<span class=\"pagination-info\">显示第 "+startIndex+" 到第 "+ endIndex +" 条记录，总共 "+count+" 条记录</span>");
		sb.append("<span class=\"page-list\">每页显示 <span class=\"btn-group dropup\">");
		sb.append("<button type=\"button\" class=\"btn btn-default  btn-outline dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">");
		sb.append("<span class=\"page-size\">"+pageSize+"</span> <span class=\"caret\"></span>");
		sb.append("</button>");
		sb.append("<ul class=\"dropdown-menu\" role=\"menu\">");
		sb.append("<li class=\""+getSelected(pageSize,10)+ "\"><a href=\"javascript:"+funcName+"("+pageNo+",10,'"+funcParam+"');\">10</a></li>");
		sb.append("<li class=\""+getSelected(pageSize,25)+ "\"><a href=\"javascript:"+funcName+"("+pageNo+",25,'"+funcParam+"');\">25</a></li>");
		sb.append("<li class=\""+getSelected(pageSize,50)+ "\"><a href=\"javascript:"+funcName+"("+pageNo+",50,'"+funcParam+"');\">50</a></li>");
		sb.append("<li class=\""+getSelected(pageSize,100)+ "\"><a href=\"javascript:"+funcName+"("+pageNo+",100,'"+funcParam+"');\">100</a></li>");
		sb.append("</ul>");
		sb.append("</span> 条记录</span>");
		sb.append("</div>");
		sb.append("<div class=\"pull-right pagination-roll\">");
		sb.append("<ul class=\"pagination pagination-outline\">");
		// 如果是首页
		if (pageNo == first) {
			sb.append("<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-left\"></i></a></li>\n");
			sb.append("<li class=\"paginate_button previous disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-left\"></i></a></li>\n");
		} else {
			sb.append("<li class=\"paginate_button previous\"><a href=\"javascript:\" onclick=\""+funcName+"("+first+","+pageSize+",'"+funcParam+"');\"><i class=\"fa fa-angle-double-left\"></i></a></li>\n");
			sb.append("<li class=\"paginate_button previous\"><a href=\"javascript:\" onclick=\""+funcName+"("+prev+","+pageSize+",'"+funcParam+"');\"><i class=\"fa fa-angle-left\"></i></a></li>\n");
		}

		int begin = pageNo - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slider && i < begin; i++) {
				sb.append("<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"paginate_button disabled\"><a href=\"javascript:\">...</a></li>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNo) {
				sb.append("<li class=\"paginate_button selected\"><a href=\"javascript:\">" + (i + 1 - first)
						+ "</a></li>\n");
			} else {
				sb.append("<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
		}

		if (last - end > slider) {
			sb.append("<li class=\"paginate_button disabled\"><a href=\"javascript:\">...</a></li>\n");
			end = last - slider;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<li class=\"paginate_button \"><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+",'"+funcParam+"');\">"
					+ (i + 1 - first) + "</a></li>\n");
		}

		if (pageNo == last) {
			sb.append("<li class=\"paginate_button next disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-right\"></i></a></li>\n");
			sb.append("<li class=\"paginate_button next disabled\"><a href=\"javascript:\"><i class=\"fa fa-angle-double-right\"></i></a></li>\n");
		} else {
			sb.append("<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\""+funcName+"("+next+","+pageSize+",'"+funcParam+"');\">"
					+ "<i class=\"fa fa-angle-right\"></i></a></li>\n");
			sb.append("<li class=\"paginate_button next\"><a href=\"javascript:\" onclick=\""+funcName+"("+last+","+pageSize+",'"+funcParam+"');\">"
					+ "<i class=\"fa fa-angle-double-right\"></i></a></li>\n");
		}


        sb.append("</ul>");
        sb.append("</div>");
        sb.append("</div>");
		return sb.toString();
	}

	protected String getSelected(int pageNo, int selectedPageNo){
		if(pageNo == selectedPageNo){
			//return "selected";
			return "selected";
		}else{
			return "";
		}

	}
	/**
	 * 获取分页HTML代码
	 * @return
	 */
	public String getHtml(){
		return toString();
	}

	/**
	 * 获取设置总数
	 * @return
	 */
	public long getCount() {
		return count;
	}

	/**
	 * 设置数据总数
	 * @param count
	 */
	public void setCount(long count) {
		this.count = count;
		if (pageSize >= count){
			pageNo = 1;
		}
	}
	
	/**
	 * 获取当前页码
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}
	
	/**
	 * 设置当前页码
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * 获取页面大小
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置页面大小（最大500）
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		// > 500 ? 500 : pageSize;
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
	}

	/**
	 * 首页索引
	 * @return
	 */
	@JsonIgnore
	public int getFirst() {
		return first;
	}

	/**
	 * 尾页索引
	 * @return
	 */
	@JsonIgnore
	public int getLast() {
		return last;
	}

	/**
	 * 获取页面总数
	 * @return getLast();
	 */
	@JsonIgnore
	public int getTotalPage() {
		return getLast();
	}

	/**
	 * 是否为第一页
	 * @return
	 */
	@JsonIgnore
	public boolean isFirstPage() {
		return firstPage;
	}

	/**
	 * 是否为最后一页
	 * @return
	 */
	@JsonIgnore
	public boolean isLastPage() {
		return lastPage;
	}

	/**
	 * 上一页索引值
	 * @return
	 */
	@JsonIgnore
	public int getPrev() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	/**
	 * 下一页索引值
	 * @return
	 */
	@JsonIgnore
	public int getNext() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	/**
	 * 获取本页数据对象列表
	 * @return List<T>
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置本页数据对象列表
	 * @param list
	 */
	public Page<T> setList(List<T> list) {
		this.list = list;
		initialize();
		return this;
	}

	/**
	 * 获取查询排序字符串
	 * @return
	 */
	@JsonIgnore
	public String getOrderBy() {
		// SQL过滤，防止注入 
		String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
					+ "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
		Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		if (sqlPattern.matcher(orderBy).find()) {
			return "";
		}
		return orderBy;
	}

	/**
	 * 设置查询排序，标准查询有效， 实例： updatedate desc, name asc
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * 获取点击页码调用的js函数名称
	 * function ${page.funcName}(pageNo){location="${ctx}/list-${category.id}${urlSuffix}?pageNo="+i;}
	 * @return
	 */
	@JsonIgnore
	public String getFuncName() {
		return funcName;
	}

	/**
	 * 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
	 * @param funcName 默认为page
	 */
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	/**
	 * 获取分页函数的附加参数
	 * @return
	 */
	@JsonIgnore
	public String getFuncParam() {
		return funcParam;
	}

	/**
	 * 设置分页函数的附加参数
	 * @return
	 */
	public void setFuncParam(String funcParam) {
		this.funcParam = funcParam;
	}

	/**
	 * 设置提示消息，显示在“共n条”之后
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 分页是否有效
	 * @return this.pageSize==-1
	 */
	@JsonIgnore
	public boolean isDisabled() {
		return this.pageSize==-1;
	}
	
	/**
	 * 是否进行总数统计
	 * @return this.count==-1
	 */
	@JsonIgnore
	public boolean isNotCount() {
		return this.count==-1;
	}
	
	/**
	 * 获取 Hibernate FirstResult
	 */
	public int getFirstResult(){
		int firstResult = (getPageNo() - 1) * getPageSize();
		if (firstResult >= getCount() || firstResult<0) {
			firstResult = 0;
		}
		return firstResult;
	}
	/**
	 * 获取 Hibernate MaxResults
	 */
	public int getMaxResults(){
		return getPageSize();
	}


}
