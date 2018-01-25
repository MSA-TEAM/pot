package kr.co.sicc.gsp.svm.sicc.common.vo;

public class PageVO {
		private int page = 1;
		private int page_interval_st = 1;
		private int page_interval_ed = 1;
		private int limit = 10;
		private int interval = 10;
		private int total_cnt = 0;
		
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getLimit() {
			return limit;
		}
		public void setLimit(int limit) {
			this.limit = limit;
		}
		public int getTotal_cnt() {
			return total_cnt;
		}
		public void setTotal_cnt(int total_cnt) {
			this.total_cnt = total_cnt;
			
			this.page_interval_st = (int)(1 + (Math.ceil(page*1.0/interval)-1)*interval);
			if(Math.ceil(page*1.0/interval) == Math.ceil(total_cnt*1.0/(interval*limit))){
				this.page_interval_ed = (int)Math.ceil(total_cnt*1.0/limit);
			}else{
				this.page_interval_ed = (int)Math.ceil(page*1.0/interval)*interval;
			}
		}
		public int getPage_interval_st() {
			return page_interval_st;
		}
		public void setPage_interval_st(int page_interval_st) {
			this.page_interval_st = page_interval_st;
		}
		public int getPage_interval_ed() {
			return page_interval_ed;
		}
		public void setPage_interval_ed(int page_interval_ed) {
			this.page_interval_ed = page_interval_ed;
		}
		public int getInterval() {
			return interval;
		}
		public void setInterval(int interval) {
			this.interval = interval;
		}
}
