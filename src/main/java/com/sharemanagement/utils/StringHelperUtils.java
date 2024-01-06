package com.sharemanagement.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class StringHelperUtils {

	public String handleString(Object obj) {

		try {

			if (obj == null) {

				return "";

			} else {

				return (String) obj;
			}

		} catch (Exception e) {

			return "";
		}

	}

	public long handleLong(Object obj) {

		try {

			if (obj == null) {

				return 0l;

			} else {

				return (long) obj;
			}

		} catch (Exception e) {

			return 0l;
		}

	}

	public int handleInt(Object obj) {

		try {

			if (obj == null) {

				return 0;

			} else {

				return (int) obj;
			}

		} catch (Exception e) {

			return 0;
		}

	}

	public BigInteger handleBigInt(Object obj){

		try{

			if(obj == null){

				return new BigInteger("0");

			}else{
				return (BigInteger) obj;
			}

		}catch(Exception e){

			return new BigInteger("0");
		}
	}

}
