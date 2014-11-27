/*------------------------------------------------------------------------- 
 * 版权所有：北京光宇在线科技有限责任公司 
 * 作者：fanyongliang
 * 联系方式：fanyongliang@gyyx.cn 
 * 创建时间： 2014年11月18日 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 分页查询实体类
-------------------------------------------------------------------------*/
package cn.gyyx.java.beans;

import java.io.Serializable;

/**
 * 实体类 PageInfo 管理分页查询页码信息
 * @author fanyongliang
 *
 */

public class PageInfo implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * pageSize 需要的分组的数量
	 * pageIndex 当前页的页码
	 */
	private int pageSize = 5;
	private int pageIndex = 1;
	
	/**
	 * Get Set 方法
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
