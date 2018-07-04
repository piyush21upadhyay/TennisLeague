/*
 * ValidationUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.util;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.springframework.validation.Errors;
import org.springmodules.validation.commons.FieldChecks;

import com.sageconsulting.model.User;

/**
 * ValidationUtil Helper class for performing custom validations that aren't
 * already included in the core Commons Validator.
 */
public class ValidationUtil
{
    /**
     * Validates that two fields match.
     * 
     * @param bean
     * @param va
     * @param field
     * @param errors
     */
    public static boolean validateTwoFields(Object bean, ValidatorAction va, Field field, Errors errors)
    {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondProperty"); //$NON-NLS-1$
        String value2 = ValidatorUtils.getValueAsString(bean, sProperty2);

        if (!GenericValidator.isBlankOrNull(value))
        {
            try
            {
                if (!value.equals(value2))
                {
                    FieldChecks.rejectValue(errors, field, va);
                    return false;
                }
            }
            catch (Exception e)
            {
                FieldChecks.rejectValue(errors, field, va);
                return false;
            }
        }

        return true;
    }
    
    /**
     * Validates the a value is a valid ghin number.
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @return
     */
    public static boolean validateGhin(Object bean, ValidatorAction va, Field field, Errors errors)
    {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        try
        {
        	Integer.parseInt(value);
        }
        catch (NumberFormatException ex)
        {
        	FieldChecks.rejectValue(errors, field, va);
        	return false;
        }
        return true;
    }
    
    /**
     * Validates the a value is a valid handicap number.
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @return
     */
    public static boolean validateHandicap(Object bean, ValidatorAction va, Field field, Errors errors)
    {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        try
        {
        	Double.parseDouble(value);
        }
        catch (NumberFormatException ex)
        {
        	FieldChecks.rejectValue(errors, field, va);
        	return false;
        }
        return true;
    }
    
    /**
     * Validate that the user entered a value for at least one of the specified fields.
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @return
     */
    public static boolean validateOneField(Object bean, ValidatorAction va, Field field, Errors errors)
    {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondProperty"); //$NON-NLS-1$
        String value2 = ValidatorUtils.getValueAsString(bean, sProperty2);

        if (GenericValidator.isBlankOrNull(value) && GenericValidator.isBlankOrNull(value2))
        {
        	FieldChecks.rejectValue(errors, field, va);
        	return false;
        }

        return true;
    }
    
    /**
     * Validate the credit card information submitted by user.
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @return
     */
    public static boolean validateCustomCreditCard(Object bean, ValidatorAction va, Field field, Errors errors)
    {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        String sProperty2 = field.getVarValue("secondProperty"); //$NON-NLS-1$
        String value2 = ValidatorUtils.getValueAsString(bean, sProperty2);

        if (GenericValidator.isBlankOrNull(value) && GenericValidator.isBlankOrNull(value2))
        {
        	FieldChecks.rejectValue(errors, field, va);
        	return false;
        }

        return true;
    }
    
    /**
     * Validate two fields -> Playing Preference and Opponent Skill Level
     * @param bean
     * @param va
     * @param field
     * @param errors
     * @return
     */
    public static boolean validateCheckbox(Object bean, ValidatorAction va, Field field, Errors errors)
    {
    	User user=(User) bean;
    	
    	if (user.getPlayingPreference()==null || user.getOpponentSkillLevel()==null)
        {
        	FieldChecks.rejectValue(errors, field, va);
        	return false;
        }

        return true;
    	
    }
}
