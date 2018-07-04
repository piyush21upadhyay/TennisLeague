/*
 * RegistrationEntry.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @hibernate.class table="regentry"
 */
public class RegistrationEntry extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 5448737544447546580L;

    private Long id;
    private Integer version;
    private Registration registration;
    private User user;
    private String promotionCode;
    private Integer paymentType;
    private Integer cardType;
    private String cardNumber;
    private String cardExpiration;
    private String securityCode;
    private String responseCode;
    private String responseCodeText;
    private String approvalCode;
    private String transactionId;
    private String md5HashServer;
    private String firstName;
    private String lastName;
    private Address billingAddress = new Address();

    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @hibernate.version
     */
    public Integer getVersion()
    {
        return this.version;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.many-to-one column="registration_id" not-null="true"
     */
    public Registration getRegistration()
    {
        return this.registration;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.many-to-one column="user_id" not-null="true"
     */
    public User getUser()
    {
        return this.user;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="promo_code"
     */
    public String getPromotionCode()
    {
        return this.promotionCode;
    }
    
    /**
     * 
     * @return
     */
    public Integer getPaymentType()
    {
        return this.paymentType;
    }
    
    /**
     * 
     * @return
     */
    public Integer getCardType()
    {
        return this.cardType;
    }
    
    /**
     * 
     * @return
     */
    public String getCardNumber()
    {
        return this.cardNumber;
    }
    
    /**
     * 
     * @return
     */
    public String getCardExpiration()
    {
        return this.cardExpiration;
    }
    
    /**
     * 
     * @return
     */
    public String getSecurityCode()
    {
    	return this.securityCode;
    }

    /**
     * 
     * @return
     * 
     * @hibernate.property column="response_code"
     */
    public String getResponseCode()
    {
        return this.responseCode;
    }

    /**
     * 
     * @return
     * 
     * @hibernate.property column="response_code_text"
     */
    public String getResponseCodeText()
    {
        return this.responseCodeText;
    }

    /**
     * 
     * @return
     * 
     * @hibernate.property column="transaction_id"
     */
    public String getTransactionId()
    {
        return this.transactionId;
    }

    /**
     * 
     * @return
     * 
     * @hibernate.property column="approval_code"
     */
    public String getApprovalCode()
    {
        return this.approvalCode;
    }

    /**
     * 
     * @return
     * 
     * @hibernate.property column="md5_hash_server"
     */
    public String getMD5HashServer()
    {
        return this.md5HashServer;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    /**
     * 
     */
    public Address getBillingAddress()
    {
        return this.billingAddress;
    }

    public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }
    
    public void setRegistration(Registration reg)
    {
        this.registration = reg;
    }
    
    public void setUser(User u)
    {
        this.user = u;
    }
    
    public void setPromotionCode(String code)
    {
        this.promotionCode = code;
    }
    
    public void setPaymentType(Integer type)
    {
        this.paymentType = type;
    }
    
    public void setCardType(Integer type)
    {
        this.cardType = type;
    }
    
    /**
     * @spring.validator type="required"
     * @spring.validator type="minlength" msgkey="errors.minlength"
     * @spring.validator-args arg1resource="${var:minlength}"
     * @spring.validator-var name="minlength" value="15"
     * 
     * @spring.validator type="maxlength" msgkey="errors.creditCardInfo.maxlength"
     * @spring.validator-args arg2resource="${var:maxlength}" 
     * @spring.validator-var name="maxlength" value="16"
     * 
     * @spring.validator type="customCreditCard" msgkey="errors.creditCardInfo.both"
     * @spring.validator-args arg3resource="registrationEntry.cardNumber"
     * @spring.validator-args arg3resource="registrationEntry.securityCode"
     * @spring.validator-var name="secondProperty" value="securityCode"
     */
    public void setCardNumber(String number)
    {
        this.cardNumber = number;
    }
    
    /**
     * @spring.validator type="required"
     * @spring.validator type="mask" msgkey="errors.expiry"
     * @spring.validator-var name="mask" value="${expiry}"
     */
    public void setCardExpiration(String exp)
    {
        this.cardExpiration = exp;
    }
    
    /**
     * @spring.validator type="required"
     * @spring.validator type="minlength" msgkey="errors.minlength"
     * @spring.validator-args arg1resource="${var:minlength}"
     * @spring.validator-var name="minlength" value="3"
     * 
     * @spring.validator type="maxlength" msgkey="errors.creditCardInfo.maxlength"
     * @spring.validator-args arg2resource="${var:maxlength}" 
     * @spring.validator-var name="maxlength" value="4"
     */
    public void setSecurityCode(String code)
    {
    	this.securityCode = code;
    }
    
    public void setResponseCode(String code)
    {
        this.responseCode = code;
    }
    
    public void setResponseCodeText(String text)
    {
        this.responseCodeText = text;
    }
    
    public void setTransactionId(String tid)
    {
        this.transactionId = tid;
    }
    
    public void setApprovalCode(String code)
    {
        this.approvalCode = code;
    }
    
    public void setMD5HashServer(String server)
    {
        this.md5HashServer = server;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setFirstName(String name)
    {
        this.firstName = name;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setLastName(String name)
    {
        this.lastName = name;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setBillingAddress(Address addr)
    {
    	this.billingAddress = addr;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof RegistrationEntry))
        {
            return false;
        }

        final RegistrationEntry registrationEntry = (RegistrationEntry)o;

        return this.user.equals(registrationEntry.user) &&
            this.registration.equals(registrationEntry.getRegistration());
    }

    @Override
    public int hashCode()
    {
        int hashCode = (null == this.user) ? 29 : this.user.hashCode();
        hashCode = 29 * hashCode + ((null == this.registration) ? 1 : this.registration.hashCode());
        return hashCode;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            append("user", this.user). //$NON-NLS-1$
            append("registration", this.registration).toString(); //$NON-NLS-1$
    }
}
