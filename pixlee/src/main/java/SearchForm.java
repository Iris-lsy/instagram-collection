import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class SearchForm {
	private String tagString;
	private String startDateString;
	private String endDateString;
	private String actionString;
	
	private long startDate;
	private long endDate;
	
	private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


	public SearchForm(HttpServletRequest request) {
		this.tagString = request.getParameter("tag");
		this.startDateString = request.getParameter("start");
		this.endDateString = request.getParameter("end");
		this.actionString = request.getParameter("action");
	}

	public String getTagString() {
		return tagString;
	}

	public void setTagString(String tag) {
		this.tagString = tag;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (tagString == null || tagString.trim().length() == 0) {
			errors.add("Tag input is required");
		}

		if (startDateString == null || startDateString.trim().length() == 0) {
			errors.add("Start Date is required.");
		}
		if (endDateString == null || endDateString.trim().length() == 0) {
			errors.add("End Date is required.");
		}

		if (actionString == null || actionString.trim().length() == 0) {
			errors.add("Action is required.");
		}

		if (errors.size() > 0) {
			return errors;
		}
			
		tagString = tagString.trim();
		startDateString = startDateString.trim();
		endDateString = endDateString.trim();
		actionString = actionString.trim();
		
		if (!actionString.equals("Search")) {
			errors.add("Invalid action.");
		}
		
		try {
			startDate = format.parse(startDateString).getTime() / 1000;
			endDate = format.parse(endDateString).getTime() / 1000;
		} catch (ParseException e) {
			errors.add("Please enter date as yyyy-MM-dd");
			return errors;
		}
		if (startDate > endDate) {
			errors.add("Start date should be earlier than end date.");

		}

		return errors;
	}
}