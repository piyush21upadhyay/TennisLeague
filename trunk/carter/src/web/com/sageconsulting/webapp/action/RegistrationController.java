/*
 * RegistrationController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.model.User;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.service.RegistrationManager;

public class RegistrationController extends BaseFormController
{
    private static final String CMD_NAME = "registrationEntry"; //$NON-NLS-1$
    
    private RegistrationManager registrationManager;
    private RegistrationEntryManager registrationEntryManager;

    private String loginId;
    private String transactionKey;
    private String amount;
    private static final String BLANK=" ";

    public RegistrationController()
    {
        setCommandName(CMD_NAME);
        setCommandClass(RegistrationEntry.class);
    }

    public void setLoginId(String id)
    {
        this.loginId = id;
    }

    public void setTransactionKey(String key)
    {
        this.transactionKey = key;
    }
    
    public void setAmount(String amt)
    {
        this.amount = amt;
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
        this.registrationEntryManager = mgr;
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects.
     * @param request The current request.
     * @param binder The object which binds an input to a custom editor.
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(Registration.class, null,
        	new CustomRegistrationEditor(getCurrentRegistrations(request)));
        super.initBinder(request, binder);
    }
    
    /**
     * Handle the showing of the registration form.
     * @param request The current request object.
     * @param response The current response object.
     * @param errors A collection of errors on the form.
     * @return The ModelAndView object to display after processing.
     * @exception Exception For errors processing the form.
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
        throws Exception
    {
        ModelAndView modelAndView = super.showForm(request, response, errors);
        List<Registration> openRegistrations = getCurrentRegistrations(request);
        if ((null == openRegistrations) || (openRegistrations.size() < 1))
        {
        	saveMessage(request, super.getText("registration.noseasons", request.getLocale())); //$NON-NLS-1$
        }
        else
        {
        	modelAndView.addObject("seasonList", openRegistrations); //$NON-NLS-1$
	        Date startRegDate = openRegistrations.get(0).getRegularRegistrationStart();
	        Float regAmount = 0.0f;
	        
	        Calendar currentDate = Calendar.getInstance();
	        currentDate.setTime(new Date());
	        
	        Calendar startDate = Calendar.getInstance();
	        startDate.setTime(startRegDate);
	        startDate.add(Calendar.DAY_OF_MONTH, 1);
	        
	        if(currentDate.after(startDate))
	        	regAmount = openRegistrations.get(0).getRegularRegistrationFee();
	        else
	        	regAmount = openRegistrations.get(0).getEarlyRegistrationFee();
	        
	        this.setAmount(String.valueOf(regAmount));
	        modelAndView.addObject("amount", regAmount); //$NON-NLS-1$
        }
        return modelAndView;
    }
    
    @Override
    public Object formBackingObject(HttpServletRequest request) throws Exception
    {
        RegistrationEntry entry = (RegistrationEntry)super.formBackingObject(request);

        User user = getCurrentUser(request);
        if (null != user)
        {
            entry.setUser(user);
            if ((null == entry.getFirstName()) || (entry.getFirstName().length() < 1))
            {
                entry.setFirstName(user.getFirstName());
            }
            if ((null == entry.getLastName()) || (entry.getLastName().length() < 1))
            {
                entry.setLastName(user.getLastName());
            }
            if ((null == entry.getBillingAddress().getAddress()) || (entry.getBillingAddress().getAddress().length() < 1))
            {
            	entry.getBillingAddress().setAddress(user.getAddress().getAddress());
            }
            if ((null == entry.getBillingAddress().getCity()) || (entry.getBillingAddress().getCity().length() < 1))
            {
            	entry.getBillingAddress().setCity(user.getAddress().getCity());
            }
            if ((null == entry.getBillingAddress().getProvince()) || (entry.getBillingAddress().getProvince().length() < 1))
            {
            	entry.getBillingAddress().setProvince(user.getAddress().getProvince());
            }
            if ((null == entry.getBillingAddress().getPostalCode()) || (entry.getBillingAddress().getPostalCode().length() < 1))
            {
            	entry.getBillingAddress().setPostalCode(user.getAddress().getPostalCode());
            }
            if ((null == entry.getBillingAddress().getCountry()) || (entry.getBillingAddress().getCountry().length() < 1))
            {
            	entry.getBillingAddress().setCountry(user.getAddress().getCountry());
            }
        }
        
        return entry;
    }
    
    private User getCurrentUser(HttpServletRequest request)
    {
        return this.getUserManager().getUserByUsername(request.getRemoteUser());
    }
    
    @Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if (isCancel(request))
    	{
    		return new ModelAndView(getCancelView());
    	}
    	
    	return super.handleRequestInternal(request, response);
    }
    
    private boolean isCancel(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    private boolean isBack(HttpServletRequest request)
    {
    	String back = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != back) && back.equals("true"); //$NON-NLS-1$
    }
    
    private boolean isRegister(HttpServletRequest request)
    {
    	String register = request.getParameter("bRegister"); //$NON-NLS-1$
    	return (null != register) && register.equals("true"); //$NON-NLS-1$
    }
    
    private boolean isVerify(HttpServletRequest request)
    {
    	String verify = request.getParameter("bVerify"); //$NON-NLS-1$
    	return (null != verify) && verify.equals("true"); //$NON-NLS-1$
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        RegistrationEntry entry = (RegistrationEntry)command;
        User user = getUserManager().getUserByUsername(request.getRemoteUser());
        entry.setUser(user);
        Locale locale = request.getLocale();

        ModelAndView view = showForm(request, response, errors);
        if (isBack(request))
        {
        	// do nothing which will go back to the first page
        }
        else if (isRegister(request))
        {
            if (validatePaymentInformation(entry, errors) && !alreadyRegistered(entry, errors))
            {
                view.addObject("verifySeason", entry.getRegistration().getDisplayName()); //$NON-NLS-1$
                //view.addObject("verifyCardInformation", createCardInformationString(entry, locale)); //$NON-NLS-1$
                view.addObject("acctType", "Credit Card"); //$NON-NLS-1$ //$NON-NLS-2$
                view.addObject("cardNumber", entry.getCardNumber()); //$NON-NLS-1$
                view.addObject("cardExpiration", entry.getCardExpiration()); //$NON-NLS-1$
                view.addObject("verifyExpiration", getFormattedExpiration(entry.getCardExpiration()));
                view.addObject("securityCode", entry.getSecurityCode());
            }
            return view;
        }
        else if (isVerify(request))
        {
            if (processCard(entry))
        	{
                this.registrationEntryManager.saveRegistrationEntry(entry);

                view.addObject("seasonList", null); //$NON-NLS-1$
                view.addObject("registeredSeason", entry.getRegistration().getDisplayName()); //$NON-NLS-1$
                view.addObject("verifySeason", entry.getRegistration().getDisplayName()); //$NON-NLS-1$
                view.addObject("acctType", "Credit Card"); //$NON-NLS-1$ //$NON-NLS-2$
                view.addObject("cardNumber", entry.getCardNumber()); //$NON-NLS-1$
                view.addObject("verifyExpiration", getFormattedExpiration(entry.getCardExpiration()));
            }
            else
            {
                errors.rejectValue("cardNumber", "registrationEntry.processingFailed", //$NON-NLS-1$ //$NON-NLS-2$
                    entry.getResponseCodeText());
            }
        }
        
        return view;
    }
    
    private boolean validatePaymentInformation(RegistrationEntry entry, BindException errors)
    {
        boolean isValid = true;
        
        if (!isCardNumberValid(entry.getCardNumber()))
        {
            isValid = false;
            errors.rejectValue("cardNumber", "registrationEntry.invalidCardNumber"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (!isExpirationDateValid(entry.getCardExpiration()))
        {
            isValid = false;
            errors.rejectValue("cardExpiration", "registrationEntry.invalidExpiration"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (!isSecurityCodeValid(entry.getSecurityCode()))
        {
        	isValid = false;
        	errors.rejectValue("securityCode", "registrationEntry.invalidSecurityCode"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (entry.getBillingAddress().getAddress().length() <= 0)
        {
        	isValid = false;
        	errors.rejectValue("billingAddress.address", "registrationEntry.addressRequired"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (entry.getBillingAddress().getCity().length() <= 0)
        {
        	isValid = false;
        	errors.rejectValue("billingAddress.city", "registrationEntry.cityRequired"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (entry.getBillingAddress().getProvince().length() <= 0)
        {
        	isValid = false;
        	errors.rejectValue("billingAddress.province", "registrationEntry.stateRequired"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (entry.getBillingAddress().getPostalCode().length() <= 0)
        {
        	isValid = false;
        	errors.rejectValue("billingAddress.postalCode", "registrationEntry.zipRequired"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (entry.getBillingAddress().getCountry().length() <= 0)
        {
        	isValid = false;
        	errors.rejectValue("billingAddress.country", "registrationEntry.countryRequired"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        return isValid;
    }
    
    private String getFormattedExpiration(String expiration)
    {
    	try
        {
            int year = Integer.parseInt(expiration.substring(2)) + 2000;
            int month = Integer.parseInt(expiration.substring(0, 2));
            return String.format("%d / %d", month, year);
        }
        catch (Exception e)
        {
            this.log.info("Invalid card expiration date entered: "+expiration); //$NON-NLS-1$
        }
        
        return expiration;
    }
    
    private boolean isCardNumberValid(String cardNumber)
    {
        if (cardNumber.length() < 13)
        {
            return false;
        }
        
        for (char c : cardNumber.toCharArray())
        {
            if ("0123456789".indexOf(c) < 0) //$NON-NLS-1$
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean isExpirationDateValid(String expiration)
    {
        GregorianCalendar now = new GregorianCalendar();
        if (expiration.length() != 5)
        {
            return false;
        }
        
        try
        {
            int year = Integer.parseInt(expiration.substring(3)) + 2000;
            int month = Integer.parseInt(expiration.substring(0, 2));

            if (year < now.get(Calendar.YEAR))
            {
                return false;
            }
            if ((year == now.get(Calendar.YEAR)) && (month <= now.get(Calendar.MONTH)))
            {
                return false;
            }
        }
        catch (Exception e)
        {
            this.log.info("Invalid card expiration date entered: "+expiration); //$NON-NLS-1$
            return false;
        }
        return true;
    }
    
    private boolean isSecurityCodeValid(String code)
    {
    	if ((code.length() < 3) || (code.length() > 5))
    	{
    		return false;
    	}
    	return true;
    }
    
    private boolean alreadyRegistered(RegistrationEntry entry, BindException errors)
    {
        List<RegistrationEntry> entries = this.registrationEntryManager.getRegistrationEntriesForUser(entry.getUser().getId());
        for (RegistrationEntry testEntry : entries)
        {
            if (testEntry.getRegistration().equals(entry.getRegistration()))
            {
                errors.reject("registrationEntry.alreadyRegistered"); //$NON-NLS-1$
                return true;
            }
        }
        return false;
    }
    
    private List<Registration> getCurrentRegistrations(HttpServletRequest request)
    {
    	String username = request.getRemoteUser();
    	List<Registration> totalRegBasedOnCityMatchPrefPlayerLvlAndGender=null;
    	if (null == username)
    	{
    		return null;
    	}
    	
    	User user = getUserManager().getUserByUsername(username);
    	if (null != user)
    	{
    		List<Registration> openRegistrationsForCity = this.registrationManager.getOpenRegistrationsForCity(user.getRegisteredCity().getId());
    		/**Code Added by Piyush/Akash starts**/
        	if(openRegistrationsForCity!=null && openRegistrationsForCity.size()>0){
        		totalRegBasedOnCityMatchPrefPlayerLvlAndGender=new ArrayList<Registration>();
        		for(Registration registration: openRegistrationsForCity){
        			
        			String userGender=user.getMale()==true?"Male":"Female";
        			List<String> userPlayingPrefList=Arrays.asList(user.getPlayingPreference());
        			
        			for(String gender:registration.getGender()){
        				if(gender.equalsIgnoreCase(userGender)){
        					
        					for(String matchPref:registration.getPlayingPreference()){
        						if(userPlayingPrefList!=null && userPlayingPrefList.contains(matchPref)){
        							
        							for(Double playerLevel: registration.getPlayerLevel()){
        								if(Double.compare(user.getPlayerLevel(), playerLevel)==0 || Double.compare((user.getPlayerLevel()+0.5), playerLevel)==0){
        									Registration reg=new Registration();
        				        			reg.setCity(registration.getCity());
        				        			reg.setEarlyRegistrationStart(registration.getEarlyRegistrationStart());
        				        			reg.setRegularRegistrationStart(registration.getRegularRegistrationStart());
        				        			reg.setRegistrationEnd(registration.getRegistrationEnd());
        				        			reg.setEarlyRegistrationFee(registration.getEarlyRegistrationFee());
        				        			reg.setRegularRegistrationFee(registration.getRegularRegistrationFee());
        				        			
        									gender=Character.toUpperCase(gender.charAt(0))+gender.substring(1);
        									reg.setDisplayName(registration.getDisplayName().concat(BLANK).concat(gender).concat(BLANK).concat(matchPref).concat(BLANK).concat(""+playerLevel));
        									/*reg.setGender(new String[]{gender});
        									reg.setPlayingPreference(new String[]{matchPref});
        									reg.setPlayerLevel(new Double[]{playerLevel});*/
        									totalRegBasedOnCityMatchPrefPlayerLvlAndGender.add(reg);
        								}
        							}
        							
        						}
        					}
        					
        				}
        			}
        		}
        	}
        	return totalRegBasedOnCityMatchPrefPlayerLvlAndGender;
        	/**Code Added by Piyush/Akash ends**/
    	}
    	return null;
    }
    
    private boolean processCard(RegistrationEntry entry)
    {
    	/* This is out for now until we hook authorize.net back up */
        try
        {
            StringBuffer sb = new StringBuffer();

            // Create the AIM string to pass to the server.
            sb.append("x_login=").append(this.loginId).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_tran_key=").append(this.transactionKey).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_version=3.1&"); //$NON-NLS-1$
            //sb.append("x_test_request=TRUE&"); // for testing
            sb.append("x_method=CC&"); //$NON-NLS-1$
            sb.append("x_type=AUTH_CAPTURE&"); //$NON-NLS-1$
            sb.append("x_amount=").append(this.amount).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_delim_data=TRUE&"); //$NON-NLS-1$
            sb.append("x_delim_char=|&"); //$NON-NLS-1$
            sb.append("x_relay_response=FALSE&"); //$NON-NLS-1$

            // CC information
            String expiryDate = entry.getCardExpiration();
            if(expiryDate != null)
            	expiryDate = expiryDate.replaceFirst("/", "");
            sb.append("x_card_num=").append(entry.getCardNumber()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_exp_date=").append(expiryDate).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            
            // User info
            sb.append("x_first_name=").append(entry.getFirstName()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_last_name=").append(entry.getLastName()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_address=").append(entry.getUser().getAddress().getAddress()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_city=").append(entry.getUser().getAddress().getCity()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_state=").append(entry.getUser().getAddress().getProvince()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_zip=").append(entry.getUser().getAddress().getPostalCode()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_mail=").append(entry.getUser().getEmail()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("x_cust_id=").append(entry.getUser().getId()).append("&"); //$NON-NLS-1$ //$NON-NLS-2$

            // not required...but my test account is set up to require it
            sb.append("x_description=").append("City Golf League - "). //$NON-NLS-1$ //$NON-NLS-2$
                append(entry.getRegistration().getDisplayName()).append("&"); //$NON-NLS-1$
            
            //this.log.info(sb.toString());

            // open secure connection
            URL url = new URL("https://secure.authorize.net/gateway/transact.dll"); //$NON-NLS-1$

            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            // not necessarily required but fixes a bug with some servers
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //$NON-NLS-1$ //$NON-NLS-2$

            // POST the data in the string buffer
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(sb.toString().getBytes());
            out.flush();
            out.close();

            // process and read the gateway response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            line = in.readLine();
            in.close(); // no more data

            // ONLY FOR THOSE WHO WANT TO CAPTURE GATEWAY RESPONSE INFORMATION
            // make the reply readable (be sure to use the x_delim_char for the
            // split operation)
            List<String> response = split("|", line); //$NON-NLS-1$

            entry.setResponseCode(response.get(0));
            entry.setResponseCodeText(response.get(3));
            entry.setApprovalCode(response.get(4));
            entry.setTransactionId(response.get(6));
            entry.setMD5HashServer(response.get(37));

            // TODO: change from true back to false
            if (!entry.getResponseCode().equals("1")) //$NON-NLS-1$
            {
                return true;
            }
        }
        catch (Exception e)
        {
        	// TODO: change from true back to false
            this.log.error("Failed to process credit card.", e); //$NON-NLS-1$
            return true;
        }
        
        return true;
    }
    
    public static List<String> split(String pattern, String in)
    {
        int s1 = 0, s2 = -1;
        List<String> out = new ArrayList<String>(40);
        while (true)
        {
            s2 = in.indexOf(pattern, s1);
            if (s2 != -1)
            {
                out.add(in.substring(s1, s2));
            }
            else
            {
                // the end part of the string (string not pattern terminated)
                String _ = in.substring(s1);
                if (_ != null && !_.equals("")) //$NON-NLS-1$
                {
                    out.add(_);
                }
                break;
            }
            s1 = s2;
            s1 += pattern.length();
        }
        return out;
    }
    
    private static class CustomRegistrationEditor extends PropertyEditorSupport
    {
        private Map<Long, Registration> registrationMap;
        
        public CustomRegistrationEditor(List<Registration> registrations)
        {
            this.registrationMap = new HashMap<Long, Registration>(registrations.size());
            for (Registration registration : registrations)
            {
                this.registrationMap.put(registration.getId(), registration);
            }
        }
        
        /**
         * 
         * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
         */
        @Override
        public void setAsText(String text) throws IllegalArgumentException
        {
            if (null == text)
            {
                throw new IllegalArgumentException("Null registration value"); //$NON-NLS-1$
            }
            setValue(this.registrationMap.get(Long.valueOf(text)));
        }
        
        /**
         * 
         * @see java.beans.PropertyEditorSupport#getAsText()
         */
        @Override
        public String getAsText()
        {
            Object val = getValue();
            if ((null == val) || !(val instanceof Registration))
            {
                return ""; //$NON-NLS-1$
            }
            return ((Registration)val).getId().toString();
        }
    }
    
}
