package wt.bookstore.backend.dto;

import java.util.List;

public class SearchReservationResultDto<O extends Object> {

	private int page;

	private int totalPages;
	
	private int elementCount;
	
	private List<O> content;
	
	public SearchReservationResultDto() {
		
	}
	
	public SearchReservationResultDto(int page, int totalPages, int elementCount, List<O> content) {
		super();
		this.page = page;
		this.totalPages = totalPages;
		this.elementCount = elementCount;
		this.content = content;
	}



	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getElementCount() {
		return elementCount;
	}

	public void setElementCount(int elementCount) {
		this.elementCount = elementCount;
	}

	public List<O> getContent() {
		return content;
	}

	public void setContent(List<O> content) {
		this.content = content;
	}
	
		
}
