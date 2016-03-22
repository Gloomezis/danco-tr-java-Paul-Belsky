package com.danco.util;

import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class printUtil.
 */
public class PrintUtil implements IPrintUtil {

	/**
	 * Instantiates a new prints the util.
	 */
	public PrintUtil() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.util.IPrintUtils#printString(java.lang.String)
	 */
	@Override
	public void printString(String out) {
		System.out.println(out);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.util.IPrintUtils#printString(java.lang.String[])
	 */
	@Override
	public void printString(String[] out) {
		System.out.println(out);
	}

}
