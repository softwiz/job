package jp.co.softwiz.main.common.util;



import java.util.ArrayList;
import java.util.Hashtable;

import jp.co.softwiz.main.common.constants.CommonConst;



public class Pager
{
	public static int getEndPage(int currentBlock, int totalBlock, int totalPage, int pageCount)
	{
		int endPage;

		if(totalBlock > 1 && currentBlock < totalBlock)
		{
			endPage = currentBlock * pageCount;
		}
		else
		{
			endPage = totalPage;
		}

		return endPage;
	}

	public static int getLastPage(int movedPage, int totalPage, int pageCount)
	{
		int lastPage;

		if((totalPage - movedPage) > pageCount) {
			lastPage = movedPage + pageCount;
		} else {
			lastPage = totalPage;
		}

		return lastPage;
	}

	public static Hashtable<String, Object> getPageElements(int movedPage, int totalCount, int listCount, int pageCount)
	{
		int firstPage = 1;
		int nextBlockPage = 0;

		Boolean isPreviousBlock = Boolean.FALSE;
		Boolean isNextBlock = Boolean.FALSE;
		Boolean isPrevious = Boolean.FALSE;
		Boolean isNext = Boolean.FALSE;

		int startList = (movedPage - 1) * listCount;
		int endList =  movedPage * listCount;

		float fTotalCount = new Float(totalCount).floatValue();
		float fListCount = new Float(listCount).floatValue();
		float fMovedPage = new Float(movedPage).floatValue();
		float fPageCount = new Float(pageCount).floatValue();

		int totalPage = new Double(Math.ceil(new Double(fTotalCount / fListCount).doubleValue())).intValue();
		float fTotalPage = new Float(totalPage).floatValue();
		int totalBlock = new Double(Math.ceil(new Double(fTotalPage / fPageCount).doubleValue())).intValue();
		int currentBlock = new Double(Math.ceil(new Double(fMovedPage / fPageCount).doubleValue())).intValue();

		if(totalBlock == 0) totalBlock = 1;
		if(currentBlock == 0) currentBlock = 1;

		int startPage = ((currentBlock - 1) * pageCount) + 1;
		int endPage = getEndPage(currentBlock, totalBlock, totalPage, pageCount);

		if(currentBlock > 1) isPreviousBlock = Boolean.TRUE;
		if(movedPage > 1 && totalCount > listCount)	isPrevious = Boolean.TRUE;
		if(totalCount > 1 && movedPage < totalPage) isNext = Boolean.TRUE;
		if(totalBlock > 1 && currentBlock < totalBlock) {
			nextBlockPage = getLastPage(movedPage, totalPage, pageCount);
			isNextBlock = Boolean.TRUE;
		}

		ArrayList<Integer> pages = new ArrayList<Integer>();
		for(int page = startPage; page <= endPage; page++) {
			pages.add(new Integer(page));
		}

		Hashtable<String, Object> pageElements = new Hashtable<String, Object>();

		pageElements.put("MOVED_PAGE", new Integer(movedPage));
		pageElements.put("LIST_COUNT", new Integer(listCount));
		pageElements.put("PAGE_COUNT", new Integer(pageCount));
		pageElements.put("TOTAL_COUNT", new Integer(totalCount));
		pageElements.put("TOTAL_PAGE", new Integer(totalPage));
		pageElements.put("TOTAL_BLOCK", new Integer(totalBlock));
		pageElements.put("CURRENT_BLOCK", new Integer(currentBlock));
		pageElements.put("START_PAGE", new Integer(startPage));
		pageElements.put("END_PAGE", new Integer(endPage));
		pageElements.put("LIST_START", startList);
		pageElements.put("LIST_END", endList);
		pageElements.put("FIRST_PAGE", new Integer(firstPage));
		pageElements.put("PREVIOUS_BLOCK_PAGE", new Integer(movedPage - pageCount));
		pageElements.put("PREVIOUS_PAGE", new Integer(movedPage - 1));
		pageElements.put("NEXT_PAGE", new Integer(movedPage + 1));
		pageElements.put("NEXT_BLOCK_PAGE", new Integer(nextBlockPage));
		pageElements.put("LAST_PAGE", new Integer(totalPage));
		pageElements.put("IS_PREVIOUS_BLOCK", isPreviousBlock);
		pageElements.put("IS_NEXT_BLOCK", isNextBlock);
		pageElements.put("IS_PREVIOUS", isPrevious);
		pageElements.put("IS_NEXT", isNext);
		pageElements.put("PAGES", pages);

		return pageElements;
	}

