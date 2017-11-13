package com.icss.hr.common;
/**
 * ��ҳ������
 * @author DLETC
 *
 */
public class Pager {
	
	private int recordCount;//�ܼ�¼��
	
	private int pageSize = 10;//ÿҳ����
	
	private int pageCount;//��ҳ��
	
	private int pageNum;//��ǰҳ��
	
	private int start;//��¼��ʼλ��
	
	public Pager(int recordCount ,int pageSize,int pageNum){
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		
		//���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if(this.recordCount % this.pageSize != 0)
			this.pageCount ++;
		//���㵱ǰҳ��
		if(this.pageNum < 1)
			this.pageNum = 1;
		if(this.pageNum > pageCount)
			this.pageNum = this.pageCount;
		//������ʼλ��
		this.start = (this.pageNum - 1)*pageSize +1;
		
	}

	
	public Pager(int recordCount,int pageNum){
		this.recordCount = recordCount;
		
		this.pageNum = pageNum;
		
		//���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if(this.recordCount % this.pageSize != 0)
			this.pageCount ++;
		//���㵱ǰҳ��
		if(this.pageNum < 1)
			this.pageNum = 1;
		if(this.pageNum > pageCount)
			this.pageNum = this.pageCount;
		//������ʼλ��
		this.start = (this.pageNum - 1)*pageSize +1;
		
	}
	
	public int getRecordCount() {
		return recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStart() {
		return start;
	}
	
	
//	@Override
//	public String toString() {
//		return "Pager [recordCount=" + recordCount + ", pageSize=" + pageSize + ", pageCount=" + pageCount
//				+ ", pageNum=" + pageNum + ", start=" + start + "]";
//	}
//
//	public static void main(String[] args) {
//		Pager pager = new Pager(41, 5, 2);
//		
//		System.out.println(pager);
//	}
//	
	
}
