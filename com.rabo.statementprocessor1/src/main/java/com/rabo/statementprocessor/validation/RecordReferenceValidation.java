package com.rabo.statementprocessor.validation;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.rabo.statementprocessor.validation.*;

import java.math.BigDecimal;

/**
 * this class compares the reference of each customer and stores details,and
 * removes the failed references.
 */

public class RecordReferenceValidation {
	/**
	 * 
	 * @param customerDetails
	 * @ In this method the customerdetails has taken as the string array and unique
	 * records were added to the list of valid records and failed records were added
	 * to the failed records.
	 * @exception IOException,ClassNotFoundException On input error.
	 * @see IOException,ClassNotFoundException.
	 */

	public static ArrayList<String>  validationMethod(String[] customerDetails) throws IOException, ClassNotFoundException {
		ArrayList<String> validrecords = new ArrayList<String>(Arrays.asList(customerDetails));
		ArrayList<String> failedrecords = new ArrayList<String>();
		Arrays.sort(customerDetails);
		for (int i = 1; i < customerDetails.length; i++) {
			if (customerDetails[i].substring(0, 6).equals(customerDetails[i - 1].substring(0, 6))) {
				validrecords.remove(customerDetails[i]);
				failedrecords.add(customerDetails[i]);

			}
		}

		
		FailedRecordReferences.duplicates(failedrecords);
		String validReferences[] = validrecords.toArray(new String[validrecords.size()]);

		EndBalanceValidation.details(validReferences);
		
		
		return failedrecords;

	}
}
