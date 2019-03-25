package com.rai.kaushal.query.protocol;


import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String query;
	
	@XmlElement
	private List<String> requiredFieldNames;
	
	@XmlElement
	private List<String> requiredFieldValues;
	
	@XmlElement
	private List<String> compoundQueryFieldNames;
	
	@XmlElement
	private List<String> compoundQueryFieldValues;
	
	@XmlElement
	private List<String> excludeFieldNames;
	
	@XmlElement
	private List<String> excludeFieldValues;
	
	@XmlElement
	private String start;
	
	@XmlElement
	private String limit;
	
	@XmlElement
	private List<String> rangeFieldName;
	
	@XmlElement
	private List<Long> startRange;
	
	@XmlElement
	private List<Long> endRange;
	
	@XmlElement
	private List<String> textSearchableFieldNames;
	

	private List<String> responseFields;
	
	// Fields in which the query string is to be searched. If not provided, the query string would be
	// searched in all fields.
	private String[] searchFields;
		
	private String sourceIndex;
	
	// This field indicates if facets are required by client. Facet creation is an expensive process,
	// hence it should be used only if required.
	private String facetRequired;
	
	// It is indicates if the matching text for query string is to be sent back in the response.
	private String highlightRequired;

	public String getHighlightRequired() {
		return highlightRequired;
	}

	public void setHighlightRequired(String highlightRequired) {
		this.highlightRequired = highlightRequired;
	}

	public String getFacetRequired() {
		return facetRequired;
	}

	public void setFacetRequired(String facetRequired) {
		this.facetRequired = facetRequired;
	}

	public String[] getSearchFields() {
		return searchFields;
	}

	public void setSearchFields(String[] searchFields) {
		this.searchFields = searchFields;
	}

	public void setExcludeFields(List<String> excludeFieldNames, List<String> excludeFieldValues) {
		this.excludeFieldNames = excludeFieldNames;
		this.excludeFieldValues = excludeFieldValues;
	}

	
	public void setNumericRange(List<String> rangeFieldName, List<Long> startRange, List<Long> endRange) {
		this.rangeFieldName = rangeFieldName;
		this.startRange = startRange;
		this.endRange = endRange;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public void setRequiredFields(List<String> requiredFieldNames, List<String> requiredFieldValues) {
		this.requiredFieldNames = requiredFieldNames;
		this.requiredFieldValues = requiredFieldValues;
	}

	
	public void setResultLimitRange(String start, String limit) {
		this.start = start;
		this.limit = limit;
	}

	
	public void setTextSearchableFields(List<String> textSearchableFieldNames) {
		this.textSearchableFieldNames = textSearchableFieldNames;
		
	}

	public String getQuery() {
		return query;
	}

	public List<String> getRequiredFieldNames() {
		return requiredFieldNames;
	}

	public List<String> getRequiredFieldValues() {
		return requiredFieldValues;
	}

	public List<String> getExcludeFieldNames() {
		return excludeFieldNames;
	}

	public List<String> getExcludeFieldValues() {
		return excludeFieldValues;
	}

	public String getStart() {
		return start;
	}

	public String getLimit() {
		return limit;
	}

	public List<String> getRangeFieldName() {
		return rangeFieldName;
	}

	public List<Long> getStartRange() {
		return startRange;
	}

	public List<Long> getEndRange() {
		return endRange;
	}

	public List<String> getTextSearchableFieldNames() {
		return textSearchableFieldNames;
	}
	

	public String getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(String sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	
	public List<String> getResponseFieldsList() {
		return responseFields;
	}

	public void setResponseFieldsList(List<String> responseFieldsList) {
		this.responseFields = responseFieldsList;
	}

	public List<String> getCompoundQueryFieldNames() {
		return compoundQueryFieldNames;
	}

	public void setCompoundQueryFields(List<String> compoundQueryFieldNames, List<String> compoundQueryFieldValues) {
		this.compoundQueryFieldNames = compoundQueryFieldNames;
		this.compoundQueryFieldValues = compoundQueryFieldValues;
	}

	public List<String> getCompoundQueryFieldValues() {
		return compoundQueryFieldValues;
	}
}