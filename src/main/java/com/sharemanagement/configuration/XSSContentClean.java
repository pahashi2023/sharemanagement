package com.sharemanagement.configuration;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.owasp.esapi.ESAPI;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class XSSContentClean extends HttpServletRequestWrapper {

	public XSSContentClean(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String[] getParameterValues(final String parameter) {

		final String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		final int count = values.length;
		final String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}
		return encodedValues;
	}

	@Override
	public String getParameter(final String parameter) {
		final String value = super.getParameter(parameter);
		return stripXSS(value);
	}

	@Override
	public String getHeader(final String name) {
		final String value = super.getHeader(name);
		return stripXSS(value);
	}

	private String stripXSS(String value) {
		if (value == null) {
			return null;
		}
		value = ESAPI.encoder().canonicalize(value).replaceAll("\0", "");
		return Jsoup.clean(value, Safelist.none());
	}

}
