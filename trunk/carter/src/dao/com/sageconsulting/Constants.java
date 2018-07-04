/*
 * Constants.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting;

/**
 * Constant values used throughout the application.
 */
public class Constants
{
    /** The name of the ResourceBundle used in this application */
    public static final String BUNDLE_KEY = "ApplicationResources"; //$NON-NLS-1$

    /** The encryption algorithm key to be used for passwords */
    public static final String ENC_ALGORITHM = "algorithm"; //$NON-NLS-1$

    /** A flag to indicate if passwords should be encrypted */
    public static final String ENCRYPT_PASSWORD = "encryptPassword"; //$NON-NLS-1$

    /** File separator from System properties */
    public static final String FILE_SEP = System.getProperty("file.separator"); //$NON-NLS-1$

    /** User home from System properties */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP; //$NON-NLS-1$

    /** The name of the configuration hashmap stored in application scope. */
    public static final String CONFIG = "appConfig"; //$NON-NLS-1$

    /**
     * Session scope attribute that holds the locale set by the user. By setting
     * this key to the same one that Struts uses, we get synchronization in
     * Struts w/o having to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE"; //$NON-NLS-1$

    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm"; //$NON-NLS-1$

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList"; //$NON-NLS-1$

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered"; //$NON-NLS-1$

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "admin"; //$NON-NLS-1$

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "user"; //$NON-NLS-1$

    /**
     * The name of the user's role list, a request-scoped attribute when
     * adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles"; //$NON-NLS-1$

    /**
     * The name of the available roles list, a request-scoped attribute when
     * adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles"; //$NON-NLS-1$
    
    /**
     * The name of the cities that are currently supported.
     */
    public static final String AVAILABLE_CITIES = "availableCities"; //$NON-NLS-1$
    
    /**
     * The name of the cookie and session variable that tracks what city the user is using.
     */
    public static final String CITY_TOKEN = "city"; //$NON-NLS-1$

    /**
     * The name of the CSS Theme setting.
     */
    public static final String CSS_THEME = "csstheme"; //$NON-NLS-1$
}