	public static Hashtable<String, Object> getPageElements(int movedPage, int totalCount)
	{
		int firstPage = 1;
		int nextBlockPage = 0;
		int listCount = Integer.parseInt(CommonConst.LIST_COUNT);
		int pageCount = Integer.parseInt(CommonConst.PAGE_COUNT);;

		Boolean isPreviousBlock = Boolean.FALSE;
		Boolean isNextBlock = Boolean.FALSE;
		Boolean isPrevious = Boolean.FALSE;
		Boolean isNext = Boolean.FALSE;

		int startList = (movedPage - 1) * listCount;
		int endList =  movedPage * listCount;

		float fTotalCount = new Float(totalCount).floatValue();
		float fListCount = new Float(listCount).floatValue();
		float fMovedPage = new Float(movedPage).floatValue();
		float fPageCount = new Float(pageCount).floatValue();

		int totalPage = new Double(Math.ceil(new Double(fTotalCount / fListCount).doubleValue())).intValue();
		float fTotalPage = new Float(totalPage).floatValue();
		int totalBlock = new Double(Math.ceil(new Double(fTotalPage / fPageCount).doubleValue())).intValue();
		int currentBlock = new Double(Math.ceil(new Double(fMovedPage / fPageCount).doubleValue())).intValue();

		if(totalBlock == 0) totalBlock = 1;
		if(currentBlock == 0) currentBlock = 1;

		int startPage = ((currentBlock - 1) * pageCount) + 1;
		int endPage = getEndPage(currentBlock, totalBlock, totalPage, pageCount);

		if(currentBlock > 1) isPreviousBlock = Boolean.TRUE;
		if(movedPage > 1 && totalCount > listCount)	isPrevious = Boolean.TRUE;
		if(totalCount > 1 && movedPage < totalPage) isNext = Boolean.TRUE;
		if(totalBlock > 1 && currentBlock < totalBlock) {
			nextBlockPage = getLastPage(movedPage, totalPage, pageCount);
			isNextBlock = Boolean.TRUE;
		}

		ArrayList<Integer> pages = new ArrayList<Integer>();
		for(int page = startPage; page <= endPage; page++) {
			pages.add(new Integer(page));
		}

		Hashtable<String, Object> pageElements = new Hashtable<String, Object>();

		pageElements.put("MOVED_PAGE", new Integer(movedPage));
		pageElements.put("LIST_COUNT", new Integer(listCount));
		pageElements.put("PAGE_COUNT", new Integer(pageCount));
		pageElements.put("TOTAL_COUNT", new Integer(totalCount));
		pageElements.put("TOTAL_PAGE", new Integer(totalPage));
		pageElements.put("TOTAL_BLOCK", new Integer(totalBlock));
		pageElements.put("CURRENT_BLOCK", new Integer(currentBlock));
		pageElements.put("START_PAGE", new Integer(startPage));
		pageElements.put("END_PAGE", new Integer(endPage));
		pageElements.put("LIST_START", startList);
		pageElements.put("LIST_END", endList);
		pageElements.put("FIRST_PAGE", new Integer(firstPage));
		pageElements.put("PREVIOUS_BLOCK_PAGE", new Integer(movedPage - pageCount));
		pageElements.put("PREVIOUS_PAGE", new Integer(movedPage - 1));
		pageElements.put("NEXT_PAGE", new Integer(movedPage + 1));
		pageElements.put("NEXT_BLOCK_PAGE", new Integer(nextBlockPage));
		pageElements.put("LAST_PAGE", new Integer(totalPage));
		pageElements.put("IS_PREVIOUS_BLOCK", isPreviousBlock);
		pageElements.put("IS_NEXT_BLOCK", isNextBlock);
		pageElements.put("IS_PREVIOUS", isPrevious);
		pageElements.put("IS_NEXT", isNext);
		pageElements.put("PAGES", pages);

		return pageElements;
	}
}
